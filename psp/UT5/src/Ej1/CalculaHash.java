package Ej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculaHash {
    public static void main(String[] args) {
            for (String path : args) {
            File file = new File(path);
            if (!file.exists()) {
                System.out.println(path + " no existe.");
                continue;
            }
            if (!file.isFile()) {
                System.out.println(path + " no es un fichero.");
                continue;
            }
            try {
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                MessageDigest mdSha1 = MessageDigest.getInstance("SHA-1");
                MessageDigest mdSha256 = MessageDigest.getInstance("SHA-256");
                MessageDigest mdMd5 = MessageDigest.getInstance("MD5");
                int numBytesRead;
                while ((numBytesRead = fis.read(buffer)) != -1) {
                    mdSha1.update(buffer, 0, numBytesRead);
                    mdSha256.update(buffer, 0, numBytesRead);
                    mdMd5.update(buffer, 0, numBytesRead);
                }

                // Convierte el hash a una cadena hexadecimal y lo muestra por pantalla
                String sha1Hash = bytesToHex(mdSha1.digest());
                String sha256Hash = bytesToHex(mdSha256.digest());
                String md5Hash = bytesToHex(mdMd5.digest());
                System.out.println("Hash para fichero: "+path);
                System.out.println("\tSHA-1: " + sha1Hash);
                System.out.println("\tSHA-256: " + sha256Hash);
                System.out.println("\tMD5: " + md5Hash);

            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    // Convierte un array de bytes a una cadena hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}