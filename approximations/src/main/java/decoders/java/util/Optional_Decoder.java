package decoders.java.util;

import decoders.BaseDecoder;
import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Arrays;
import java.util.Optional;

@DecoderFor(Optional.class)
public class Optional_Decoder extends BaseDecoder implements ObjectDecoder {
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        T result = null;
        {
            JcField value = getField(approx.getDeclaredFields(), "value");

            T valueDecoded = approxData.decodeField(value);
            if (valueDecoded != null) {
                JcMethod m_of = getMethod(approx.getDeclaredMethods(), "ofNullable", "java.lang.Object");

                result = decoder.invokeMethod(m_of, Arrays.asList(valueDecoded));
            } else {
                JcMethod m_empty = getMethod(approx.getDeclaredMethods(), "empty");

                result = decoder.invokeMethod(m_empty, Arrays.asList());
            }
        }
        return result;
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
