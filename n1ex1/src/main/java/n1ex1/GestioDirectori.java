package n1ex1;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class GestioDirectori {

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

}
