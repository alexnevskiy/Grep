import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Grep{

    private String word, inputName;
    private boolean ignore;

    public Grep(String regex, String inputFile, boolean ignoreWordCase) {
        word = regex;
        inputName = inputFile;
        ignore = ignoreWordCase;
    }

    public List<String> finder() throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(new File(inputName)));
        String line = buffer.readLine();
        List<String> answer = new ArrayList<String>();
    }
}
