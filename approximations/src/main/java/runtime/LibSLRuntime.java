package runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import org.usvm.api.SymbolicMap;

public final class LibSLRuntime {

    /*
    public static final class Token {
        public static final Token INSTANCE = new Token();

        private Token() {}
    }
    */
    private static final Object SOMETHING = LibSLRuntime.class;

    public interface HasAutomaton {
    }

    @Target(ElementType.CONSTRUCTOR)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DirectCallOnly {
    }

    public interface Automaton {
    }

    @Target(ElementType.CONSTRUCTOR)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AutomatonConstructor {
    }

    public static abstract class LibSLException extends Error {
        private LibSLException(final String msg) {
            super(msg);
        }
    }

    public static final class StateCheckException extends LibSLException {
        private StateCheckException(final String msg) {
            super(msg);
        }
    }

    public static final class SemanticViolationException extends LibSLException {
        private SemanticViolationException(final String msg) {
            super(msg);
        }
    }

    public static final class IncompleteSpecificationException extends LibSLException {
        private IncompleteSpecificationException(final String msg) {
            // #question: can we pass class and method names here? (counterargument: string bloat)
            super(msg);
        }
    }



    public static void error(final String msg) {
        Engine.assume(msg != null);
        throw new SemanticViolationException(msg);
    }

    public static void todo() {
        throw new IncompleteSpecificationException("TODO");
    }

    public static void not_implemented() {
        throw new IncompleteSpecificationException("NOT_IMPLEMENTED");
    }


    private static volatile int guid = 0;
    private static final Object guidLock = new Object();

    public static int getUniqueId() {
        // TODO: enable synchronization when parallel execution is allowed
        //synchronized (guidLock) {
            return ++guid;
        //}
    }



    public static String toString(final boolean v) {
        return v ? "true" : "false";
    }

    public static String toString(final byte v) {
        if (v == 0)               return "0";
        if (v == Byte.MIN_VALUE)  return "-128";
        if (v == Byte.MAX_VALUE)  return "127";
        // FIXME: add more common cases

        final int value = (int) v;
        Engine.assume(value > Byte.MIN_VALUE);
        Engine.assume(value < Byte.MAX_VALUE);
        return Integer.toString(value);
    }

    public static String toString(final short v) {
        if (v == 0)                return "0";
        if (v == Short.MIN_VALUE)  return "-32768";
        if (v == Short.MAX_VALUE)  return "32767";
        // FIXME: add more common cases

        final int value = (int) v;
        Engine.assume(value > Short.MIN_VALUE);
        Engine.assume(value < Short.MAX_VALUE);
        return Integer.toString(value);
    }

    public static String toString(final int v) {
        if (v == 0)                  return "0";
        if (v == Integer.MIN_VALUE)  return "-2147483648";
        if (v == Integer.MAX_VALUE)  return "2147483647";
        // FIXME: add more common cases

        return Integer.toString(v);
    }

    public static String toString(final long v) {
        if (v == 0L)              return "0";
        if (v == Long.MIN_VALUE)  return "-9223372036854775808";
        if (v == Long.MAX_VALUE)  return "9223372036854775807";
        // FIXME: add more common cases

        return Long.toString(v);
    }

    public static String toString(final char v) {
        return String.valueOf(v);
    }

    // TODO: do we need more variants for other primitive array types?
    public static String toString(final char[] v) {
        return new String(v);
    }

    public static String toString(final float v) {
        // TODO: use less complex approach
        return Float.toString(v);
    }

    public static String toString(final double v) {
        // TODO: use less complex approach
        return Double.toString(v);
    }

    public static String toString(final SymbolicList v) {
        int counter = v.size();
        Engine.assume(counter >= 0);
        if (counter == 0)
            return "[]";

        // FIXME: use less complex approach
        String res = "[";

        for (int i = 0, c = counter; i < c; i++) {
            res = res.concat(toString(v.get(i)));

            if (counter --> 1)
                res = res.concat(", ");
        }

        return res.concat("]");
    }

    public static String toString(final SymbolicMap v) {
        int unseen = v.size();
        Engine.assume(unseen >= 0);
        if (unseen == 0)
            return "[]";

        // FIXME: use less complex approach
        String res = "[";

        final SymbolicMap<Object, Object> visited = Engine.makeSymbolicMap();
        while (unseen != 0) {
            final Object key = Engine.makeSymbolic(Object.class);
            Engine.assume(!visited.containsKey(key));
            Engine.assume(v.containsKey(key));

            visited.set(key, SOMETHING);

            res = res
                    .concat(toString(key))
                    .concat(": ")
                    .concat(toString(v.get(key)));

            if (unseen --> 1)
                res = res.concat(", ");
        }

        return res.concat("]");
    }

