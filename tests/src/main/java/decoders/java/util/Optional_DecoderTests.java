package decoders.java.util;

import java.util.Optional;

@SuppressWarnings({"unused", "OptionalUsedAsFieldOrParameterType", "UnnecessaryUnboxing"})
public final class Optional_DecoderTests {

    public static int test_0(final Optional<?> obj) {
        if (!obj.isPresent())
            return 0;

        final Object value = obj.get();

        if (value instanceof Integer && ((Integer) value).intValue() == 123)
            return 1;

        if ("ABC".equals(value))
            return 2;

        return 3;
    }

}
