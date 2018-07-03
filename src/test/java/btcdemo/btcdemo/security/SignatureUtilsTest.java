package btcdemo.btcdemo.security;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

/**
 * 数字签名测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignatureUtilsTest {


    @Test
    public void testSign() throws Exception {
        System.out.println();
        System.out.println("===== sign begin =====");
        System.out.println();

        //建立两套公私钥对
        Map<String, Object> rsaMap = RsaUtils.initKey();
        byte[] rsaPublicKey = RsaUtils.getPublicKey(rsaMap);
        byte[] rsaPrivateKey = RsaUtils.getPrivateKey(rsaMap);

        Map<String, Object> signMap = RsaUtils.initKey();
        PublicKey signPublicKey = RsaUtils.restorePublicKey((RsaUtils.getPublicKey(signMap)));
        PrivateKey signPrivateKey = RsaUtils.restorePrivateKey(RsaUtils.getPrivateKey(signMap));


        String text = "hello";


        /** 假设现在A签名后向B发送消息
         * A用B的公钥进行加密
         * 用自己A的私钥进行签名
         */
        byte[] encodedText = RsaUtils.encryptByPublicKey(text.getBytes(), rsaPublicKey);
        byte[] signature = SignatureUtils.sign(signPrivateKey, text.getBytes());



        /**
         * 现在B收到了A的消息，进行两步操作
         * 用B的私钥解密得到明文
         * 将明文和A的公钥进行验签操作
         */
        byte[] decodedText = RsaUtils.decryptByPrivateKey( encodedText, rsaPrivateKey);
        boolean signBoolean = SignatureUtils.verify(signPublicKey, signature, decodedText);

        System.out.println("加密前： "+text);
        System.out.println("解密后:  " + new String(decodedText));
        System.out.println("数字签名结果： " + signBoolean);



        System.out.println();
        System.out.println("===== sign end =====");
        System.out.println();
    }

}
