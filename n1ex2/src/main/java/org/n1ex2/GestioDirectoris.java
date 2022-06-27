package org.n1ex2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

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
}
