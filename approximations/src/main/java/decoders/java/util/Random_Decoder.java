package decoders.java.util;


import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcMethod;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@DecoderFor(Random.class)
public class Random_Decoder implements ObjectDecoder {
    private volatile JcMethod cached_Random_ctor = null;

    @SuppressWarnings({"unchecked", "SizeReplaceableByIsEmpty"})
    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod ctor = cached_Random_ctor;
        // TODO: add synchronization if needed
        if (ctor == null) {
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i != c; i++) {
                JcMethod m = methods.get(i);

                if (m.isConstructor() && m.getParameters().size() == 0) {
                    cached_Random_ctor = ctor = m;
                    break;
                }
            }
        }

        return decoder.invokeMethod(ctor, (List<T>) Collections.EMPTY_LIST);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
