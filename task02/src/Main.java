import java.io.File; 
import java.io.IOException;
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
import java.util.Scanner;

public class Main{

    // create method to access files in folder and hence add to file obj
    public static void addFile(File directory, List<File> files) {
        File[] flist = directory.listFiles();

        if (flist != null) {
            for (File file : flist) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    addFile(file, files);
                }
            }
        }
    }

    public static void main (String [] args) throws IOException{

            // create new HashMaps to store word count and nextwords count
            Map<String, Integer> count = new HashMap<>();
            Map<String, Map<String, Integer>> nextWords = new HashMap<>();

            // create file obj for accessing the text folder from args[0]
            File file = new File(args[0]);

            // create list for storing files 'extracted' after being added
            List<File> fileList = new ArrayList<>();
            addFile(file, fileList);

            // create for loop to go through each file in the list
            for (File f: fileList){

                // create while loop to check if not empty, read the file
                while (f!= null){

                    // create scanner to read text file 'f'
                    Scanner scan = new Scanner(f); 
                    while (scan.hasNext()) { 
                        String line = scan.nextLine(); 
                        line = line.replaceAll("[^a-zA-Z0-9\\s]", ""); 
                        String[] words = line.split("\\s+"); 

                        // create for loop to loop through each word to check 
                        for (int i = 0; i < words.length - 1; i++) { 
                            String thisWord = words[i];
                            String nextWord = words[i + 1];

                            count.put(thisWord, count.getOrDefault(thisWord, 0) + 1);
                            // nextWords.put()

                            nextWords.put(nextWord, nextWords.get(nextWord, 0) + 1);
                        }

                    }

                    scan.close();
                } 
            }

        } 
        }