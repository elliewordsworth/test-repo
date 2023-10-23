/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  CryptoException
 *  CryptoUtils
 */
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import CryptoUtils;
import CryptoException;

public class CryptoUtilsDecrypt {
    public static String getMD5(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string.getBytes(), 0, string.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        }
        catch (Exception exception) {
            System.err.println(exception);
            return "error";
        }
    }

    public static void main(String[] args) {
        String[] arrstring = {"test"};
        if (arrstring.length > 0) {
            System.out.println(CryptoUtilsDecrypt.getMD5(arrstring[0]));
            if ("98f6bcd4621d373cade4e832627b4f6".equals(CryptoUtilsDecrypt.getMD5(arrstring[0]))) {
                String string = "onZivYoKyn83vlkj";
                File file = new File("flag.enc");
                File file2 = new File("output.txt");
                try {
                    CryptoUtils.decrypt((String)string, (File)file, (File)file2);
                }
                catch (CryptoException cryptoException) {
                    System.out.println(cryptoException.getMessage());
                    cryptoException.printStackTrace();
                }
            } else {
                System.out.println("Wrong password");
            }
        } else {
            System.out.println("Usage: java CryptoUtilsDecrypt password");
        }
    }
}
