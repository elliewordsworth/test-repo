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

    public static void main(String[] arrstring) {
        if (arrstring.length > 0) {
            System.out.println(CryptoUtilsDecrypt.getMD5(arrstring[0]));
            if ("0f24aab59318067beb4840e92f32a4a8".equals(CryptoUtilsDecrypt.getMD5(arrstring[0]))) {
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
