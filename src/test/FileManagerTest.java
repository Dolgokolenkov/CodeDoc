/*Copyright (c) 2010-2023. LUKOIL-Engineering Limited KogalymNIPINeft Branch Office in Tyumen
Данным программным кодом владеет Филиал ООО "ЛУКОЙЛ-Инжиниринг" "КогалымНИПИнефть" в г.Тюмени*/

package test;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;


import main.FileManager;
public class FileManagerTest {
    private final String directory="C:\\Users\\danil\\Desktop\\java\\test";
    private final String samplePath="C:\\Users\\danil\\Desktop\\java\\sample.txt";

    public File CreateFolder(){
        try {
            File folder=new File(directory+"\\folder");
            folder.mkdir();
            return folder;
        }
        catch (Exception e){
            System.err.println(e);
        }
        return null;
    }

    public File CreateFolder(String directory){
        try {
            File folder=new File(directory);
            folder.mkdir();
            return folder;
        }
        catch (Exception e){
            System.err.println(e);
        }
        return null;
    }
    public File CreateFile(String fileName){
        try {
            File file=new File(directory+"\\folder\\"+fileName);
            file.createNewFile();
            return file;
        }
        catch (Exception e){
            System.err.println(e);
        }
        return null;
    }


    @Test
    public void JavaEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.java");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.java").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void HTMLEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.html");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.html").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void XMLEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.xml");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.xml").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void JSEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.js");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.js").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void TSEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.ts");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.ts").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void ResourceEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.resource");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.resource").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void PropertiesEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.properties");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.properties").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void PythonEmptyFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.py");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("'''\n"+FileManager.ReadFile(samplePath)+"\n'''").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.py").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void JavaWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.java");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="private void InitializeExtensionsMap(){\n" +
                    "        extensions.put(\"html\",new String[]{\"<!--\",\"-->\"});\n" +
                    "        extensions.put(\"xml\",new String[]{\"<!--\",\"-->\"});\n" +
                    "        extensions.put(\"java\",new String[]{\"/*\",\"*/\"});\n" +
                    "        extensions.put(\"js\",new String[]{\"/*\",\"*/\"});\n" +
                    "        extensions.put(\"ts\",new String[]{\"/*\",\"*/\"});\n" +
                    "        extensions.put(\"resource\",new String[]{\"#\",\"#\"});\n" +
                    "        extensions.put(\"properties\",new String[]{\"#\",\"#\"});\n" +
                    "    }";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.java").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void HTMLWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.html");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="<html>\n" +
                    " <head>\n" +
                    "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                    "  <title>Пример веб-страницы</title>\n" +
                    " </head>\n" +
                    " <body>\n" +
                    "  <h1>Заголовок</h1>\n" +
                    "  <!-- Комментарий -->\n" +
                    "  <p>Первый абзац.</p>\n" +
                    "  <p>Второй абзац.</p>\n" +
                    " </body>\n" +
                    "</html>";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.html").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void XMLWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.xml");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="<?xml version=\"1.0\"?>\n" +
                    "<CAT>\n" +
                    "  <NAME>Izzy</NAME>\n" +
                    "  <BREED>Siamese</BREED>\n" +
                    "  <AGE>6</AGE>\n" +
                    "  <ALTERED>yes</ALTERED>\n" +
                    "  <DECLAWED>no</DECLAWED>\n" +
                    "  <LICENSE>Izz138bod</LICENSE>\n" +
                    "  <OWNER>Colin Wilcox</OWNER>\n" +
                    "</CAT>";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.xml").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void JSWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.js");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="function hideTabContent(){\n" +
                    "        tabsContent.forEach((item)=>{\n" +
                    "            item.style.display='none';\n" +
                    "        });\n" +
                    "        tabs.forEach(item=>{\n" +
                    "            item.classList.remove('tabheader__item_active');\n" +
                    "        });\n" +
                    "    };";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.js").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void TSWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.ts");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="function hideTabContent(){\n" +
                    "        tabsContent.forEach((item)=>{\n" +
                    "            item.style.display='none';\n" +
                    "        });\n" +
                    "        tabs.forEach(item=>{\n" +
                    "            item.classList.remove('tabheader__item_active');\n" +
                    "        });\n" +
                    "    };";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.ts").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void ResourceWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.resource");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="12345";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.resource").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void PropertiesWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.properties");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="12345";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.properties").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }

    @Test
    public void PythonWithCodeFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.py");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="k=input()";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("'''\n"+FileManager.ReadFile(samplePath)+"\n'''").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.py").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }

    @Test
    public void JavaWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.java");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="/*Привет*/\n" +
                    "import java.util.Scanner;\n" +
                    "public class Program {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        System.out.println(\"Hello Java!\");\n" +
                    "        Scanner in=new Scanner(System.in);\n" +
                    "        System.out.print(\"Введите директорию:\");\n" +
                    "        var d=in.nextLine();\n" +
                    "        System.out.print(\"Введите маску:\");\n" +
                    "        var m=in.nextLine();\n" +
                    "        System.out.print(\"Введите путь к шаблону:\");\n" +
                    "        var t=in.nextLine();\n" +
                    "        System.out.print(\"Нужно ли заменять копирайт?(Да/Нет)\");\n" +
                    "        var r=in.nextLine();\n" +
                    "        FileManager manager=new FileManager(d,m,t,r);\n" +
                    "        manager.CheckFiles();\n" +
                    "    }\n" +
                    "}";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.java").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text+"\n"),true);
    }
    @Test
    public void JavaWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.java");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="/*Привет*/\n" +
                    "import java.util.Scanner;\n" +
                    "public class Program {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        System.out.println(\"Hello Java!\");\n" +
                    "        Scanner in=new Scanner(System.in);\n" +
                    "        System.out.print(\"Введите директорию:\");\n" +
                    "        var d=in.nextLine();\n" +
                    "        System.out.print(\"Введите маску:\");\n" +
                    "        var m=in.nextLine();\n" +
                    "        System.out.print(\"Введите путь к шаблону:\");\n" +
                    "        var t=in.nextLine();\n" +
                    "        System.out.print(\"Нужно ли заменять копирайт?(Да/Нет)\");\n" +
                    "        var r=in.nextLine();\n" +
                    "        FileManager manager=new FileManager(d,m,t,r);\n" +
                    "        manager.CheckFiles();\n" +
                    "    }\n" +
                    "}";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.java").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }
    @Test
    public void HTMLWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.html");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="<!--Привет-->\n" +
                    "<html></html>";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.html").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }

    @Test
    public void HTMLWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.html");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="<!--Привет-->\n" +
                    "<html></html>";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"нет");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.html").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }

    @Test
    public void XMLWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.xml");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="<!--Привет-->\n" +
                    "Всем привет";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.xml").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void XMLWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.xml");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="<!--Привет-->\n" +
                    "Всем привет";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"нет");
        manager.CheckFiles();
        var text=("<!--"+FileManager.ReadFile(samplePath)+"-->").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.xml").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }

    @Test
    public void JSWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.js");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="/*Привет*/\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.js").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void JSWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.js");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="/*Привет*/\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"нет");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.js").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }
    @Test
    public void TSWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.ts");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="/*Привет*/\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.ts").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void TSWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.ts");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="/*Привет*/\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"нет");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.ts").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }
    @Test
    public void ResourceWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.resource");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="#Привет#\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.resource").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void ResourceWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.resource");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="#Привет#\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"нет");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.resource").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }
    @Test
    public void PropertiesWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.properties");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="#Привет#\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.properties").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void PropertiesWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.properties");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="#Привет#\n" +
                    "let i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"нет");
        manager.CheckFiles();
        var text=("#"+FileManager.ReadFile(samplePath)+"#").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.properties").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }
    @Test
    public void PуthonWithOtherCopyRightAndGnangeTrueFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.py");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="'''\nПривет\n'''\n" +
                    "i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"да");
        manager.CheckFiles();
        var text=("'''\n"+FileManager.ReadFile(samplePath)+"\n'''").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.py").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
    @Test
    public void PуthonWithOtherCopyRightAndGnangeFalseFileTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.py");
        try {
            FileWriter writer=new FileWriter(file);
            var fileText="'''\nПривет\n'''\n" +
                    "i=0";
            for (var i=0;i<fileText.length();i++){
                writer.append(fileText.charAt(i));
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        FileManager manager=new FileManager(directory,"",samplePath,"нет");
        manager.CheckFiles();
        var text=("'''\n"+FileManager.ReadFile(samplePath)+"\n'''").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\"+"j.py").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),false);
    }

    @Test
    public void RecursionTest(){
        var folder=CreateFolder();
        var file=CreateFile("j.py");
        var folder2=CreateFolder(folder.getPath()+"\\lol");
        var file2=CreateFile(folder2.getName()+"\\ahaha.js");
        FileManager manager=new FileManager(directory,"",samplePath,"no");
        manager.CheckFiles();
        var text=("/*"+FileManager.ReadFile(samplePath)+"*/").toString();
        var fileText=FileManager.ReadFile(directory+"\\folder\\lol\\"+"ahaha.js").toString();
        try {
            System.gc();
            Files.delete(file.toPath());
            Files.delete(file2.toPath());
            Files.delete(folder2.toPath());
            Files.delete(folder.toPath());
        }  catch (Exception x) {
            System.err.println(x);
        }
        Assert.assertEquals(fileText.contains(text),true);
    }
}
