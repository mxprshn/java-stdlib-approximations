package decoders.java.util;

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

            JcMethod OptionalDouble_empty = null;
            JcMethod OptionalDouble_of = null;
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isStatic()) continue;

                String name = m.getName();
                int paramCount = m.getParameters().size();

                if (OptionalDouble_of == null && "of".equals(name) && paramCount == 1) {
                    OptionalDouble_of = m;
                    continue;
                }
                if (OptionalDouble_empty == null && "empty".equals(name) && paramCount == 0) {
                    OptionalDouble_empty = m;
                }

                if (OptionalDouble_of != null && OptionalDouble_empty != null)
                    break;
            }

            cached_OptionalDouble_of = OptionalDouble_of;
            cached_decoded_OptionalDouble_empty = decoder.invokeMethod(OptionalDouble_empty, Collections.emptyList());
        }

        if (((Double) approximationData.decodeField(f_value)) == 0.0d)
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