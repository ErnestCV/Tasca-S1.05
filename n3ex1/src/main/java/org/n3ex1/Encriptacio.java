package org.n3ex1;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Encriptacio {

    private static Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public SecretKey generateKey(int n, String algorithm) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
            keyGenerator.init(n);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public void encripta(SecretKey key, IvParameterSpec iv, File arxiuOriginal, File arxiuEncriptat) {

        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);

            FileInputStream inputStream = new FileInputStream(arxiuOriginal);
            FileOutputStream outputStream = new FileOutputStream(arxiuEncriptat);

            byte[] buffer = new byte[64];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byte[] output = cipher.update(buffer, 0, bytesRead);
                if (output != null){
                    outputStream.write(output);
                }
            }
            byte[] outputBytes = cipher.doFinal();
            if (outputBytes != null){
                outputStream.write(outputBytes);
            }
            inputStream.close();
            outputStream.close();

        } catch (InvalidKeyException | InvalidAlgorithmParameterException | IOException | IllegalBlockSizeException |
                 BadPaddingException e) {
            e.printStackTrace();
        }
    }

    public void desencripta(SecretKey key, IvParameterSpec iv, File arxiuEncriptat, File arxiuDesencriptat) {

        try {
            cipher.init(Cipher.DECRYPT_MODE, key, iv);

            FileInputStream inputStream = new FileInputStream(arxiuEncriptat);
            FileOutputStream outputStream = new FileOutputStream(arxiuDesencriptat);

            byte[] buffer = new byte[64];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byte[] output = cipher.update(buffer, 0, bytesRead);
                outputStream.write(output);
            }

            byte[] outputBytes = cipher.doFinal();
            if (outputBytes != null) {
                outputStream.write(outputBytes);
            }
            inputStream.close();
            outputStream.close();

        } catch (InvalidKeyException | InvalidAlgorithmParameterException | IOException | IllegalBlockSizeException |
                 BadPaddingException e) {
            e.printStackTrace();
        }


    }

}
