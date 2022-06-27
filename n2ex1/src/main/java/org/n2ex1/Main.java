package org.n2ex1;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        //String dirName = "C:\\Users\\formacio\\IdeaProjects\\Tasca-S1.05";

        GestioDirectoris gestioDirectoris = new GestioDirectoris();

        Configurations configs = new Configurations();
        String configPath = "C:\\Users\\ecv-s\\IdeaProjects\\Tasca-S1.05\\n2ex1\\directoris.properties";
        try {
            Configuration config = configs.properties(new File(configPath));
            String inputDir = config.getString("input.directory");
            String outputName = config.getString("output.name");
            String outputDir = config.getString("output.directory");
            gestioDirectoris.guardaDirectorisTXT(inputDir, outputName, outputDir);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }



    }
}