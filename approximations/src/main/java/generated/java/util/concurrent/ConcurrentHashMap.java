package generated.java.util.concurrent;


import generated.java.util.ArrayList;
import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicMap;
import runtime.LibSLRuntime;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Approximate(java.util.concurrent.ConcurrentHashMap.class)
public class ConcurrentHashMap implements LibSLRuntime.Automaton, Map, Cloneable, Serializable {
    private static final long serialVersionUID = -5024744406713321676L;

    static {
        Engine.assume(true);
    }

    public SymbolicMap<Object, Object> storage = Engine.makeSymbolicMap();

    public ConcurrentHashMap() {
    }


    public ConcurrentHashMap(int capacity) {
    }


    public ConcurrentHashMap(int capacity, float loadFactor) {
    }

    public ConcurrentHashMap(int initialCapacity,
                             float loadFactor, int concurrencyLevel) {
    }

    public ConcurrentHashMap(Map m) {
        putAll(m);
    }

    @Override
    public int size() {
        Engine.assume(storage != null);
        return storage.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Engine.assume(storage != null);
        return storage.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        Engine.assume(storage != null);
        return Engine.makeSymbolicBoolean();
    }

    @Override
    public Object get(Object key) {
        Engine.assume(storage != null);

        if (!storage.containsKey(key)) {
            return null;
        }

        return storage.get(key);
    }

    @Nullable
    @Override
    public Object put(Object key, Object value) {
        Engine.assume(storage != null);
        if (!storage.containsKey(key)) {
            storage.set(key, value);
            return null;
        }

        final Object prev = storage.get(key);
        storage.set(key, value);
        return prev;
    }

    @Override
    public Object remove(Object key) {
        Engine.assume(storage != null);
        if (!storage.containsKey(key)) {
            return null;
        }

        final Object prev = storage.get(key);
        storage.remove(key);
        return prev;
    }

    @Override
    public void putAll(@NotNull Map m) {
        if (m instanceof java.util.concurrent.ConcurrentHashMap<?, ?>) {
            final generated.java.util.concurrent.ConcurrentHashMap other = (generated.java.util.concurrent.ConcurrentHashMap) m;
            final SymbolicMap otherStorage = other.storage;
            Engine.assume(otherStorage != null);
            storage.merge(otherStorage);
        }
    }

    @Override
    public void clear() {
        storage = Engine.makeSymbolicMap();
    }

    @NotNull
    @Override
    public Set keySet() {
        return new HashSet<>();
    }

    @NotNull
    @Override
    public Collection values() {
        return new ArrayList();
    }

    @NotNull
    @Override
    public Set<Entry> entrySet() {
        return new HashSet<>();
    }
}
