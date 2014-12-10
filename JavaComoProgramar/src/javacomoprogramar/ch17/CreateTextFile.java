package javacomoprogramar.ch17;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class CreateTextFile {
    private Formatter output;//objeto utilizado para gerar saída de texto no arquivo
    
    public void openFile(){
        try{
            output = new Formatter("clients.txt");
        }catch (SecurityException ex){
            System.err.println("You do not have write acess to this file.");
            System.exit(1);
        }catch(FileNotFoundException ex){
            System.err.println("Error opening or creating file.");
            System.exit(1);
        }
    }
    
    //adiciona registros ao arquivo
    public void addRecords(){
        //objeto a ser gravado no arquivo
        AccountRecord record = new AccountRecord();
        
        Scanner input = new Scanner (System.in);
        
        System.out.println("To terminate input"
                + "\nType the end-of-file indicator"
                + "\nWhen you are prompted to enter input"
                + "\nOn UNIX/Linux/MAC OS X type <crtl> d then press Enter"
                + "\nOn windows type <ctrl> z then press Enter");
        
        System.out.println("Enter account number (>0) "
                + "first name, last name and balance \n? ");
        
        while(input.hasNext()){
            try{
                if(!input.hasNext())
                    break;
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());
                
                if(record.getAccount()>0){
                    output.format("%d %s %s %.2f %n", record.getAccount(),
                            record.getFirstName(),record.getLastName(),
                            record.getBalance());
                }
                else{
                    System.out.println("Account number must be greater than 0");
                }
            }catch(FormatterClosedException formatterClosedException){
                System.err.println("Invalid input. Please try again.");
                input.nextLine();//Descarta a entrada para que o usuário possta tentar novamente
            }
            System.out.println("Enter account number (>0) "
                + "first name, last name and balance \n?");
        }
    }
    
    public void closeFile(){
        if (output != null)
            output.close();
    }
    
    
}
