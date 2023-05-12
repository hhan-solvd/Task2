package com.solvd.app.uniquewordscalculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UniqueWordsCalculator {
    private static final Logger LOGGER = LogManager.getLogger(UniqueWordsCalculator.class);

    public static void addContentsToFile(String contents) {
        String fileName = "src/main/resources/input.txt";

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            writer.println(contents);
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Failed to write the contents to file: " + e.getMessage());
        }
    }

    public static void calculateUniqueWords(String inputFile) throws IOException {
        File outputFile = new File("src/main/resources/output.txt");
        String fileContents = FileUtils.readFileToString(new File(inputFile), "UTF-8");
        String[] words = StringUtils.split(fileContents);

        // Use set to store unique words
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }

        FileUtils.writeStringToFile(outputFile, "There are " + uniqueWords.size() +
                " unique words in the file.", "UTF-8");
    }
}
