package generated.java.util;

import generated.java.util.map.AbstractMapImpl;
import generated.java.util.map.ConcurrentHashMapImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Approximate(Properties.class)
public class PropertiesImpl {
    private final ConcurrentHashMapImpl<Object, Object> map;
    protected Properties defaults;

    private PropertiesImpl(Properties defaults, int initialCapacity) {
        this.map = new ConcurrentHashMapImpl<>(initialCapacity);
        this.defaults = defaults;
    }
}
