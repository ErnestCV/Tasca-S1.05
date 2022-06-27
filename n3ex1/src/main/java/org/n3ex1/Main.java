package org.n3ex1;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        Encriptacio encriptacio = new Encriptacio();

        SecretKey key = encriptacio.generateKey(128, "AES");
        IvParameterSpec iv = encriptacio.generateIv();

        File arxiuOriginal = new File("C:\\Users\\ecv-s\\IdeaProjects\\Tasca-S1.05\\n3ex1\\src\\main\\resources\\directoris.txt");
        File arxiuEncriptat = new File("C:\\Users\\ecv-s\\IdeaProjects\\Tasca-S1.05\\output.txt");

        encriptacio.encripta(key, iv, arxiuOriginal, arxiuEncriptat);
        encriptacio.desencripta(key, iv, arxiuOriginal, arxiuEncriptat);
    }
}