package org.n3ex1;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {

        Encriptacio encriptacio = new Encriptacio();

        SecretKey key = null;
        IvParameterSpec iv = null;
        try {
            key = encriptacio.generateKey(128);
            iv = encriptacio.generateIv();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String encriptat = encriptacio.encripta("bla", key, iv);
        System.out.println(encriptat);
        String desencriptat = encriptacio.desencripta(encriptat, key, iv);
        System.out.println(desencriptat);

    }
}