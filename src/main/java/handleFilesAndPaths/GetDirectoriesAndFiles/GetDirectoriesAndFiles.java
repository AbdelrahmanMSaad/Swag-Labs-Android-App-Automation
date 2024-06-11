package handleFilesAndPaths.GetDirectoriesAndFiles;

import java.nio.file.Paths;

public class GetDirectoriesAndFiles {
    private static final String src = "src",
            main = "main",
            test = "test",
            java = "java",
            pages = "pages",
            pagesElements = "pagesElements",
            resources = "resources",
            configFileName = "config.properties",
            testDataFileName = "test-data.json";

    private static final String USER_DIR = System.getProperty("user.dir");

    public static String getConfigFilePath() {
        return Paths.get(USER_DIR, src, main, resources, configFileName).toString();
    }

    public static String getPagesDirectories(){
        return Paths.get(USER_DIR,src,main,java,pages,pages).toString();
    }

    public static String getElementsJsonFilesDirectory() {
        return Paths.get(USER_DIR, src, main,java,pages,pagesElements).toString();
    }
}
