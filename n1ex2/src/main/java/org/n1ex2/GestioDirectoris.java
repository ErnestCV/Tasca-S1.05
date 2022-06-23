package org.n1ex2;

import org.apache.commons.io.FileUtils;
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

import static java.nio.file.FileVisitResult.CONTINUE;

public class GestioDirectoris {

    //https://docs.oracle.com/javase/tutorial/essential/io/dirs.html
    //https://zetcode.com/java/listdirectory/
    //https://www.baeldung.com/java-list-directory-files

    public List<File> mostraDirectoriAlfabeticJava(String dirName) {

        //Amb Java

        /*
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dirName))) {
        }
         */

        List<File> directorisListJava = new ArrayList<>();

        try (Stream<Path> stream = Files.list(Paths.get(dirName))) {
            //stream.forEach(System.out::println);
            directorisListJava = stream.map(Path::toFile).sorted().toList();
        } catch (IOException e) {
            System.err.println(e);
        }
        return directorisListJava;
    }

//    public List<File> mostraDirectoriAlfabeticApache(String dirName) {
//
//        //Amb la llibreria de commons-io
//
//        //listFilesAndDirs(file(dirname), filefilter, optional dirfilter - null: no subdirectoris)
//        Collection<File> directorisCollection =  FileUtils.listFilesAndDirs(new File(dirName), TrueFileFilter.TRUE, null);
//        List<File> directorisListApache = new ArrayList<>(directorisCollection);
//        Collections.sort(directorisListApache);
//        return directorisListApache;
//
//    }

    public void mostraDirectorisRecursiuAlfabeticJava(String dirName) {

        Path path = Path.of(dirName);

//        try {
//            Files.walk(path).sorted().forEach(System.out::println);
//        } catch (IOException e) {
//            System.err.println(e);
//        }

        //System.out.println();

        //TODO ordre alfabètic
        //https://stackoverflow.com/questions/53861136/files-walkfiletree-in-lexicographical-order

        try {
            //final Set<File> files = new TreeSet<>(Comparator.comparing(File::getAbsolutePath)); //Per ordenar??
            Files.walkFileTree(path, new FileWalker());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //listfiles recursiu Files.list
        //https://stackoverflow.com/questions/2534632/list-all-files-from-a-directory-recursively-with-java

    }
}
