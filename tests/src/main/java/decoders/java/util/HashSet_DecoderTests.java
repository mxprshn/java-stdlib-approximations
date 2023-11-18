package decoders.java.util;

import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public final class HashSet_DecoderTests {

    public static int test_0(final HashSet<Integer> obj) {
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

        return 5;
    }

}
