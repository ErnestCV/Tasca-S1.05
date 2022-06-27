package org.n1ex4;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.apache.commons.io.filefilter.TrueFileFilter.*;

public class GestioDirectoris {

    //https://docs.oracle.com/javase/tutorial/essential/io/dirs.html
    //https://zetcode.com/java/listdirectory/
    //https://www.baeldung.com/java-list-directory-files

    public List<File> mostraDirectoriAlfabeticJava(String dirName) {

        //Amb Java

        List<File> directorisListJava = new ArrayList<>();

        try (Stream<Path> stream = Files.list(Paths.get(dirName))) {
            directorisListJava = stream.map(Path::toFile).sorted().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directorisListJava;
    }

    public List<File> mostraDirectoriAlfabeticApache(String dirName) {

        //Amb la llibreria de commons-io

        //listFilesAndDirs(file(dirname), filefilter, optional dirfilter - null: no subdirectoris)
        Collection<File> directorisCollection = FileUtils.listFilesAndDirs(new File(dirName), TrueFileFilter.TRUE, null);
        List<File> directorisListApache = new ArrayList<>(directorisCollection);
        Collections.sort(directorisListApache);
        return directorisListApache;

    }

    public void mostraDirectorisRecursiuAlfabetic(String dirName) {

        //TRUE -> No filtra cap arxiu/directori; INSTANCE -> match all directories (recursiu)
        Collection<File> files = FileUtils.listFilesAndDirs(new File(dirName), TRUE, INSTANCE);
        List<File> filesList = new ArrayList<>(files);

        Collections.sort(filesList);

        filesList.forEach(file -> {
            if (file.isDirectory()) {
                System.out.println("[D] " + file);
            } else if (file.isFile()) {
                System.out.println("[F] " + file + " Last modified: " + new Date(file.lastModified()));
            }
        });
    }

    public void guardaDirectorisTXT(String dirName) {

        Collection<File> files = FileUtils.listFilesAndDirs(new File(dirName), TRUE, INSTANCE);
        List<File> filesList = new ArrayList<>(files);

        Collections.sort(filesList);

        File outputFile = new File("directoris.txt");

        filesList.forEach(file -> {
            if (file.isDirectory()) {
                try {
                    FileUtils.writeStringToFile(outputFile, "[D] " + file + "\n", "UTF-8", true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (file.isFile()) {
                try {
                    FileUtils.writeStringToFile(outputFile, "[F] " + file + " Last modified: " + new Date(file.lastModified()) + "\n", "UTF-8", true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void llegirFitxerTXT(String fileName) {

        //També:

//        try {
//            System.out.println(FileUtils.readFileToString(new File(fileName), "UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            List<String> lines = FileUtils.readLines(new File(fileName), StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}