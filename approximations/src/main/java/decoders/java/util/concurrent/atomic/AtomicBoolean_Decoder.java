package decoders.java.util.concurrent.atomic;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcField;
import org.jacodb.api.jvm.JcMethod;
import org.jacodb.api.jvm.JcParameter;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@DecoderFor(AtomicBoolean.class)
public class AtomicBoolean_Decoder implements ObjectDecoder {
    private volatile JcField cached_AtomicBoolean_value = null;
    private volatile JcMethod cached_AtomicBoolean_ctor = null;

    @SuppressWarnings({"ForLoopReplaceableByForEach"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        JcField f_value = cached_AtomicBoolean_value;
        // TODO: add synchronization if needed
        if (f_value == null) {
            final List<JcField> fields = approx.getDeclaredFields();
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                if ("value".equals(f.getName())) {
                    cached_AtomicBoolean_value = f_value = f;
                    break;
                }
            }

            final List<JcMethod> methods = approx.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isConstructor()) continue;

                List<JcParameter> params = m.getParameters();
                if (params.size() != 1) continue;
                if (!"boolean".equals(params.get(0).getType().getTypeName())) continue;

                cached_AtomicBoolean_ctor = m;
                break;
            }
        }

        final int value = approxData.getIntField(f_value);
        return decoder.invokeMethod(cached_AtomicBoolean_ctor, Collections.singletonList(
                decoder.createBoolConst(value != 0)
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
