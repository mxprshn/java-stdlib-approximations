package decoders;

import org.jacodb.api.*;
import org.usvm.api.decoder.DecoderApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseDecoder {

    protected static boolean parameterTypeNotMatch(final List<JcParameter> params,
                                                   final int idx,
                                                   final String type) {
        return !type.equals(params.get(idx).getType().getTypeName());
    }

    protected static JcMethod getMethod(final List<JcMethod> methods,
                                        final String name,
                                        final String... types) {
        for (JcMethod m : methods)
            if (name.equals(m.getName()) && parametersMatch(m, types))
                return m;

        throw new InternalError("!!!");
    }

    protected static boolean parametersMatch(final JcMethod method, final String... types) {
        List<JcParameter> ps = method.getParameters();

        final int pCount = ps.size();
        if (pCount != types.length)
            return false;

        for (int i = 0; i < pCount; i++)
            if (parameterTypeNotMatch(ps, i, types[i]))
                return false;

        return true;
    }

    protected static JcField getField(final List<JcField> fields, final String name) {
        for (JcField f : fields)
            if (name.equals(f.getName()))
                return f;

        throw new InternalError("!!!");
    }

    protected static JcClassOrInterface getClass(JcClasspath cp, String typeName) {
        final JcClassOrInterface clazz = cp.findClassOrNull(typeName);
        assert clazz != null;
        return clazz;
    }

    protected static <T> void call(final DecoderApi<T> decoder,
                                   final T instance,
                                   final JcMethod method,
                                   final T... values) {
        List<T> args = new ArrayList<>();
        args.add(instance);
        Collections.addAll(args, values);

        decoder.invokeMethod(method, args);
    }
}
