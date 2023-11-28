package decoders.java.io;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcMethod;
import org.jacodb.api.JcParameter;
import org.jacodb.api.JcType;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;
import stub.java.io.InputStream$Void;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("ForLoopReplaceableByForEach")
@DecoderFor(InputStream$Void.class)
public final class InputStream$Void_Decoder implements ObjectDecoder {
    private volatile JcMethod cached_ByteArrayInputStream_ctor = null;
    private volatile JcType cached_bytes = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod ctor = cached_ByteArrayInputStream_ctor;
        // TODO: add synchronization if needed
        if (ctor == null) {
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i < c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isConstructor()) continue;

                // NOTE: replacing our custom stream by a ByteArrayInputStream on empty buffer
                List<JcParameter> params = m.getParameters();
                if (params.size() != 1) continue;
                if (!"byte[]".equals(params.get(0).getType().getTypeName())) continue;


                cached_ByteArrayInputStream_ctor = ctor = m;
                break;
            }

            cached_bytes = approximation.getClasspath().findTypeOrNull("byte");
        }

        return decoder.invokeMethod(ctor, Collections.singletonList(
                decoder.createArray(cached_bytes, decoder.createIntConst(0))
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
