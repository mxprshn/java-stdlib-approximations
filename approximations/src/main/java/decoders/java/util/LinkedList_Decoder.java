package decoders.java.util;

import org.jacodb.api.JcClassOrInterface;
import org.jacodb.api.JcField;
import org.jacodb.api.JcMethod;
import org.jacodb.api.JcParameter;
import org.usvm.api.SymbolicList;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.*;

@DecoderFor(LinkedList.class)
public class LinkedList_Decoder implements ObjectDecoder {

    private volatile static JcMethod cached_LinkedList_ctor = null;
    private volatile static JcField cached_LinkedList_size = null;
    private volatile static JcField cached_LinkedList_storage = null;
    private volatile static JcField cached_LinkedList_modCount = null;
    private volatile static JcMethod cached_LinkedList_add = null;
    private volatile static JcMethod[] cachedMethods = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        JcMethod ctor = cached_LinkedList_ctor;
        // TODO: add class-based synchronization if needed
        if (ctor == null) {
            // looking for constructor
            // TODO: add class-level synchronization if needed
            final List<JcMethod> methodList = approximation.getDeclaredMethods();
            final int methodCount = methodList.size();
            JcMethod[] methods = new JcMethod[methodCount];
            cachedMethods = methods = methodList.toArray(methods);

            for (int i = 0; i != methodCount; i++) {
                JcMethod m = methods[i];

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
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        JcField f_ls_storage = cached_LinkedList_storage;
        JcField f_ls_size = cached_LinkedList_size;
        JcField f_ls_modCount = cached_LinkedList_modCount;
        if (cached_LinkedList_size == null) {
            // TODO: add class-level synchronization if needed
            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField field = fields.get(i);
                String fieldName = field.getName();

                if ("storage".equals(fieldName)) f_ls_storage = field;
                else if ("size".equals(fieldName)) f_ls_size = field;
                else if ("modCount".equals(fieldName)) f_ls_modCount = field;

                // early termination
                if (f_ls_size != null && f_ls_storage != null && f_ls_modCount != null)
                    break;
            }
            cached_LinkedList_size = f_ls_size;
            cached_LinkedList_storage = f_ls_storage;
            cached_LinkedList_modCount = f_ls_modCount;
        }

        // skip empty or erroneous objects
        int size = approximationData.getIntField(f_ls_size);
        if (size < 0)
            throw new InternalError("Invalid container: negative size");
        if (size == 0)
            return;
        final ObjectData<T> storageData = approximationData.getObjectField(f_ls_storage);
        if (storageData == null)
            throw new InternalError("Invalid container: storage is NULL");

        // get primary method
        JcMethod m_add = cached_LinkedList_add;
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
            cached_LinkedList_add = m_add;
        }

        SymbolicList<T> storage = approximationData.decodeSymbolicListField(f_ls_storage);

        for (int i = 0; i < storage.size(); i++) {
            T curElement = storage.get(i);
            decoder.invokeMethod(m_add, new LinkedList<>(Arrays.asList(outputInstance, curElement)));
        }
    }
}

