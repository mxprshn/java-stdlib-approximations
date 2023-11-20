package decoders.java.lang;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("SizeReplaceableByIsEmpty")
@DecoderFor(Object.class)
public final class Object_Decoder implements ObjectDecoder {
    private volatile static Object cachedConstructor = null;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        final Object constructor = cachedConstructor;
        if (constructor != null)
            return (T) constructor;

        // TODO: add class-level synchronization if needed
        final List<JcMethod> methods = approximation.getDeclaredMethods();
        for (int i = 0, c = methods.size(); i != c; i++) {
            JcMethod m = methods.get(i);

            if (m.isConstructor() && m.getParameters().size() == 0)
                // construct invocation, update global "cache" and exit immediately
                return (T) (cachedConstructor = decoder.invokeMethod(m, Collections.EMPTY_LIST));
        }
        throw new InternalError("Constructor not found");
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
