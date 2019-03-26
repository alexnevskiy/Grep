import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep{

    private String word, inputName;
    private boolean ignore;

    public Grep(String regex, String inputFile) {
        word = regex;
        inputName = inputFile;
    }

    public List<String> r(String word) throws IOException {
        return finder(word, false);
    }

    public List<String> v(String word) throws IOException {
        return finder(word, true);
    }

    public List<String> finder(String word, boolean ignore) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(new File(inputName)));
        String line = buffer.readLine();
        List<String> answer = new ArrayList<String>();
        Pattern p = Pattern.compile(".*");
        Matcher m = p.matcher(line);
        if (m.matches())
    }
}
