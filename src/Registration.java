import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Registration {
    private String path;
    private File fileObject;
    private Scanner readFile;

    Registration(String path) {
        if (path != null) {
            this.fileObject = new File(path);
            readDataFromFile();
        } else {
            throw new NullPointerException();
        }
    }

    public String getFileLine() {
        return readFile.nextLine();
    }

    private void readDataFromFile() {
        try {
            this.readFile = new Scanner(fileObject);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
