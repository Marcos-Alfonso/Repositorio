package Ej2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTool {
    public static String getHash(File f) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(f);
        byte[] dataBytes = new byte[1024];
        int bytesRead = 0;

        while ((bytesRead = fis.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, bytesRead);
        }

        byte[] hashBytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < hashBytes.length; i++) {
            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        fis.close();
        return sb.toString();
    }
}
