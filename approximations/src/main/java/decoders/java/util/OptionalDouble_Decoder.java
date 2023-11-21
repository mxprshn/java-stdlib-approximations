package decoders.java.util;

import decoders.BaseDecoder;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

@DecoderFor(OptionalDouble.class)
public class OptionalDouble_Decoder implements ObjectDecoder {
    private volatile static JcField cached_OptionalDouble_value = null;
    private volatile static JcMethod cached_OptionalDouble_of = null;
    private volatile static Object cached_decoded_OptionalDouble_empty = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcField f_value = cached_OptionalDouble_value;
        // TODO: add class-based synchronization if needed
        if (f_value == null) {
            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                if ("value".equals(f.getName())) {
                    cached_OptionalDouble_value = f_value = f;
                    break;
                }
            }

            JcMethod Optional_empty = null;
            JcMethod Optional_of = null;
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isStatic()) continue;

                String name = m.getName();
                int paramCount = m.getParameters().size();

                if (Optional_of == null && "of".equals(name) && paramCount == 1) {
                    Optional_of = m;
                    continue;
                }
                if (Optional_empty == null && "empty".equals(name) && paramCount == 0) {
                    Optional_empty = m;
                }

                if (Optional_of != null && Optional_empty != null)
                    break;
            }

            cached_OptionalDouble_of = Optional_of;
            cached_decoded_OptionalDouble_empty = decoder.invokeMethod(Optional_empty, Collections.emptyList());
        }

        if (approximationData.getObjectField(f_value) == null)
            return (T) cached_decoded_OptionalDouble_empty;
        else
            return decoder.invokeMethod(cached_OptionalDouble_of, Collections.singletonList(
                    approximationData.decodeField(f_value)
            ));
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}