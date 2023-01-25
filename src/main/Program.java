/*Copyright (c) 2010-2023. LUKOIL-Engineering Limited KogalymNIPINeft Branch Office in Tyumen
Данным программным кодом владеет Филиал ООО "ЛУКОЙЛ-Инжиниринг" "КогалымНИПИнефть" в г.Тюмени*/

package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
   public static void main(String[] args) throws IOException {
        File currentDirectory = new File(System.getProperty("user.dir"));
        Scanner in=new Scanner(System.in);
        var d="";
        while (true){
            System.out.print("Введите директорию:");
            d=in.nextLine();
            System.out.println("");
            File dir=new File(d);
            if(!dir.isDirectory()){
                System.out.println("Такой файл не найден!");
                System.out.print("Можно использовать текущую директорию:"+currentDirectory.getPath()+"(Y/N)");
                var n=in.nextLine();
                if(n.equals("Y")){
                    d=currentDirectory.getPath();
                    break;
                }
            }
            else break;
        }

        System.out.print("Введите маску:");
        var m=in.nextLine();
        if (m.split("\\.").length<2){
            System.out.println("Такая маска не может быть использована, поэтому будет уствновлена маска по умолчанию:*.*");
            m="*.*";
        }
        System.out.println("");
        var t="";
        while (true){
            System.out.print("Введите путь к шаблону:");
            t=in.nextLine();
            System.out.println("");
            File dir=new File(t);
            if(!dir.isFile()){
                System.out.println("Такой файл не найден!");
            }
            else break;
        }

        System.out.print("Нужно ли заменять копирайт?(Да/Нет)");
        var r=in.nextLine();
        System.out.println("");
        System.out.print("Текущие настройки:\n" +
                         "Директория:"+d+"\n" +
                         "Шаблон:"+t+"\n" +
                         "Маска:"+m+"\n" +
                         "Заменять копирайт:"+r+"\n" +
                         "Настройки подходят?(Y/N)");
        var ok=in.nextLine();
        System.out.println("");
        if(ok.equals("Y")){
            FileManager manager=new FileManager(d,m,t,r);
            manager.CheckFiles();
        }

    }
}
