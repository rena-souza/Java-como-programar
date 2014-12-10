package javacomoprogramar.ch17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author renan.souza
 */
public class CreditInquiry {
    private MenuOption accountType;
    private Scanner input;
    private final static MenuOption[] choices = {MenuOption.ZERO_BALANCE, 
        MenuOption.CREDIT_BALANCE, MenuOption.DEBIT_BALANCE, MenuOption.END};
    
    private void readRecords(){
        AccountRecord record = new AccountRecord();
        
        try{
            input = new Scanner(new File("clients.txt"));
            
            while(input.hasNext()){
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());
                
                //se o tipo de conta for a adequeada, exibe o registro
                if(shouldDisplay(record.getBalance()))
                    System.out.printf("%-10d%-12s%-12s%10.2f\n", record.getAccount(),
                            record.getFirstName(), record.getLastName(), record.getBalance());
                
            }
        }catch(NoSuchElementException elementException){
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        }catch(IllegalStateException stateException){
            System.err.println("Error reading from file");
            System.exit(1);
        }catch(FileNotFoundException fileNotFoundException){
            System.err.println("File cannot be found");
            System.exit(1);
        }finally{
            if(input != null)
                input.close();
        }
    }
    
    private boolean shouldDisplay(double balance){
        if(accountType == MenuOption.CREDIT_BALANCE && balance<0)
            return true;
        else if( accountType == MenuOption.DEBIT_BALANCE && balance>0)
            return true;
        else if(accountType == MenuOption.ZERO_BALANCE && balance == 0)
            return true;
        
        return false;
    }
    
    private MenuOption getRequest(){
        Scanner textIn = new Scanner(System.in);
        int request = 1;
        
        System.out.println("Enter request\n"
                + "\t1 - List accounts with zero balances\n"
                + "\t2 - List accounts with credits balances\n"
                + "\t3 - List accounts with debit balances\n"
                + "\t4 - End or run");
        try{
            do{
                System.out.println("\n?");
                request = textIn.nextInt();
            }while(request<1 || request>4);
        }catch(NoSuchElementException elementException){
            System.err.println("Invalid input.");
            System.exit(1);

        }
        
        return choices[request - 1];
    }
    
    public void processRequest(){
        accountType = getRequest();
        
        while(accountType != MenuOption.END){
            switch(accountType){
                case ZERO_BALANCE:
                    System.out.println("\nAccounts with zero balances: \n");
                    break;
                case CREDIT_BALANCE:
                    System.out.println("\nAccounts with credit balances: \n");
                    break;
                case DEBIT_BALANCE:
                    System.out.println("\nAccounts with debit balances:\n");
                    break;
            }
            
            readRecords();
            accountType = getRequest();
        }
    }
}
