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


        StringBuilder hexString = new StringBuilder();
        for (byte b : md.digest()) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        fis.close();
        return hexString.toString();


    }
}
