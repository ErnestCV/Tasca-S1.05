package org.n2ex1;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.apache.commons.io.filefilter.TrueFileFilter.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

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

    public void guardaDirectorisTXT(String inputDir, String outputName, String outputDir) {

        Collection<File> files = FileUtils.listFilesAndDirs(new File(inputDir), TRUE, INSTANCE);
        List<File> filesList = new ArrayList<>(files);

        Collections.sort(filesList);

        outputDir += "\\";
        File outputFile = new File(outputDir, outputName);

        for (File file : filesList) {
            if (file.isDirectory()) {
                try {
                    FileUtils.writeStringToFile(outputFile, "[D] " + file + "\n", "UTF-8", true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.isFile()) {
                try {
                    FileUtils.writeStringToFile(outputFile, "[F] " + file + " Last modified: " + new Date(file.lastModified()) + "\n", "UTF-8", true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}