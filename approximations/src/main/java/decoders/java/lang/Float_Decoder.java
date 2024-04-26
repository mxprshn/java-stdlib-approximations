package decoders.java.lang;

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

@DecoderFor(Float.class)
public class Float_Decoder implements ObjectDecoder {
    private volatile JcMethod cached_Float_ctor = null;
    private volatile JcField cached_Float_value = null;

    @Override
    public <T> T createInstance(JcClassOrInterface approximation,
                                ObjectData<T> approximationData,
                                DecoderApi<T> decoder) {
        JcMethod ctor = cached_Float_ctor;
        // TODO: add synchronization if needed
        if (ctor == null) {
            // looking for constructor and data field
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i != c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isConstructor()) continue;

                List<JcParameter> params = m.getParameters();
                if (params.size() != 1) continue;
                if (!"float".equals(params.get(0).getType().getTypeName())) continue;

                cached_Float_ctor = ctor = m;
                break;
            }

            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField f = fields.get(i);
                if ("value".equals(f.getName())) {
                    cached_Float_value = f;
                    break;
                }
            }
        }
        // extract the info
        final float value = approximationData.getFloatField(cached_Float_value);

        // assemble into a call
        final List<T> args = Collections.singletonList(decoder.createFloatConst(value));
        return decoder.invokeMethod(ctor, args);
    }

    @Override
    public <T> void initializeInstance(JcClassOrInterface jcClassOrInterface,
                                       ObjectData<T> objectData,
                                       T t,
                                       DecoderApi<T> decoderApi) {
        // nothing
    }
}
