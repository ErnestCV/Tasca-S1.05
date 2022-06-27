package org.n3ex1;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Main {
    public static void main(String[] args) {

        Encriptacio encriptacio = new Encriptacio();

        SecretKey key = encriptacio.generateKey(128, "AES");
        IvParameterSpec iv = encriptacio.generateIv();

        String encriptat = encriptacio.encripta("bla", key, iv);
        System.out.println(encriptat);
        String desencriptat = encriptacio.desencripta(encriptat, key, iv);
        System.out.println(desencriptat);

    }
}