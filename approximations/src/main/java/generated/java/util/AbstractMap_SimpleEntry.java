// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/util/AbstractMap.lsl:24
//  - java/util/AbstractMap.SimpleEntry.lsl:18
//
package generated.java.util;

import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.Map;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * AbstractMap_SimpleEntryAutomaton for AbstractMap_SimpleEntry ~> java.util.AbstractMap_SimpleEntry
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(stub.java.util.AbstractMap_SimpleEntry.class)
public class AbstractMap_SimpleEntry implements LibSLRuntime.Automaton, Serializable, Map.Entry {
    private static final long serialVersionUID = -8499721149061103585L;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public Object key;

    public Object value;

    @LibSLRuntime.AutomatonConstructor
    public AbstractMap_SimpleEntry(Void __$lsl_token, final byte p0, final Object p1,
            final Object p2) {
        this.__$lsl_state = p0;
        this.key = p1;
        this.value = p2;
    }

    @LibSLRuntime.AutomatonConstructor
    public AbstractMap_SimpleEntry(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, null, null);
    }

    /**
     * [CONSTRUCTOR] AbstractMap_SimpleEntryAutomaton::<init>(AbstractMap_SimpleEntry, Map_Entry) -> void
     * Source: java/util/AbstractMap.SimpleEntry.lsl:52
     */
    public AbstractMap_SimpleEntry(Map.Entry entry) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] AbstractMap_SimpleEntryAutomaton::<init>(AbstractMap_SimpleEntry, Object, Object) -> void
     * Source: java/util/AbstractMap.SimpleEntry.lsl:59
     */
    public AbstractMap_SimpleEntry(Object key, Object value) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            key = key;
            value = value;
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [FUNCTION] AbstractMap_SimpleEntryAutomaton::equals(AbstractMap_SimpleEntry, Object) -> boolean
     * Source: java/util/AbstractMap.SimpleEntry.lsl:70
     */
    public boolean equals(Object other) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (other == this) {
                result = true;
            } else {
                result = (other instanceof Map.Entry);
                if (result) {
                    final Map.Entry oEntry = ((Map.Entry) other);
                    final Object otherKey = oEntry.getKey();
                    final Object otherValue = oEntry.getValue();
                    result = LibSLRuntime.equals(this.key, otherKey) && LibSLRuntime.equals(this.value, otherValue);
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] AbstractMap_SimpleEntryAutomaton::getKey(AbstractMap_SimpleEntry) -> Object
     * Source: java/util/AbstractMap.SimpleEntry.lsl:90
     */
    public Object getKey() {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.key;
        }
        return result;
    }

    /**
     * [FUNCTION] AbstractMap_SimpleEntryAutomaton::getValue(AbstractMap_SimpleEntry) -> Object
     * Source: java/util/AbstractMap.SimpleEntry.lsl:96
     */
    public Object getValue() {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.value;
        }
        return result;
    }

    /**
     * [FUNCTION] AbstractMap_SimpleEntryAutomaton::hashCode(AbstractMap_SimpleEntry) -> int
     * Source: java/util/AbstractMap.SimpleEntry.lsl:102
     */
    public int hashCode() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.hashCode(this.key) ^ LibSLRuntime.hashCode(this.value);
        }
        return result;
    }

    /**
     * [FUNCTION] AbstractMap_SimpleEntryAutomaton::setValue(AbstractMap_SimpleEntry, Object) -> Object
     * Source: java/util/AbstractMap.SimpleEntry.lsl:108
     */
    public Object setValue(Object value) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = value;
            value = value;
        }
        return result;
    }

    /**
     * [FUNCTION] AbstractMap_SimpleEntryAutomaton::toString(AbstractMap_SimpleEntry) -> String
     * Source: java/util/AbstractMap.SimpleEntry.lsl:115
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.toString(this.key).concat("=").concat(LibSLRuntime.toString(this.value));
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(AbstractMap_SimpleEntry.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
