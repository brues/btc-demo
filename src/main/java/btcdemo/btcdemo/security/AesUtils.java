package btcdemo.btcdemo.security;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * 对称加密工具类
 *
 * @author blues
 */
public class AesUtils {


    /**
     * 注意key和加密用到的字符串是不一样的 加密还要指定填充的加密模式和填充模式 AES密钥可以是128或者256，加密模式包括ECB, CBC等
     * ECB模式是分组的模式，CBC是分块加密后，每块与前一块的加密结果异或后再加密 第一块加密的明文是与IV变量进行异或
     */
    public static final String KEY_ALGORITHM = "AES";




    public static final String ECB_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static final String CBC_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";


    /**
     * IV(Initialization Value)是一个初始值，对于CBC模式来说，它必须是随机选取并且需要保密的
     * 而且它的长度和密码分组相同(比如：对于AES 128为128位，即长度为16的byte类型数组)
     *
     */
    public static final byte[] IVPARAMETERS = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };


    /**
     * 使用ECB模式进行加密。 加密过程三步走：
     * 1. 传入算法，实例化一个加解密器
     * 2. 传入加密模式和密钥，初始化一个加密器
     * 3. 调用doFinal方法加密
     *
     * @param before
     * @return
     */
    public static byte[] aesEcbEncode(String before, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(before.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用ECB解密，也是三步走
     *
     * @param decodedText
     * @param key
     * @return
     */
    public static String aesEcbDecode(byte[] decodedText, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(decodedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * CBC加密，三步走，只是在初始化时加了一个初始变量
     * @param plainText
     * @param key
     * @param IVParameter
     * @return
     */
    public static byte[] aesCbcEncode(String plainText, SecretKey key, byte[] IVParameter) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IVParameter);
            Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            return cipher.doFinal(plainText.getBytes());

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * CBC 解密
     * @param decodedText
     * @param key
     * @param IVParameter
     * @return
     */
    public static String aesCbcDecode(byte[] decodedText, SecretKey key, byte[] IVParameter) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IVParameter);
        try {
            Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            return new String(cipher.doFinal(decodedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成秘钥
     *
     * @return
     */
    public static SecretKey initSecreKey() {
        // 创建一个KeyGenerator
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        // 生成秘钥
        byte[] secretBytes = keyGenerator.generateKey().getEncoded();
        SecretKey secretKey = new SecretKeySpec(secretBytes, KEY_ALGORITHM);
        return secretKey;
    }



}
