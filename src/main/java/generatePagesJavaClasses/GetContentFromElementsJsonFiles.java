package generatePagesJavaClasses;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import com.google.gson.Gson;
import handleFilesAndPaths.GetDirectoriesAndFiles.GetDirectoriesAndFiles;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import utils.Element;


public class GetContentFromElementsJsonFiles {
    public static Collection<File> getJsonFilesFromElementsJsonFilesDirectory() {
        return FileUtils.listFiles(new File(GetDirectoriesAndFiles.getElementsJsonFilesDirectory()), new String[]{"json"}, true);
    }

    public static String getContentsOfJsonFile(File jsonFile) {
        try {
            return FileUtils.readFileToString(jsonFile, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Element[] getElementsArrayFromJsonContents(String jsonContent) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonContent, Element[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
