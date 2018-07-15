package btcdemo.btcdemo.security;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * 数字签名测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignatureUtilsTest {

    private String publicKey;
    private String privateKey;


    @Before
    public void setUp() throws Exception {
        Map<String, Object> keyMap = RsaUtils.initKey();
        privateKey = RsaUtils.getPrivateKey(keyMap);
        publicKey = RsaUtils.getPublicKey(keyMap);
        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
    }


    @Test
    public void testSign() throws Exception {
        System.out.println();
        System.out.println("===== sign begin =====");
        System.out.println();

        //建立两套公私钥对
        Map<String, Object> rsaMap = RsaUtils.initKey();
        //公钥
        RSAPublicKey rsaPublicKey = (RSAPublicKey) rsaMap.get(RsaUtils.PUBLIC_KEY);
        //私钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) rsaMap.get(RsaUtils.PRIVATE_KEY);


        Map<String, Object> signMap = RsaUtils.initKey();
        //公钥
        RSAPublicKey signPublicKey = (RSAPublicKey) signMap.get(RsaUtils.PUBLIC_KEY);
        //私钥
        RSAPrivateKey signPrivateKey = (RSAPrivateKey) signMap.get(RsaUtils.PRIVATE_KEY);


        String text = "hello";


        /** 假设现在A签名后向B发送消息
         * A用B的公钥进行加密
         * 用自己A的私钥进行签名
         */
        byte[] encodedText = RsaUtils.encryptByPublicKey(text.getBytes(), rsaPublicKey.getEncoded());
        String base64SignPriviteKey = Base64Utils.toBase64(signPrivateKey.getEncoded());
        String signature = SignatureUtils.sign(text.getBytes(),base64SignPriviteKey);



        /**
         * 现在B收到了A的消息，进行两步操作
         * 用B的私钥解密得到明文
         * 将明文和A的公钥进行验签操作
         */
        byte[] decodedText = RsaUtils.decryptByPrivateKey( encodedText, rsaPrivateKey.getEncoded());
        String base64SignPublicKey = Base64Utils.toBase64(signPublicKey.getEncoded());
        boolean signBoolean = SignatureUtils.verify(decodedText, base64SignPublicKey, signature);

        System.out.println("加密前： "+text);
        System.out.println("解密后:  " + new String(decodedText));
        System.out.println("数字签名结果： " + signBoolean);



        System.out.println();
        System.out.println("===== sign end =====");
        System.out.println();
    }

}
