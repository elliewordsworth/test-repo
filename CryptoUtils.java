/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  CryptoException
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encrypt(String string, File file, File file2) throws CryptoException {
        CryptoUtils.doCrypto(1, string, file, file2);
    }

    public static void decrypt(String string, File file, File file2) throws CryptoException {
        CryptoUtils.doCrypto(2, string, file, file2);
    }

    private static void doCrypto(int n, String string, File file, File file2) throws CryptoException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(string.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(n, secretKeySpec);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] arrby = new byte[(int)file.length()];
            fileInputStream.read(arrby);
            byte[] arrby2 = cipher.doFinal(arrby);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(arrby2);
            fileInputStream.close();
            fileOutputStream.close();
        }
        catch (IOException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException exception) {
            throw new CryptoException("Error encrypting/decrypting file", (Throwable)exception);
        }
    }
}
