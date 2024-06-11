package generatePagesJavaClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatePageJavaClass {
    public static void createJavaFileWithContent(File javaFilesDirectory, String javaFileName, String contents) {
        try {
            try (FileWriter fileWriter = new FileWriter(javaFilesDirectory + File.separator + javaFileName)) {
                fileWriter.write(contents);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
