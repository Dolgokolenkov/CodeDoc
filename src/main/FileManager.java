/*Copyright (c) 2010-2023. LUKOIL-Engineering Limited KogalymNIPINeft Branch Office in Tyumen
Данным программным кодом владеет Филиал ООО "ЛУКОЙЛ-Инжиниринг" "КогалымНИПИнефть" в г.Тюмени*/
package main;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class FileManager {
    private final HashMap<String,String[]> extensions;
    private final String directory;
    private final String mask;
    private  String sapmle;
    private Boolean change;
    public FileManager(String d, String m, String t, String r){
        extensions=new HashMap<>();
        directory=d;
        mask=CheckMask(m);
        SearchSample(t);
        CheckChange(r);
        InitializeExtensionsMap();
    }

    private void InitializeExtensionsMap(){
        extensions.put("html",new String[]{"<!--","-->"});
        extensions.put("xml",new String[]{"<!--","-->"});
        extensions.put("java",new String[]{"/*","*/"});
        extensions.put("js",new String[]{"/*","*/"});
        extensions.put("ts",new String[]{"/*","*/"});
        extensions.put("resource",new String[]{"#","#"});
        extensions.put("properties",new String[]{"#","#"});
        extensions.put("py",new String[]{"'''\n","\n'''"});
    }
    private String FindExtension(String path){
        var files=path.split("\\.");
        return files[files.length-1];
    }
    private void CheckFiles(String dir){
        File folder=new File(dir);
        File[] files=folder.listFiles();
        for (int i=0; i<files.length; i++)
        {
           EditFile(files[i]);
        }
    }

    public void CheckFiles(){
        File folder=new File(directory);
        File[] files=folder.listFiles();
        for (int i=0; i<files.length; i++)
        {
            EditFile(files[i]);
        }
    }
    private void EditFile(File file){
        if(file.isDirectory()){
            CheckFiles(file.getAbsolutePath());
        }
        else if(file.getName().split("\\.").length>1
                && file.isFile()
                && MaskHandler.HandleMask(mask,file.getName(),extensions)){
            Path path=Paths.get(file.getAbsolutePath());
            try{
                var previousText=ReadFile(file.getAbsolutePath());
                if(!previousText.contains(sapmle)){
                    BufferedWriter writer=Files.newBufferedWriter(path,StandardOpenOption.TRUNCATE_EXISTING);
                    writer.close();
                    var extension=FindExtension(file.getPath());
                    var handleText="";
                    if(extensions.containsKey(extension)){
                        handleText=HandleFile(file,extension,previousText);
                    }
                    try {
                        Files.write(path,handleText.getBytes(),StandardOpenOption.APPEND);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                else System.out.println(file.getPath()+" прочитан");
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    private String HandleFile(File file,String extension,String previousText){
        var text=previousText;
        var leftCom=extensions.get(extension)[0];
        var rightCom=extensions.get(extension)[1];
        if(previousText.contains(extensions.get(extension)[0])){
            var countSymbols=extensions.get(extension)[0].length();
            var firstSymbols=text.substring(0,countSymbols);
            boolean isFirst=firstSymbols.contains(extensions.get(extension)[0]);
            if(isFirst && change){
                text=ChangeCopyRight(file,extension,previousText);
            }
            else if(!isFirst){
                text=leftCom+sapmle+rightCom+'\n'+previousText;
                System.out.println(file.getPath()+" добавлено");
            }
            else if(isFirst && !change){
                text=previousText;
                System.out.println(file.getPath()+" пропущено");
            }
        }
        else{
            text=leftCom+sapmle+rightCom+'\n'+previousText;
            System.out.println(file.getPath()+" добавлено");
        }
        return text;
    }


    private String ChangeCopyRight(File file,String extension,String text){
        var countSymbols=extensions.get(extension)[1].length();
        var secondExtension=extensions.get(extension)[1];
        for (int i=countSymbols;i<text.length();i++){
            if(text.charAt(i)==secondExtension.charAt(0)){
                if(text.substring(i,i+countSymbols).contains(secondExtension)){
                    var resultText=text.substring(i+countSymbols);
                    System.out.println(file.getPath()+" заменено");
                    return extensions.get(extension)[0]+sapmle+extensions.get(extension)[1]+resultText;
                }
            }
        }
        return text;
    }

    private void CheckChange(String r){
        if(r.toLowerCase().equals("да")){
            change=true;
        }
        else{
            change=false;
        }
    }
    private void SearchSample(String way){
        var result=ReadFile(way);
        if(result=="Не удается прочитать файл:"+way){
            System.out.println("Не получилось прочитать шаблон");
        }
        else{
            sapmle=result;
        }
    }

    public static String ReadFile(String p){
        try{
            FileReader reader=new FileReader(p);
            int c;
            String text="";
            while((c=reader.read())!=-1){
                text+=(char)c;
            }
            var resultText=text;
            reader.close();
            return resultText;
        }
        catch (IOException e) {
            System.out.println("Не удается прочитать файл:"+p);
        }
        return "";
    }

    private static String CheckMask(String _mask){
        if(_mask.trim().length() == 0){
            return "*.*";
        }
        else return _mask;
    }
}
