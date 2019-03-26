import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.util.regex.Pattern;

public class GrepLauncher {
    @Option(name = "-r", usage = "Regex")
    private boolean r;

    @Option(name = "-v", usage = "Inverts filter condition")
    private boolean v;

    @Option(name = "-i", usage = "Ignore word case")
    private boolean i;

    @Argument(required = true, usage = "Search word")
    private String word;

    @Argument(required = true, usage = "Input name", index = 1)
    private String input;

    public static void main(String[] args) {
        new GrepLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException exc) {
            System.err.println(exc.getMessage());
            System.err.println("java -jar grip.jar -v -i -r word InputName");
            parser.printUsage(System.err);
            return;
        }

    }
}