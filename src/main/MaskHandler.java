/*Copyright (c) 2010-2023. LUKOIL-Engineering Limited KogalymNIPINeft Branch Office in Tyumen
Данным программным кодом владеет Филиал ООО "ЛУКОЙЛ-Инжиниринг" "КогалымНИПИнефть" в г.Тюмени*/

package main;

import java.util.HashMap;
import java.util.regex.Pattern;

public class MaskHandler {
    private static String MakeMaskRegex(String name){
        String regex="";
        for (var i=0;i<name.getBytes().length;i++){
            if(name.charAt(i)=='*'){
                regex+="[^\\?*:|<>/]*";
            }
            else if(name.charAt(i)=='?'){
                regex+=".";
            }
            else {
                regex+=name.charAt(i);
            }
        }
        return regex;
    }


    private static Boolean CheckMaskToFile(String regex,String fileName){
        if(Pattern.matches(regex,fileName)){
            return true;
        }
        else return false;
    }

    private static Boolean CheckFileExtension(HashMap<String,String[]> fileExtensions,String extension){
        if(fileExtensions.containsKey(extension)){
            return true;
        }
        else return false;
    }
    public static Boolean HandleMask(String maskName,String fileName,HashMap<String,String[]> fileExtensions){
            var splitFileName=fileName.split("\\.");
            String extension=splitFileName[splitFileName.length-1];
            String name=fileName.substring(0,fileName.length()-extension.length()-1);
            var splitMaskName=maskName.split("\\.");
            String extensionMask=splitMaskName[splitMaskName.length-1];
            String nameMask=maskName.substring(0,maskName.length()-extensionMask.length()-1);
            var nameRegex=MakeMaskRegex(nameMask);
            var extensionRegex=MakeMaskRegex(extensionMask);
            if(CheckFileExtension(fileExtensions,extension)
                    && CheckMaskToFile(nameRegex,name)
                    && CheckMaskToFile(extensionRegex,extension)){
                return true;
            }
            return false;
    }
}
