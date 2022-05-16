package net.openfrp.tencentcdn;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 字符to md5
     *
     * @param data 输入字符
     * @return 返回md5值
     * @throws NoSuchAlgorithmException 异常
     */
    public static String md5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return getString(data, md);
    }

    /**
     * 字符加密公共方法
     *
     * @param data data
     * @param md   md
     * @return rt
     */
    @NotNull
    private static String getString(String data, MessageDigest md) {
        md.update(data.getBytes());
        StringBuilder buf = new StringBuilder();
        byte[] bits = md.digest();
        for (int bit : bits) {
            int a = bit;
            if (a < 0) {
                a += 256;
            }
            if (a < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(a));
        }
        return buf.toString();
    }
}
