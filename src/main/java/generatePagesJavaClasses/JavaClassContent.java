package generatePagesJavaClasses;

import utils.Element;

public class JavaClassContent {
    private static StringBuilder convertElementsIntoJavaText(String javaObjectName, Element[] elements) {
        StringBuilder elementsContents = new StringBuilder();
        StringBuilder defineElements = new StringBuilder("""
                \s
                \tprivate void defineAllElements(){
                """);
        for (Element element : elements) {
            String elementLocator;
            elementsContents.append("""
                    \s
                    \tprotected String %s = "%s";
                    """.formatted(element.elementName, element.elementName));
            defineElements.append("""
                    \t\t%sElements.add(new Element("%s","%s","%s"));
                    """.formatted(javaObjectName, element.elementName, element.locatorMethod, element.locatorValue.replace("\"", "\\\"")));
        }
        defineElements.append("""
                \t}""");
        elementsContents.append(defineElements);
        return elementsContents;
    }

    public static String generateJavaPagesClassContent(String javaClassName, Element[] elements) {
        String javaObjectName = javaClassName.substring(0, 1).toLowerCase() + javaClassName.substring(1),
                javaActionsClassName = javaClassName + "Actions",
                javaActionsObjectName = javaObjectName + "Actions";
        StringBuilder elementsContents = JavaClassContent.convertElementsIntoJavaText(javaObjectName, elements);

        return """
                package pages.pages;
                
                import io.appium.java_client.android.AndroidDriver;
                import io.appium.java_client.MobileElement;
               
                /*
                import for the %s class, uncomment it after creating the actions class or if it was already created
                */
                //import pages.pagesActions.%s;
                
                import utils.Element;
                
                import java.util.ArrayList;
                import java.util.List;
                
                public class %s {
                    protected final AndroidDriver<MobileElement> androidDriver;
                    protected final List<Element> %sElements = new ArrayList<>();
                
                    public %s(AndroidDriver<MobileElement> androidDriver){
                        this.androidDriver = androidDriver;
                        this.defineAllElements();
                    }
                    \s
                    /**
                    The Actions Method will be added commented till created then uncomment it,
                    if it was already created, uncomment it directly after generating the pages java classes
                    **/
                    //public %s %s(){
                    //    return new %s(this.androidDriver);
                    //}
                    \s
                    %s
                
                }
                """.formatted(javaActionsClassName,javaActionsClassName,javaClassName, javaObjectName, javaClassName,javaActionsClassName,javaActionsObjectName,javaActionsClassName, elementsContents);
    }
}
