package javacomoprogramar.ch17;

public class CreateTextFileTest {
    public static void main(String[] args) {
        CreateTextFile app = new CreateTextFile();
        app.openFile();
        app.addRecords();
        app.closeFile();
    }
}
