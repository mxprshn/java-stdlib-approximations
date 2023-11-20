package decoders.java.util;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcMethod;
import org.jacodb.api.JcParameter;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.*;

@DecoderFor(LinkedList.class)
public class LinkedList_Decoder implements ObjectDecoder {

    private volatile static JcMethod cached_LinkedList_ctor = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        // TODO: add class-based synchronization if needed
        JcMethod ctor = cached_LinkedList_ctor;
        if (ctor == null) {
            // looking for constructor
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i != c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isConstructor()) continue;

                List<JcParameter> params = m.getParameters();
                if (params.size() != 0) continue;

                cached_LinkedList_ctor = ctor = m;
                break;
            }
        }

        final List<T> args = new ArrayList<>();
        return decoder.invokeMethod(ctor, args);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approx,
                                       final ObjectData<T> approxData,
                                       final T instance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}

