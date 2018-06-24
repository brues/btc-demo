package btcdemo.btcdemo.security;

import java.security.MessageDigest;

/**
 * sha256加密工具类
 *
 * @author blues
 */
public class Sha256Utils {

    /**
     * sha256算法
     * @param str
     * @return
     */
    public static String sha256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (Exception e) {
            System.out.println("getSHA256 is error" + e.getMessage());
        }
        return encodeStr;
    }

    /**
     * 将byte数组转换为无符号整数基数为16的整数参数的字符串表示形式
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            //转换为无符号整数基数为16的整数参数的字符串表示形式
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                builder.append("0");
            }
            builder.append(temp);
        }
        return builder.toString();
    }

}
