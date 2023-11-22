package decoders.java.util;

import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public class LinkedList_DecoderTests {

    public static int test_0(final LinkedList<Integer> obj) {
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
