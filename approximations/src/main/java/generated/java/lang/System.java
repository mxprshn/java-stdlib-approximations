package generated.java.lang;

import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@Approximate(java.lang.System.class)
public class System {
    public static String getenv(String name) {
        return Engine.makeSymbolic(String.class);
    }
}
