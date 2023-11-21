package decoders.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings({"unused"})
public final class AtomicInteger_DecoderTests {

    public static int test_0(final AtomicInteger obj) {
        if (obj.get() == 123)
            return 0;

        if ("5".equals(obj.toString()))
            return 1;

        return 2;
    }

}
