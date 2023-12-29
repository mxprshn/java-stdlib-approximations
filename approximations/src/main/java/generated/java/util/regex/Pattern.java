package generated.java.util.regex;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;


@Approximate(java.util.regex.Pattern.class)
public class Pattern {
    private String pattern;

    private int flags;

    private Pattern(String p, int f) {
        this.pattern = p;
        this.flags = f;
    }

    public static boolean matches(String regex, CharSequence input) {
        return Engine.makeSymbolicBoolean();
    }

    public Matcher matcher(CharSequence input) {
        return new Matcher();
    }
}
