package btcdemo.btcdemo.security;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


/**
 * 非对称加密算法测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RsaUtilsTest {


    @Test
    public void testInitKey() throws Exception {
        System.out.println();
        System.out.println("===== RSA initKey begin =====");
        System.out.println();
        Map<String, Object> keyMap = RsaUtils.initKey();
        byte[] publicKey = RsaUtils.getPublicKey(keyMap);
        byte[] privateKey = RsaUtils.getPrivateKey(keyMap);
        System.out.println("公钥：");
        System.out.println(new String(publicKey));
        System.out.println("私钥：");
        System.out.println(new String(privateKey));
        System.out.println();
        System.out.println("===== RSA initKey end =====");
        System.out.println();
    }


    @Test
    public void testPrivatePublic() throws Exception {
        System.out.println();
        System.out.println("===== RSA private-public begin =====");
        System.out.println();
        Map<String, Object> keyMap = RsaUtils.initKey();
        //公钥
        byte[] publicKey = RsaUtils.getPublicKey(keyMap);
        //私钥
        byte[] privateKey = RsaUtils.getPrivateKey(keyMap);

        String string = "hello";
        System.out.println("加密前： "+string);
        byte[] after = RsaUtils.encryptByPrivateKey(string.getBytes(), privateKey);
        byte[] before = RsaUtils.decryptByPublicKey(after, publicKey);
        System.out.println("解密后： "+new String(before));
        System.out.println();
        System.out.println("===== RSA private-public end =====");

        System.out.println();
    }


    @Test
    public void testPublicPrivate() throws Exception {
        System.out.println();
        System.out.println("===== RSA public-private begin =====");
        System.out.println();
        Map<String, Object> keyMap = RsaUtils.initKey();
        byte[] publicKey = RsaUtils.getPublicKey(keyMap);
        byte[] privateKey = RsaUtils.getPrivateKey(keyMap);

        String string = "hello";
        System.out.println("加密前： "+string);
        byte[] after = RsaUtils.encryptByPublicKey(string.getBytes(), publicKey);
        byte[] before = RsaUtils.decryptByPrivateKey(after, privateKey);
        System.out.println("解密后： "+new String(before));
        System.out.println();
        System.out.println("===== RSA public-private end =====");
        System.out.println();
    }

}
