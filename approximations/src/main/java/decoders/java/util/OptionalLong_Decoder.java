package decoders.java.util;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Collections;
import java.util.List;
import java.util.OptionalLong;

@DecoderFor(OptionalLong.class)
public class OptionalLong_Decoder implements ObjectDecoder {
    private volatile static JcField cached_OptionalLong_value = null;
    private volatile static JcField cached_OptionalLong_present = null;
    private volatile static JcMethod cached_OptionalLong_of = null;
    private volatile static Object cached_decoded_OptionalLong_empty = null;

    @SuppressWarnings({"unchecked", "ForLoopReplaceableByForEach"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        JcField f_present = cached_OptionalLong_present;
        // TODO: add class-based synchronization if needed
        if (f_present == null) {
            JcField f_value = null;
            final List<JcField> fields = approx.getDeclaredFields();
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                String name = f.getName();

                if ("value".equals(name)) {
                    f_value = f;
                    continue;
                }
                if ("present".equals(name)) {
                    f_present = f;
                }

                if (f_value != null && f_present != null)
                    break;
            }
            cached_OptionalLong_present = f_present;
            cached_OptionalLong_value = f_value;
        }

        if (approxData.getBooleanField(f_present)) {
            JcMethod m_of = cached_OptionalLong_of;
            // TODO: add class-based synchronization if needed
            if (m_of == null) {
                final List<JcMethod> methods = approx.getDeclaredMethods();
                for (int i = 0, c = methods.size(); i < c; i++) {
                    JcMethod m = methods.get(i);

                    if (!m.isStatic()) continue;
                    if (!"of".equals(m.getName())) continue;

                    cached_OptionalLong_of = m_of = m;
                    break;
                }
            }

            final long value = approxData.getLongField(cached_OptionalLong_value);
            return decoder.invokeMethod(m_of, Collections.singletonList(
                    decoder.createLongConst(value)
            ));
        } else {
            Object ctor = cached_decoded_OptionalLong_empty;
            // TODO: add class-based synchronization if needed
            if (ctor == null) {
                final List<JcMethod> methods = approx.getDeclaredMethods();
                for (int i = 0, c = methods.size(); i < c; i++) {
                    JcMethod m = methods.get(i);

                    if (!m.isStatic()) continue;
                    if (!"empty".equals(m.getName())) continue;
                    if (!m.getParameters().isEmpty()) continue;

                    return (T) (cached_decoded_OptionalLong_empty = decoder.invokeMethod(m, Collections.emptyList()));
                }
            }
            return (T) ctor;
        }
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
