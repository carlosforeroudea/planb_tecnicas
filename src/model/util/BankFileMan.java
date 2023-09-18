package model.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BankFileMan {

    public static boolean exists(String filePath){
        File descriptor = new File(filePath);
        return descriptor.exists();
    }

    public static boolean create(String filePath){
        Path newFilePath = Paths.get(filePath);

        try{
            Files.createFile(newFilePath);
        } catch (IOException ignore){
            Path parentPath = newFilePath.getParent();
            try {
                Files.createDirectory(parentPath);
                Files.createFile(newFilePath);
            } catch (IOException ignore2) {
                return false;
            }
        }

        return true;
    }

    public static Optional<String> read(String filePath){
        if(!exists(filePath)){
            if(create(filePath))
                return Optional.of("");
            return Optional.empty();
        }

        File descriptor = new File(filePath);
        Scanner reader;

        try {
            reader = new Scanner(descriptor);
        }catch (FileNotFoundException ignored){
            System.out.println("File not found.");
            return Optional.empty();
        }

        StringBuilder data = new StringBuilder();
        while (reader.hasNextLine()) {
            data.append(reader.nextLine());
        }
        reader.close();
        return data.toString().describeConstable();
    }

    public static boolean write(String filePath, List<String> data){
        Path path = Paths.get(filePath);

        for (final ListIterator<String> i = data.listIterator(); i.hasNext();) {
            final String element = i.next();
            i.set(element + ";");
        }

        try {
            Files.write(path, data, StandardCharsets.UTF_8);
        } catch (IOException ignore){
            return false;
        }

        return true;
    }
}
