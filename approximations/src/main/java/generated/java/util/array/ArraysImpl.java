package generated.java.util.array;

import generated.java.util.list.ArrayListImpl;
import org.jacodb.approximation.annotation.Approximate;

import java.util.Arrays;
import java.util.List;

@Approximate(Arrays.class)
public class ArraysImpl {

    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> List<T> asList(T... a) {
        ArrayListImpl<T> list = new ArrayListImpl<T>();
        int index = 0;
        for (T item : a) {
            list.add(index, item);
            index++;
        }
        return list;
    }
}
