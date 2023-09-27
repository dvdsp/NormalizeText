
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TextNormalizer {
    
    public static void normalizeText(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName) );  
                
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                line = line.trim().replaceAll("\\s+", " ");

                if (!line.isEmpty()) {
                    if (firstLine) {
                        line = line.substring(0, 1).toUpperCase() + line.substring(1);
                        firstLine = false;
                    }
                    
                    line = line.replaceAll("([,.:])\\s*", "$1 ");
                    line = line.replaceAll("\\s([,.])", "$1");
                    line = line.replaceAll("([,.])\\s(\\p{Lower})", "$1 $2");
                    line = line.replaceAll("\"\\s*([^\"\\s]+)\\s*\"", "\"$1\"");
                    writer.write(line);
                }
            }
            writer.write(".");
            
        } catch (IOException e) {
            throw new IOException("*Opps..An error occurred while processing the file.", e);
        }
    }
    
    
}
