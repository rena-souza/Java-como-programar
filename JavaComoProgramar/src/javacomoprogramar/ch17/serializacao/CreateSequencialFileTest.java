package javacomoprogramar.ch17.serializacao;

/**
 *
 * @author renan.souza
 */
public class CreateSequencialFileTest {
    public static void main(String[] args) {
        CreateSequentialFile application = new CreateSequentialFile();
        
        application.openFile();
        application.addRecords();
        application.closeFile();
    }
}
