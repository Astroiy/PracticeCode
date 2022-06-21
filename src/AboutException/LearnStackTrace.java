package AboutException;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LearnStackTrace {
    public static void main(String[] args) {
        var t = new Throwable();
        var out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        String description = out.toString();
        System.out.println(description);
    }
}
