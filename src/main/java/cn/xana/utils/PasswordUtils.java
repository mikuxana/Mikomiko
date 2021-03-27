package cn.xana.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class PasswordUtils {
    /*MD5加密*/
    public static byte[] md5(String passSrc) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return md5.digest(passSrc.getBytes());
    }
    /*Base64编码*/
    public static String base64(byte[] MD5code) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] res = decoder.decode(MD5code);
        return new String(res);
    }

    public static String encode(String passSrc) {

        String pass = null;
        try {
            pass = new String(md5(passSrc));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pass;
    }
}
