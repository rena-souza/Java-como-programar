package javacomoprogramar.ch17;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author renan.souza
 */
public class FileDemonstration extends JFrame{
    private JTextArea outputArea;
    private JScrollPane scrollPane;
    
    public FileDemonstration(){
        super("Testing class file");
        
        outputArea = new JTextArea();
        
        scrollPane = new JScrollPane(outputArea);
        
        add(scrollPane, BorderLayout.CENTER);
        
        setSize(400,400);
        setVisible(true);
        
        analyzePath();
    }
    
    private File getFileOrDirectory(){
        //exibe o diálogo de arquivo para que o usuário possa escolher o arquivo
        //a abrir
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int result = fileChooser.showOpenDialog(this);
        
        //se o usuário clicou no botão cancelno diálogo, retorna
        if(result == JFileChooser.CANCEL_OPTION)
            System.exit(1);
        
        File fileName = fileChooser.getSelectedFile();//obtém o arquivo
        
        //exibe errro se inválido
        if( (fileName == null) || fileName.getName().equals("")){
            JOptionPane.showMessageDialog(this, "Invalid Name","Invalid Name", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
        return fileName;
    }
    
    public void analyzePath(){
        //cria o objeto File com base na entrada de usuário.
        File name = getFileOrDirectory();
        
        if( name.exists() ){
            outputArea.setText(String.format("%s%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s",
                    name.getName()," exists",
                    (name.isFile() ? "is a file": "is not a file"),
                    (name.isDirectory() ? "is a directory" : "is not a directory"),
                    (name.isAbsolute() ? "is a absolute path" : "is not absolute path"),
                    "Last modified: ", name.lastModified(),
                    "Length: ", name.length(),
                    "Path: " , name.getPath(),
                    "Absolute Path: ", name.getAbsolutePath(),
                    "Parent: ", name.getParent()));
            
            if(name.isDirectory()){
                String[] directory = name.list();
                outputArea.append("\n\nDirectory contents: \n");
                
                for(String directoryName: directory)
                    outputArea.append(directoryName+"\n");
            }
        }else{
            JOptionPane.showMessageDialog(this, name+"does not exist.","ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
