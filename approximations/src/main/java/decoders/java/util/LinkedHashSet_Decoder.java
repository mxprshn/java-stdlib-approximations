package decoders.java.util;

import org.jacodb.api.*;
import org.usvm.api.SymbolicMap;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@DecoderFor(LinkedHashSet.class)
public class LinkedHashSet_Decoder implements ObjectDecoder {
    private volatile static JcMethod[] cachedMethods = null;
    private volatile static JcMethod cached_LinkedHashSet_ctor = null;
    private volatile static JcMethod cached_LinkedHashSet_add = null;
    private volatile static JcField cached_LinkedHashSet_length = null;
    private volatile static JcField cached_LinkedHashSet_storage = null;
    private volatile static JcField cached_Map_map = null;
    private volatile static JcField cached_HashMapContainer_map = null;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod m_ctor = cached_LinkedHashSet_ctor;
        // TODO: add class-level synchronization if needed
        if (m_ctor == null) {
            final List<JcMethod> methodList = approximation.getDeclaredMethods();
            final int methodCount = methodList.size();
            JcMethod[] methods = new JcMethod[methodCount];
            cachedMethods = methods = methodList.toArray(methods);

            for (int i = 0; i != methodCount; i++) {
                JcMethod m = methods[i];

                if (m.isConstructor()) {
                    List<JcParameter> params = m.getParameters();

                    // example: looking for java.util.LinkedHashSet.LinkedHashSet(int, float)
                    if (params.size() != 2) continue;
                    if (!"int".equals(params.get(0).getType().getTypeName())) continue;
                    if (!"float".equals(params.get(1).getType().getTypeName())) continue;

                    // update global "cache" and stop the search
                    cached_LinkedHashSet_ctor = m_ctor = m;
                    break;
                }
            }
        }

        // prepare parameters "in-place" and construct a new call
        final ArrayList<T> args = new ArrayList<>();
        args.add(decoder.createIntConst(123));
        args.add(decoder.createFloatConst(0.75f));
        return decoder.invokeMethod(m_ctor, args);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        JcField f_hs_storage = cached_LinkedHashSet_storage;
        JcField f_hs_length = cached_LinkedHashSet_length;
        if (f_hs_length == null) {
            // TODO: add class-level synchronization if needed
            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField field = fields.get(i);
                String fieldName = field.getName();

                if ("storage".equals(fieldName)) f_hs_storage = field;
                else if ("length".equals(fieldName)) f_hs_length = field;

                // early termination
                if (f_hs_length != null && f_hs_storage != null)
                    break;
            }
            cached_LinkedHashSet_length = f_hs_length;
            cached_LinkedHashSet_storage = f_hs_storage;
        }

        // skip empty or erroneous objects
        int length = approximationData.getIntField(f_hs_length);
        if (length < 0)
            throw new InternalError("Invalid container: negative size");
        if (length == 0)
            return;
        final ObjectData<T> storageData = approximationData.getObjectField(f_hs_storage);
        if (storageData == null)
            throw new InternalError("Invalid container: storage is NULL");

        // get primary method
        JcMethod m_add = cached_LinkedHashSet_add;
        if (m_add == null) {
            // TODO: add synchronization if needed
            final JcMethod[] methods = cachedMethods;
            for (int i = 0, c = methods.length; i != c; i++) {
                JcMethod m = methods[i];

                if (!"add".equals(m.getName())) continue;
                List<JcParameter> params = m.getParameters();
                if (params.size() != 1) continue;
                if (!"java.lang.Object".equals(params.get(0).getType().getTypeName())) continue;

                m_add = m;
                break;
            }
            cached_LinkedHashSet_add = m_add;
        }

        // prepare field references (inlined)
        JcField f_m_map = cached_Map_map;
        if (f_m_map == null) {
            JcClasspath cp = approximation.getClasspath();
            {
                List<JcField> fields = cp.findClassOrNull("runtime.LibSLRuntime$Map").getDeclaredFields();
                for (int i = 0, c = fields.size(); i != c; i++) {
                    JcField field = fields.get(i);

                    if ("map".equals(field.getName())) {
                        cached_Map_map = f_m_map = field;
                        break;
                    }
                }
            }
            {
                List<JcField> fields = cp.findClassOrNull("runtime.LibSLRuntime$HashMapContainer").getDeclaredFields();
                for (int i = 0, c = fields.size(); i != c; i++) {
                    JcField field = fields.get(i);

                    if ("map".equals(field.getName())) {
                        cached_HashMapContainer_map = field;
                        break;
                    }
                }
            }
        }

        // get and parse the underlying symbolic map
        final ObjectData<T> rtMapContainerData = storageData.getObjectField(f_m_map);
        final SymbolicMap<T, T> map = rtMapContainerData.decodeSymbolicMapField(cached_HashMapContainer_map);
        if (map == null)
            return;

        while (length != 0) {
            T key = map.anyKey();

            ArrayList<T> args = new ArrayList<>();
            args.add(outputInstance);
            args.add(key);
            decoder.invokeMethod(m_add, args);

            map.remove(key);
            length -= 1;
        }
    }
}