    public static String toString(final Object v) {
        return v == null ? "null" : v.toString();
    }

    public static String toString(final Object[] objects) {
        int counter = objects.length;
        Engine.assume(counter >= 0);
        if (counter == 0)
            return "[]";
    
        String str = "[";

        for (int i = 0, c = counter; i < c; i++) {
            str = str.concat(toString(objects[i]));

            if (counter --> 1)
                str = str.concat(", ");
        }

        return str.concat("]");
    }

    // fool-proofing
    public static String toString(final String v) {
        return v == null ? "null" : v;
    }



    public static int hashCode(final boolean v) {
        // NOTE: copied from https://github.com/openjdk/jdk11/blob/master/src/java.base/share/classes/java/lang/Boolean.java#L227
        return v ? 1231 : 1237;
    }

    public static int hashCode(final byte v) {
        return (int) v;
    }

    public static int hashCode(final short v) {
        return (int) v;
    }

    public static int hashCode(final int v) {
        return v;
    }

    public static int hashCode(final long v) {
        return (int) (v ^ (v >>> 32));
    }

    public static int hashCode(final char v) {
        return (int) v;
    }

    public static int hashCode(final float v) {
        // FIXME: use less complex approach
        return Float.hashCode(v);
    }

    public static int hashCode(final double v) {
        // FIXME: use less complex approach
        return Double.hashCode(v);
    }

    public static int hashCode(final SymbolicList v) {
        if (v == null)
            return 0;

        final int count = v.size();
        Engine.assume(count >= 0);
        if (count == 0)
            return 1;

        // FIXME: use less complex approach
        int res = 1;

        for (int i = 0; i < count; i++)
            res = 31 * res + hashCode(v.get(i));

        return res;
    }

    public static int hashCode(final SymbolicMap v) {
        if (v == null)
            return 0;

        int unseen = v.size();
        Engine.assume(unseen >= 0);
        if (unseen == 0)
            return 1;

        // FIXME: use less complex approach
        int res = 1;

        final SymbolicMap<Object, Object> visited = Engine.makeSymbolicMap();
        while (unseen != 0) {
            final Object key = Engine.makeSymbolic(Object.class);
            Engine.assume(!visited.containsKey(key));
            Engine.assume(v.containsKey(key));

            res += hashCode(key) ^ hashCode(v.get(key));

            visited.set(key, SOMETHING);
            unseen -= 1;
        }

        return res;
    }

    public static int hashCode(final Object v) {
        return v == null ? 0 : v.hashCode();
    }

    public static int hashCode(final Object[] v) {
        if (v == null)
            return 0;

        final int count = v.length;
        Engine.assume(count >= 0);
        if (count == 0)
            return 1;

        int res = 1;

        for (int i = 0; i < count; i++)
            res = 31 * res + hashCode(v[i]);

        return res;
    }



    public static boolean equals(final boolean a, final boolean b) {
        return a == b;
    }

    public static boolean equals(final byte a, final byte b) {
        return a == b;
    }

    public static boolean equals(final short a, final short b) {
        return a == b;
    }

    public static boolean equals(final int a, final int b) {
        return a == b;
    }

    public static boolean equals(final long a, final long b) {
        return a == b;
    }

    public static boolean equals(final char a, final char b) {
        return a == b;
    }

    public static boolean equals(final float a, final float b) {
        // FIXME: use Float.compare(a, b) ?
        return a == b;
    }

    public static boolean equals(final double a, final double b) {
        // FIXME: use Double.compare(a, b) ?
        return a == b;
    }

    public static boolean equals(final SymbolicList a, final SymbolicList b) {
        if (a == b)
            return true;
        if (a == null || b == null)
            return false;

        int length = a.size();
        if (b.size() != length)
            return false;

        Engine.assume(length >= 0);
        for (int i = 0; i < length; i++)
            if (!equals(a.get(i), b.get(i)))
                return false;

        return true;
    }

    public static boolean equals(final SymbolicMap a, final SymbolicMap b) {
        if (a == b)
            return true;
        if (a == null || b == null)
            return false;

        int length = a.size();
        if (b.size() != length)
            return false;

        Engine.assume(length >= 0);
        final SymbolicMap<Object, Object> visited = Engine.makeSymbolicMap();
        while (length != 0) {
            final Object key = Engine.makeSymbolic(Object.class);
            Engine.assume(a.containsKey(key));
            Engine.assume(!visited.containsKey(key));

            if (!equals(a.get(key), b.get(key)))
                return false;

            visited.set(key, SOMETHING);
            length -= 1;
        }

        return true;
    }

