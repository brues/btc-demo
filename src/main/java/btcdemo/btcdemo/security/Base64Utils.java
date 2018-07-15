package btcdemo.btcdemo.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * base64工具
 *
 * @author blues
 */
public class Base64Utils {


    /**
     * 将字符串加密为base64
     * @param before
     * @return
     */
    public static String toBase64(byte[] before){
        return (new BASE64Encoder()).encodeBuffer(before);
    }

    /**
     * 将加密为base64后的字符串解密为原文
     * @param base64
     * @return
     */
    public static byte[] fromBase64(String base64) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(base64);
    }
}
