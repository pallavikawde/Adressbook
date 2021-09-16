package com.timbhuchalka;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class FileOOperations {
    private static String HOME = System.getProperty("user.home");
    private static String ADDRESS_BOOK_DIR_NAME = "all_address_books_Files";
    private static String FILE_EXT = ".txt";

    public static void createFileOfAddressBook (HashMap<String, ArrayList<Contact>> drive) {


        Path dirPath = Paths.get(HOME+"/"+ADDRESS_BOOK_DIR_NAME);

        try
        {

            if(Files.exists(dirPath)) {
                File directory = new File(String.valueOf(dirPath));
                if (directory.exists()) {
                    String[] filesPresent = directory.list();
                    if(filesPresent.length != 0) {
                        File[] filesContained = directory.listFiles();
                        for (File file : filesContained) {
                            file.delete();
                            System.out.println(file + ": deleted");
                        }
                    }
                }
                directory.delete();
                System.out.println("directory deleted : " +directory.toString());
            }
            Files.createDirectory(dirPath);
            System.out.println("folder created at "+dirPath.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> abKeySetForFileIO = drive.keySet();

        for(String conName : abKeySetForFileIO){
            StringBuffer address_book_buffer = new StringBuffer();
            for (Contact contact : drive.get(conName)) {
                String contactToWrite = contact.toString().concat("\n");
                address_book_buffer.append(contactToWrite);
            }

            Path filePath = Paths.get(HOME+"/"+ADDRESS_BOOK_DIR_NAME+"/"+conName+FILE_EXT);

            try {
                Files.createFile(filePath);
                Files.write(filePath,address_book_buffer.toString().getBytes(StandardCharsets.UTF_8));
                System.out.println("File created at : "+filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
