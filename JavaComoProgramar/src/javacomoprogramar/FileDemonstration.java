package javacomoprogramar;

import java.io.File;
import java.util.Scanner;

public class FileDemonstration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file or directory name: ");
        analyzePath(input.nextLine());
    }
    
    public static void analyzePath(String path) {
       //cria o objeto file com base na entrada do usuario
        File name = new File(path);
        
        if(name.exists()){
            System.out.println(name.getName()+" existes \n"+
                    (name.isFile() ?"is file" : "is not a file\n")+
                    (name.isDirectory() ? "is a directory" : "is not a directoryt")+"\n"+
                    (name.isAbsolute() ? "is absolute path" : "is not a absolute path")+
                    "\nLas modified: "+name.lastModified()+
                    "\nPath: "+name.getPath() +
                    "\nAbsoluty path: "+name.getAbsolutePath()+
                    "\nParent: "+name.getParent());
            if(name.isDirectory())
            {
                String[] directory = name.list();
                for(String directoryName: directory)
                    System.out.println(directoryName);
            }
        }
        else
            System.out.printf("%s %s",path,"does not exist");
    }
}
