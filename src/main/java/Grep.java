import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep{

    /*private String word, inputName;
    private boolean ignore;

    public Grep(String regex, String inputFile, boolean ignoreWordCase) {
        word = regex;
        inputName = inputFile;
        ignore = ignoreWordCase;
    }

    public List<String> r(String word) throws IOException {
        return finder(word, false);
    }

    public List<String> v(String word) throws IOException {
        return finder(word, true);
    }*/

    public List<String> finder(boolean r, boolean v, boolean i, String word, String input) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(new File(input)));
        String line = buffer.readLine();
        List<String> answer = new ArrayList<String>();
        Pattern pattern;
        String regex;
        while (line != null) {
            if (r == true) {
                regex = (".*" + Pattern.quote(word) + ".*");
            } else {
                regex = word;
            }
            if (i == true) {
                pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            } else {
                pattern = Pattern.compile(regex);
            }
            Matcher m = pattern.matcher(line);
            if (m.matches()) {
            }
        }

    }
}
