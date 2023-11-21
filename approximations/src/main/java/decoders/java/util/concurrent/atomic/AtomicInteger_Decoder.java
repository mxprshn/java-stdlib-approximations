package decoders.java.util.concurrent.atomic;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.jacodb.api.JcParameter;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@DecoderFor(AtomicInteger.class)
public class AtomicInteger_Decoder implements ObjectDecoder {
    private volatile static JcField cached_AtomicInteger_value = null;
    private volatile static JcMethod cached_AtomicInteger_ctor = null;

    @SuppressWarnings({"ForLoopReplaceableByForEach"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        JcField f_value = cached_AtomicInteger_value;
        if (f_value == null) {
            // TODO: add class-based synchronization if needed

            final List<JcField> fields = approx.getDeclaredFields();
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                if ("value".equals(f.getName())) {
                    cached_AtomicInteger_value = f_value = f;
                    break;
                }
            }

            final List<JcMethod> methods = approx.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isConstructor()) continue;

                List<JcParameter> params = m.getParameters();
                if (params.size() != 1) continue;
                if (!"int".equals(params.get(0).getType().getTypeName())) continue;

                cached_AtomicInteger_ctor = m;
                break;
            }
        }

        final int value = approxData.getIntField(f_value);
        return decoder.invokeMethod(cached_AtomicInteger_ctor, Collections.singletonList(
                decoder.createIntConst(value)
        ));
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
