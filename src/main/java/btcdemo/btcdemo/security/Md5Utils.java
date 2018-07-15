package btcdemo.btcdemo.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5工具类
 *
 * @author blues
 */
public class Md5Utils {

    public static final String KEY_MD5 = "MD5";

    /**
     * 获取MD5加密
     *
     * @param before 需要加密的字符串
     * @return 加密后的字符串
     */
    public static byte[] md5(byte[] before) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance(KEY_MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(before);
        return md5.digest();
    }
}
