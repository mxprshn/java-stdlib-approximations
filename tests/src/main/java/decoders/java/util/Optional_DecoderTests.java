package decoders.java.util;

import java.util.Optional;

@SuppressWarnings({"unused", "OptionalUsedAsFieldOrParameterType"})
public final class Optional_DecoderTests {

    public static int test_0(final Optional<Integer> obj) {
        if (!obj.isPresent()) {
            return 0;
        }

        if (obj.get() != 123) {
            return 1;
        }

        return 2;
    }

}
