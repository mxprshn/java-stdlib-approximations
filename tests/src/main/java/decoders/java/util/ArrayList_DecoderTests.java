package decoders.java.util;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public final class ArrayList_DecoderTests {

    public static int test_0(final ArrayList<Integer> obj) {
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

        if (value.intValue() == 32)
            return 4;

        if (obj.size() == 2 && "[4, 5]".equals(obj.toString()))
            return 5;

        return 6;
    }

}
