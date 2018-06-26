package btcdemo.btcdemo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.SecretKey;

/**
 * 对称加密算法测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AesUtilsTest {


    /**
     * 测试生成秘钥
     */
    @Test
    public void testGenerateAESSecretKey(){
        System.out.println();
        System.out.println("===== AES generate key begin =====");
        System.out.println();
        SecretKey key = AesUtils.initSecreKey();
        System.out.println("algorithm : "+key.getAlgorithm());
        System.out.println("encoded : "+key.getEncoded());
        System.out.println("format : "+key.getFormat());
        System.out.println();
        System.out.println("===== AES generate key end =====");
        System.out.println();
    }


    @Test
    public void testEcb(){
        System.out.println();
        System.out.println("===== AES ECB begin =====");
        System.out.println();
        SecretKey key = AesUtils.initSecreKey();
        String text = "hello";
        System.out.println("加密前为："+text);
        byte[] after = AesUtils.aesEcbEncode(text, key);
        String decodeText = AesUtils.aesEcbDecode(after, key);
        System.out.println("解密后为："+decodeText);
        System.out.println();
        System.out.println("===== AES ECB end =====");
        System.out.println();
    }

    @Test
    public void testCbc(){
        System.out.println();
        System.out.println("===== AES CBC begin =====");
        System.out.println();
        SecretKey key = AesUtils.initSecreKey();
        String text = "hello world";
        System.out.println("加密前为："+text);
        byte[] after = AesUtils.aesCbcEncode(text, key, AesUtils.IVPARAMETERS);
        String afterText = AesUtils.aesCbcDecode(after, key, AesUtils.IVPARAMETERS);
        System.out.println("解密后为："+afterText);
        System.out.println();
        System.out.println("===== AES CBC end =====");
        System.out.println();
    }
}
