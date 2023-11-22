package decoders.java.util;

import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public class LinkedHashSet_DecoderTests {

    public static int test_0(final LinkedHashSet<Integer> obj) {
        if (obj.isEmpty())
            return 0;

        if (obj.size() == 5)
            return 1;

        Iterator<Integer> iter = obj.iterator();
        if (!iter.hasNext())
            return 2;

        Integer value = iter.next();
        if (value == null)
            return 3;

        if (value.intValue() == 123)
            return 4;

        if (obj.size() == 2) {
            final String numbers = obj.toString();
            if ("[4, 5]".equals(numbers) || "[5, 4]".equals(numbers))
                return 5;
        }

        return 6;
    }

}
