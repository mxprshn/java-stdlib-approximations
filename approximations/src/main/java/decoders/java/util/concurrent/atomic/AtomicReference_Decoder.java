package decoders.java.util.concurrent.atomic;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.jacodb.api.JcParameter;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("ForLoopReplaceableByForEach")
@DecoderFor(AtomicReference.class)
public class AtomicReference_Decoder implements ObjectDecoder {
    private volatile static JcField cached_AtomicReference_value = null;
    private volatile static JcMethod cached_AtomicReference_ctor = null;
    private volatile static JcMethod cached_AtomicReference_set = null;

    @SuppressWarnings({"unchecked"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approx,
                                final ObjectData<T> approxData,
                                final DecoderApi<T> decoder) {
        JcMethod m_ctor = cached_AtomicReference_ctor;
        // TODO: add class-based synchronization if needed
        if (m_ctor == null) {
            JcMethod m_set = null;

            final List<JcMethod> methods = approx.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (m.isConstructor()) {
                    if (m_ctor != null) continue;
                    if (!m.getParameters().isEmpty()) continue;

                    cached_AtomicReference_ctor = m_ctor = m;
                } else {
                    if (m_set != null) continue;

                    if (!"set".equals(m.getName())) continue;

                    List<JcParameter> params = m.getParameters();
                    if (params.size() != 1) continue;
                    if (!"java.lang.Object".equals(params.get(0).getType().getTypeName())) continue;

                    cached_AtomicReference_set = m_set = m;
                }

                if (m_ctor != null && m_set != null)
                    break;
            }
        }

        return decoder.invokeMethod(m_ctor, (List<T>) Collections.EMPTY_LIST);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
        JcField f_value = cached_AtomicReference_value;
        if (f_value == null) {
            final List<JcField> fields = approx.getDeclaredFields();
            for (int i = 0, c = fields.size(); i < c; i++) {
                JcField f = fields.get(i);
                if ("value".equals(f.getName())) {
                    cached_AtomicReference_value = f_value = f;
                    break;
                }
            }
        }

        final ArrayList<T> args = new ArrayList<>();
        args.add(instance);
        args.add(approxData.decodeField(f_value)); // AtomicReference may contain itself

        decoder.invokeMethod(cached_AtomicReference_set, args);
    }
}
