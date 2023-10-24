/*
 * Decompiled with CFR 0.150.
 */
import java.util.Base64;

public class FlagGen {
    public static void main(String[] arrstring) {
        String string = "Not an actual flag";
        System.out.println("flag{" + string + "}");
    }

    public static String generateFirstPart() {
        return "8ff650";
    }

    public static String generateLastPart() {
        return "7c1318";
    }

    public static String xorHex(String string, String string2) {
        char[] arrc = new char[string.length()];
        for (int i = 0; i < arrc.length; ++i) {
            arrc[i] = FlagGen.toHex(FlagGen.fromHex(string.charAt(i)) ^ FlagGen.fromHex(string2.charAt(i)));
        }
        return new String(arrc);
    }

    public static void printHint() {
        byte[] arrby = Base64.getDecoder().decode("VGhlIGZpZWxkIGZsYWcgb2YgdGhlIGZ1bmN0aW9uIG1haW4gc2hvdWxkIGFjdHVhbGx5IGJ5IGRlZmluZWQgYnkgY29uY2F0ZW5pbmcgdGhlIHhvciBvZiB0aGUgb3V0cHV0IG9mIGdlbmVyYXRlRmlyc3RQYXJ0IHdpdGggYjk1MDBiIHdpdGggdGhlIHhvciBvZiB0aGUgb3V0cHV0IG9mIGdlbmVyYXRlTGFzdFBhcnQgd2l0aCBmZWQ3MmQuIE5vdGUgdGhhdCBhbGwgdGhlc2UgZWxlbWVudHMgYXJlIGhleGFkZWNpbWFsIHN0cmluZ3Mh");
        System.out.println("Hint: " + new String(arrby));
    }

    private static int fromHex(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 65 + 10;
        }
        if (c >= 'a' && c <= 'f') {
            return c - 97 + 10;
        }
        throw new IllegalArgumentException();
    }

    private static char toHex(int n) {
        if (n < 0 || n > 15) {
            throw new IllegalArgumentException();
        }
        return "0123456789ABCDEF".charAt(n);
    }
}
