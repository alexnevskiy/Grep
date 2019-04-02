import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep{

    public static List<String> finder(boolean r, boolean v, boolean i, String word, String input) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(new File(input)));
        String line = buffer.readLine();
        List<String> answer = new ArrayList<String>();
        Pattern pattern;
        String regex;
        boolean trueOrFalse;
        if (r) {  //  Соответствие флагу -r
            regex = word;
        } else {
            regex = ".*" + Pattern.quote(word) + ".*";
        }
        if (i) {  //  Соответствие флагу -i
            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        } else {
            pattern = Pattern.compile(regex);
        }
        while (line != null) {
            Matcher m = pattern.matcher(line);
            trueOrFalse = m.matches();
            if (v) {  //  Соответствие флагу -v
                trueOrFalse = !trueOrFalse;  //  Если есть флаг -v, то инвертируется совпадение слова в файле
            }
            if (trueOrFalse) {
                answer.add(line);
            }
            line = buffer.readLine();
        }
        buffer.close();
        return answer;
    }
}