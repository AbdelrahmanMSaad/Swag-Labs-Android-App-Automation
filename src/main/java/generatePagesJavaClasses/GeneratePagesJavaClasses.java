package generatePagesJavaClasses;

import handleFilesAndPaths.GetDirectoriesAndFiles.GetDirectoriesAndFiles;
import utils.Element;

import java.io.File;

public class GeneratePagesJavaClasses {
    public static void generateJavaFiles() {
        for (File jsonFile : GetContentFromElementsJsonFiles.getJsonFilesFromElementsJsonFilesDirectory()) {
            String javaFileName = jsonFile.getName().replace(".json", ".java");
            String javaClassName = javaFileName.replace(".java", "");
            String javaClassContent = GetContentFromElementsJsonFiles.getContentsOfJsonFile(jsonFile);
            File javaClassesDirectory = new File(GetDirectoriesAndFiles.getPagesDirectories());
            if (!javaClassesDirectory.exists()) {
                javaClassesDirectory.mkdir();
            }
            Element[] mobileElements = GetContentFromElementsJsonFiles.getElementsArrayFromJsonContents(javaClassContent);
            String contents = JavaClassContent.generateJavaPagesClassContent(javaClassName,mobileElements);
            CreatePageJavaClass.createJavaFileWithContent(javaClassesDirectory,javaFileName,contents);

        }
    }


    public static void main(String[] args) {
        GeneratePagesJavaClasses.generateJavaFiles();
    }
}
