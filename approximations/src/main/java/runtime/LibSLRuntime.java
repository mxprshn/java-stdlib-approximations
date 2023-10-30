package runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.usvm.api.Engine;
import org.usvm.api.SymbolicIdentityMap;
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
        if (v == 0) return "0";
        if (v == Byte.MIN_VALUE) return "-128";
        if (v == Byte.MAX_VALUE) return "127";
        // FIXME: add more common cases

        final int value = (int) v;
        Engine.assume(value > Byte.MIN_VALUE);
        Engine.assume(value < Byte.MAX_VALUE);
        return Integer.toString(value);
    }

    public static String toString(final short v) {
        if (v == 0) return "0";
        if (v == Short.MIN_VALUE) return "-32768";
        if (v == Short.MAX_VALUE) return "32767";
        // FIXME: add more common cases

        final int value = (int) v;
        Engine.assume(value > Short.MIN_VALUE);
        Engine.assume(value < Short.MAX_VALUE);
        return Integer.toString(value);
    }

    public static String toString(final int v) {
        if (v == 0) return "0";
        if (v == Integer.MIN_VALUE) return "-2147483648";
        if (v == Integer.MAX_VALUE) return "2147483647";
        // FIXME: add more common cases

        return Integer.toString(v);
    }

    public static String toString(final long v) {
        if (v == 0L) return "0";
        if (v == Long.MIN_VALUE) return "-9223372036854775808";
        if (v == Long.MAX_VALUE) return "9223372036854775807";
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

    public static <V> String toString(final SymbolicList<V> v) {
        int counter = v.size();
        Engine.assume(counter >= 0);
        if (counter == 0)
            return "[]";

        // FIXME: use less complex approach
        String res = "[";

        for (int i = 0, c = counter; i < c; i++) {
            res = res.concat(toString(v.get(i)));

            if (counter-- > 1)
                res = res.concat(", ");
        }

        return res.concat("]");
    }

    public static <K, V> String toString(final Map<K, V> v) {
        int count = v.size();
        if (count == 0)
            return "[]";
        Engine.assume(count > 0);

        // TODO: use less complex approach
        String res = "[";

        final Map.Container<K, V> unseen = v.map.duplicate();
        while (count != 0) {
            final K key = unseen.anyKey();
            final V value = unseen.get(key);
            unseen.remove(key);

            res = res
                    .concat(toString(key))
                    .concat(": ")
                    .concat(toString(value));

            if (count-- > 1)
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

            if (counter-- > 1)
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

    public static <V> int hashCode(final SymbolicList<V> v) {
        if (v == null)
            return 0;

        final int count = v.size();
        if (count == 0)
            return 1;
        Engine.assume(count > 0);

        // FIXME: use less complex approach
        int res = 1;

        for (int i = 0; i < count; i++)
            res = 31 * res + hashCode(v.get(i));

        return res;
    }

    public static <K, V> int hashCode(final Map<K, V> v) {
        if (v == null)
            return 0;

        int count = v.size();
        if (count == 0)
            return 1;
        Engine.assume(count > 0);

        // TODO: use less complex approach
        int res = 1;

        final Map.Container<K, V> unseen = v.map.duplicate();
        while (count != 0) {
            final K key = unseen.anyKey();

            res += hashCode(key) ^ hashCode(unseen.get(key));

            unseen.remove(key);
            count -= 1;
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

    public static <Va, Vb> boolean equals(final SymbolicList<Va> a, final SymbolicList<Vb> b) {
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

    public static boolean equals(final Map a, final Map b) {
        if (a == b)
            return true;
        if (a == null || b == null)
            return false;

        int length = a.size();
        if (b.size() != length)
            return false;

        if (length == 0)
            return true;
        Engine.assume(length >= 0);

        final Map.Container<Object, ?> unseen = a.map.duplicate();
        while (length != 0) {
            final Object key = unseen.anyKey();

            if (!equals(a.get(key), b.get(key)))
                return false;

            unseen.remove(key);
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

        public static <T> void copy(final Object src, final int srcPos,
                                    final Object dst, final int dstPos,
                                    final int count) {
            if (count <= 0)
                return;

            Engine.assume(src != null);
            Engine.assume(dst != null);

            System.arraycopy(src, srcPos, dst, dstPos, count);
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

            // TODO: is there a more efficient solution?
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


    public static final class Map<K, V> {
        Container<K, V> map;

        public static abstract class Container<Kc, Vc> {
            protected static final byte KIND_HASHMAP = 1;
            protected static final byte KIND_IDENTITY_MAP = 2;

            protected final byte kind;

            protected Container(final byte kind) {
                this.kind = kind;
            }

            abstract void merge(Container<Kc, Vc> container);

            abstract Container<Kc, Vc> getCleanInstance();

            abstract Container<Kc, Vc> duplicate();

            // other methods are proxies for USVM objects

            abstract boolean containsKey(Kc key);

            abstract Kc anyKey();

            abstract Vc get(Kc key);

            abstract void set(Kc key, Vc value);

            abstract void remove(Kc key);

            abstract int size();
        }

        public Map(final Container<K, V> container) {
            this.map = container;
        }

        public boolean hasKey(final K key) {
            Engine.assume(map != null);
            return map.containsKey(key);
        }

        public K anyKey() {
            Engine.assume(map != null);
            return map.anyKey();
        }

        public V get(final K key) {
            Engine.assume(map != null);
            return map.get(key);
        }

        public void set(final K key, final V value) {
            Engine.assume(map != null);
            map.set(key, value);
        }

        public void remove(final K key) {
            Engine.assume(map != null);
            map.remove(key);
        }

        public int size() {
            Engine.assume(map != null);
            return map.size();
        }

        public void union(final Map<K, V> other) {
            Engine.assume(map != null);

            final Container<K, V> otherMap = other.map;
            Engine.assume(otherMap != null);

            if (map.kind == otherMap.kind) {
                map.merge(otherMap);
            } else {
                int count = otherMap.size();
                if (count != 0) {
                    Engine.assume(count > 0);

                    final Container<K, V> unseen = otherMap.duplicate();
                    while (count != 0) {
                        final K key = unseen.anyKey();

                        // behaving exactly as compatible versions
                        map.set(key, unseen.get(key));

                        unseen.remove(key);
                        count -= 1;
                    }
                }
            }
        }

        public void intersection(final Map<K, V> other) {
            Engine.assume(map != null);

            final Container<K, V> otherMap = other.map;
            Engine.assume(otherMap != null);

            final Container<K, V> thisMap = map;
            map = thisMap.getCleanInstance();
            Engine.assume(map != null);

            int count = otherMap.size();
            if (count != 0) {
                Engine.assume(count > 0);

                final Container<K, V> unseen = otherMap.duplicate();
                while (count != 0) {
                    final K key = unseen.anyKey();

                    if (thisMap.containsKey(key))
                        // preferring items from the other container (similar to "union")
                        map.set(key, unseen.get(key));

                    unseen.remove(key);
                    count -= 1;
                }
            }
        }

        public Map<K, V> duplicate() {
            Engine.assume(map != null);
            return new Map(map.duplicate());
        }

        @Override
        public String toString() {
            return LibSLRuntime.toString(this);
        }

        @Override
        public int hashCode() {
            return LibSLRuntime.hashCode(this);
        }

        @Override
        public boolean equals(Object obj) {
            return LibSLRuntime.equals(this, obj);
        }
    }


    public static final class HashMapContainer<K, V> extends Map.Container<K, V> {
        private final SymbolicMap<K, V> map = Engine.makeSymbolicMap();

        public HashMapContainer() {
            super(KIND_HASHMAP);
        }

        @Override
        public void merge(Map.Container<K, V> container) {
            Engine.assume(container instanceof HashMapContainer);
            HashMapContainer<K, V> other = (HashMapContainer<K, V>) container;
            map.merge(other.map);
        }

        @Override
        public Map.Container<K, V> getCleanInstance() {
            return new HashMapContainer<>();
        }

        @Override
        public Map.Container<K, V> duplicate() {
            final HashMapContainer<K, V> obj =  new HashMapContainer<>();
            obj.map.merge(this.map);
            return obj;
        }

        @Override
        public boolean containsKey(K key) {
            return map.containsKey(key);
        }

        @Override
        public K anyKey() {
            return map.anyKey();
        }

        @Override
        public V get(K key) {
            return map.get(key);
        }

        @Override
        public void set(K key, V value) {
            map.set(key, value);
        }

        @Override
        public void remove(K key) {
            map.remove(key);
        }

        @Override
        public int size() {
            return map.size();
        }
    }


    public static final class IdentityMapContainer<K, V> extends Map.Container<K, V> {
        private final SymbolicIdentityMap<K, V> map = Engine.makeSymbolicIdentityMap();

        public IdentityMapContainer() {
            super(KIND_HASHMAP);
        }

        @Override
        public void merge(Map.Container<K, V> container) {
            Engine.assume(container instanceof IdentityMapContainer);
            IdentityMapContainer<K, V> other = (IdentityMapContainer<K, V>) container;
            map.merge(other.map);
        }

        @Override
        public Map.Container<K, V> getCleanInstance() {
            return new IdentityMapContainer<>();
        }

        @Override
        public Map.Container<K, V> duplicate() {
            final IdentityMapContainer<K, V> obj =  new IdentityMapContainer<>();
            obj.map.merge(this.map);
            return obj;
        }

        @Override
        public boolean containsKey(K key) {
            return map.containsKey(key);
        }

        @Override
        public K anyKey() {
            return map.anyKey();
        }

        @Override
        public V get(K key) {
            return map.get(key);
        }

        @Override
        public void set(K key, V value) {
            map.set(key, value);
        }

        @Override
        public void remove(K key) {
            map.remove(key);
        }

        @Override
        public int size() {
            return map.size();
        }
    }

}
