package javacomoprogramar.ch17.serializacao;

/**
 *
 * @author renan.souza
 */
public class ReadSequencialFileTest {
    public static void main(String[] args) {
        ReadSequencialFile application = new ReadSequencialFile();
        
        application.openFile();
        application.readRecords();
        application.closeFile();
    }
}
