package org.n3ex1;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Encriptacio {

    private static Cipher cipher;
//    private static String key = "abcdefghijklmnop"; //16 bytes

    static {
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    public SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }

    public IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public String encripta(String text, SecretKey key, IvParameterSpec iv) {

        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] encriptat = cipher.doFinal(text.getBytes());
            return Base64.getEncoder().encodeToString(encriptat);
        } catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String desencripta(String encriptat, SecretKey key, IvParameterSpec iv) {

        try {
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] desencriptat = cipher.doFinal(Base64.getDecoder().decode(encriptat));
            return new String(desencriptat);
        } catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException e) {
            e.printStackTrace();
            return null;
        }


    }

}
