import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep{

    public static void finder(boolean r, boolean v, boolean i, String word, String input) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(new File(input)));
        String line = buffer.readLine();
        List<String> answer = new ArrayList<String>();
        Pattern pattern;
        String regex;
        boolean trueOrFalse;
        while (line != null) {
            if (r) {
                regex = (".*" + word + ".*");
            } else {
                regex = word;
            }
            if (i) {
                pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            } else {
                pattern = Pattern.compile(regex);
            }
            Matcher m = pattern.matcher(line);
            trueOrFalse = m.find();
            if (v) {
                trueOrFalse = !trueOrFalse;
            }
            if (trueOrFalse) {
                answer.add(line);
            }
            line = buffer.readLine();
        }
        buffer.close();
        for (String str : answer) System.out.println(str);
    }
}