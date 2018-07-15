package btcdemo.btcdemo.security;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;


/**
 * 非对称加密算法测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RsaUtilsTest {

    private String publicKey;
    private String privateKey;


    @Before
    public void setUp() throws Exception {
        Map<String, Object> keyMap = RsaUtils.initKey();
        publicKey = RsaUtils.getPublicKey(keyMap);
        privateKey = RsaUtils.getPrivateKey(keyMap);
        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
    }


    @Test
    public void testPrivatePublic() throws Exception {
        System.out.println();
        System.out.println("===== RSA private-public begin =====");
        System.out.println();
        Map<String, Object> keyMap = RsaUtils.initKey();
        //公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyMap.get(RsaUtils.PUBLIC_KEY);
        //私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get(RsaUtils.PRIVATE_KEY);

        String string = "hello";
        System.out.println("加密前： "+string);
        byte[] after = RsaUtils.encryptByPrivateKey(string.getBytes(), privateKey.getEncoded());
        byte[] before = RsaUtils.decryptByPublicKey(after, publicKey.getEncoded());
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
        //公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyMap.get(RsaUtils.PUBLIC_KEY);
        //私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get(RsaUtils.PRIVATE_KEY);

        String string = "hello";
        System.out.println("加密前： "+string);
        byte[] after = RsaUtils.encryptByPublicKey(string.getBytes(), publicKey.getEncoded());
        byte[] before = RsaUtils.decryptByPrivateKey(after, privateKey.getEncoded());
        System.out.println("解密后： "+new String(before));
        System.out.println();
        System.out.println("===== RSA public-private end =====");
        System.out.println();
    }

}
