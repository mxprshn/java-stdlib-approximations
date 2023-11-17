package decoders.java.util;

import decoders.BaseDecoder;
import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

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

            final ObjectData<T> valueData = approxData.getObjectField(value);
            if (valueData == null) {
                JcMethod m_empty = getMethod(approx.getDeclaredMethods(), "empty");

                result = callStatic(decoder, m_empty);
            } else {
                JcMethod m_of = getMethod(approx.getDeclaredMethods(), "of", "java.lang.Object");

                result = callStatic(decoder, m_of,
                        approxData.decodeField(value)
                );
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