    public static boolean equals(final Object a, final Object b) {
        if (a == b)
            return true;

        if (a == null && b != null)
            return false;

        return a.equals(b);
    }

    public static boolean equals(final Object[] a, final Object[] b) {
        if (a == b)
            return true;
        if (a == null || b == null)
            return false;

        int length = a.length;
        if (b.length != length)
            return false;

        Engine.assume(length >= 0);
        for (int i = 0; i < length; i++)
            if (!equals(a[i], b[i]))
                return false;

        return true;
    }



    // A marker class to attach unknown actions to. Makes it easier to do manual code inspections.
    public static final class UnknownAction {
    }



    // a helper class for complex "array<T>"-related actions
    public static final class ArrayActions {

        public static <T> void copy(final T[] src, final int srcPos,
                                    final T[] dst, final int dstPos,
                                    final int count) {
            Engine.assume(src != null);
            Engine.assume(dst != null);

            // TODO: use Engine.memcpy instead (but check bounds!)

            for (int i = 0; i < count; i++)
                dst[dstPos + i] = src[srcPos + i];
        }

        public static <T> void fill(final T[] arr, final T value) {
            Engine.assume(arr != null);

            final int count = arr.length;
            Engine.assume(count >= 0);
            for (int i = 0; i < count; i++)
                arr[i] = value;
        }

    }



    // a helper class for complex "list<T>"-related actions
    public static final class ListActions {
        private static final int INDEX_NOT_FOUND = -1;

        public static int find(final SymbolicList<?> list, final Object value,
                               final int from, final int to) {
            // general assumptions for this function to do something useful
            Engine.assume(0 <= from);
            Engine.assume(from < to);
            Engine.assume(list != null);

            // FIXME: is there a more efficient solution?
            if (value == null) {
                for (int i = from; i < to; i++) {
                    if (list.get(i) == null)
                        return i;
                }
            } else {
                for (int i = from; i < to; i++) {
                    final Object item = list.get(i);
                    if (value == item || value.equals(item))
                        return i;
                }
            }

            return INDEX_NOT_FOUND;
        }

    }



    // a helper class for complex "map<K,V>"-related actions
    public static final class MapActions {
        private static final Object DUMMY_IDENTITY_MAP = Engine.makeSymbolicMap();

        public static <K, V> SymbolicMap<K, V> union(final SymbolicMap<K, V> a,
                                                     final SymbolicMap<K, V> b) {
            final SymbolicMap<K, V> r = Engine.typeEquals(a, DUMMY_IDENTITY_MAP)
                        ? Engine.makeSymbolicMap()
                        : Engine.makeSymbolicMap();

            r.merge(a);
            r.merge(b);

            return r;
        }


        public static <K, V> SymbolicMap<K, V> intersection(final SymbolicMap<K, V> a,
                                                            final SymbolicMap<K, V> b) {
            final SymbolicMap<K, V> r = Engine.typeEquals(a, DUMMY_IDENTITY_MAP)
                        ? Engine.makeSymbolicMap()
                        : Engine.makeSymbolicMap();

            final int aSize = a.size();
            final int bSize = b.size();
            int count = aSize > bSize ? bSize : aSize;

            if (count == 0)
                return r;
            Engine.assume(count > 0);

            while (count != 0) {
                final K key = (K) Engine.makeSymbolic(Object.class);
                Engine.assume(r.containsKey(key) == false);
                Engine.assume(a.containsKey(key) == true);

                if (b.containsKey(key))
                    r.set(key, b.get(key));

                count -= 1;
            }

            return r;
        }


        public static <K, V> void intersect(final SymbolicMap<K, V> receiver,
                                            final SymbolicMap<K, V> otherSource) {
            int count = receiver.size();

            if (count == 0)
                return;
            Engine.assume(count > 0);

            final SymbolicMap<Object, Object> visited = Engine.makeSymbolicMap();
            if (otherSource.size() == 0) {
                while (count != 0) {
                    final K key = (K) Engine.makeSymbolic(Object.class);
                    Engine.assume(visited.containsKey(key) == false);
                    Engine.assume(receiver.containsKey(key) == true);

                    receiver.remove(key);

                    visited.set(key, SOMETHING);
                    count -= 1;
                }
            } else {
                while (count != 0) {
                    final K key = (K) Engine.makeSymbolic(Object.class);
                    Engine.assume(visited.containsKey(key) == false);
                    Engine.assume(receiver.containsKey(key) == true);

                    if (!otherSource.containsKey(key))
                        receiver.remove(key);

                    visited.set(key, SOMETHING);
                    count -= 1;
                }
            }
        }

    }

}
