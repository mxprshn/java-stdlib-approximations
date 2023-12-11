// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/util/ArrayList.lsl:22
//  - java/util/ArrayList.main.lsl:17
//
package generated.java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Cloneable;
import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;
import stub.java.util.stream.StreamLSL;

/**
 * ArrayListAutomaton for ArrayList ~> java.util.ArrayList
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(java.util.ArrayList.class)
public class ArrayList implements LibSLRuntime.Automaton, List, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 8683452581122892189L;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public SymbolicList<Object> storage;

    public transient int modCount;

    @LibSLRuntime.AutomatonConstructor
    public ArrayList(Void __$lsl_token, final byte p0, final SymbolicList<Object> p1,
            final int p2) {
        this.__$lsl_state = p0;
        this.storage = p1;
        this.modCount = p2;
    }

    @LibSLRuntime.AutomatonConstructor
    public ArrayList(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, null, 0);
    }

    /**
     * [CONSTRUCTOR] ArrayListAutomaton::<init>(ArrayList) -> void
     * Source: java/util/ArrayList.main.lsl:523
     */
    public ArrayList() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.storage = Engine.makeSymbolicList();
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] ArrayListAutomaton::<init>(ArrayList, Collection) -> void
     * Source: java/util/ArrayList.main.lsl:529
     */
    public ArrayList(Collection c) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            if (c == null) {
                throw new NullPointerException();
            }
            this.storage = Engine.makeSymbolicList();
            _addAllElements(0, c);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] ArrayListAutomaton::<init>(ArrayList, int) -> void
     * Source: java/util/ArrayList.main.lsl:540
     */
    public ArrayList(int initialCapacity) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException();
            }
            this.storage = Engine.makeSymbolicList();
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_checkValidIndex(int, int) -> void
     * Source: java/util/ArrayList.main.lsl:85
     */
    public void _checkValidIndex(int index, int length) {
        /* body */ {
            if ((index < 0) || (length <= index)) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_rangeCheckForAdd(int) -> void
     * Source: java/util/ArrayList.main.lsl:97
     */
    public void _rangeCheckForAdd(int index) {
        /* body */ {
            if ((index > this.storage.size()) || (index < 0)) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_addAllElements(int, Collection) -> boolean
     * Source: java/util/ArrayList.main.lsl:109
     */
    public boolean _addAllElements(int index, Collection c) {
        boolean result = false;
        /* body */ {
            final int oldLength = this.storage.size();
            if ((c != null && c.getClass() == java.util.ArrayList.class)) {
                final SymbolicList<Object> otherStorage = ((ArrayList) ((Object) c)).storage;
                final int otherLength = otherStorage.size();
                Engine.assume(otherStorage != null);
                Engine.assume(otherLength >= 0);
                int i = 0;
                for (i = 0; i < otherLength; i += 1) {
                    final Object item = otherStorage.get(i);
                    this.storage.insert(index, item);
                    index += 1;
                }
                ;
            } else {
                final Iterator iter = c.iterator();
                while (iter.hasNext()) {
                    final Object item = iter.next();
                    this.storage.insert(index, item);
                    index += 1;
                }
                ;
            }
            result = oldLength != this.storage.size();
            if (result) {
                this.modCount += 1;
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_subListRangeCheck(int, int, int) -> void
     * Source: java/util/ArrayList.main.lsl:159
     */
    public void _subListRangeCheck(int fromIndex, int toIndex, int size) {
        /* body */ {
            if (fromIndex < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (toIndex > size) {
                throw new IndexOutOfBoundsException();
            }
            if (fromIndex > toIndex) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_checkForComodification(int) -> void
     * Source: java/util/ArrayList.main.lsl:183
     */
    public void _checkForComodification(int expectedModCount) {
        /* body */ {
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_deleteElement(int) -> Object
     * Source: java/util/ArrayList.main.lsl:190
     */
    public Object _deleteElement(int index) {
        Object result = null;
        /* body */ {
            _checkValidIndex(index, this.storage.size());
            result = this.storage.get(index);
            this.storage.remove(index);
            this.modCount += 1;
        }
        return result;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_addElement(int, Object) -> void
     * Source: java/util/ArrayList.main.lsl:201
     */
    public void _addElement(int index, Object element) {
        /* body */ {
            _rangeCheckForAdd(index);
            this.storage.insert(index, element);
            this.modCount += 1;
        }
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_setElement(int, Object) -> Object
     * Source: java/util/ArrayList.main.lsl:211
     */
    private Object _setElement(int index, Object element) {
        Object result = null;
        /* body */ {
            _checkValidIndex(index, this.storage.size());
            result = this.storage.get(index);
            this.storage.set(index, element);
        }
        return result;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_replaceAllRange(UnaryOperator, int, int) -> void
     * Source: java/util/ArrayList.main.lsl:226
     */
    public void _replaceAllRange(UnaryOperator op, int i, int end) {
        /* body */ {
            final int expectedModCount = this.modCount;
            while ((this.modCount == expectedModCount) && (i < end)) {
                final Object oldItem = this.storage.get(i);
                final Object newItem = op.apply(oldItem);
                this.storage.set(i, newItem);
                i += 1;
            }
            ;
            _checkForComodification(expectedModCount);
        }
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_removeIf(Predicate, int, int) -> boolean
     * Source: java/util/ArrayList.main.lsl:248
     */
    public boolean _removeIf(Predicate filter, int start, int end) {
        boolean result = false;
        /* body */ {
            if (filter == null) {
                throw new NullPointerException();
            }
            final int oldLength = this.storage.size();
            final int expectedModCount = this.modCount;
            Engine.assume(start <= end);
            int i = 0;
            for (i = end - 1; i > start; i += -1) {
                final Object item = this.storage.get(i);
                if (filter.test(item)) {
                    this.storage.remove(i);
                }
            }
            ;
            _checkForComodification(expectedModCount);
            result = oldLength != this.storage.size();
        }
        return result;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_equalsRange(List, int, int) -> boolean
     * Source: java/util/ArrayList.main.lsl:277
     */
    public boolean _equalsRange(List other, int from, int to) {
        boolean result = false;
        /* body */ {
            result = true;
            int i = from;
            SymbolicList<Object> otherStorage = null;
            if ((other != null && other.getClass() == java.util.ArrayList.class)) {
                otherStorage = ((ArrayList) ((Object) other)).storage;
                result = to == otherStorage.size();
                if (result) {
                    while (result && (i < to)) {
                        final Object a = otherStorage.get(i);
                        final Object b = this.storage.get(i);
                        result = LibSLRuntime.equals(a, b);
                        i += 1;
                    }
                    ;
                }
            } else {
                if ((other != null && other.getClass() == stub.java.util.ArrayList_SubList.class)) {
                    final ArrayList otherRoot = ((ArrayList_SubList) ((Object) other)).root;
                    otherStorage = ((ArrayList) ((Object) otherRoot)).storage;
                    result = to == ((ArrayList_SubList) ((Object) other)).length;
                    if (result) {
                        while (result && (i < to)) {
                            final Object a = otherStorage.get(i);
                            final Object b = this.storage.get(i);
                            result = LibSLRuntime.equals(a, b);
                            i += 1;
                        }
                        ;
                    }
                } else {
                    final Iterator iter = other.iterator();
                    while (result && (i < to) && iter.hasNext()) {
                        final Object a = iter.next();
                        final Object b = this.storage.get(i);
                        result = LibSLRuntime.equals(a, b);
                        i += 1;
                    }
                    ;
                    result &= !iter.hasNext();
                }
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_makeStream(boolean) -> Stream
     * Source: java/util/ArrayList.main.lsl:342
     */
    private Stream _makeStream(boolean parallel) {
        Stream result = null;
        /* body */ {
            final int count = this.storage.size();
            final Object[] items = new Object[count];
            int i = 0;
            for (i = 0; i < count; i += 1) {
                items[i] = this.storage.get(i);
            }
            ;
            result = (StreamLSL) ((Object) new generated.java.util.stream.StreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.StreamLSL.__$lsl_States.Initialized, 
                /* storage = */ items, 
                /* length = */ count, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ parallel, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_batchRemove(Collection, boolean, int, int) -> boolean
     * Source: java/util/ArrayList.main.lsl:369
     */
    public boolean _batchRemove(Collection c, boolean complement, int start, int end) {
        boolean result = false;
        /* body */ {
            final int oldLength = this.storage.size();
            if ((oldLength == 0) || (start >= end)) {
                result = false;
            } else {
                final int otherLength = c.size();
                if (otherLength == 0) {
                    result = false;
                } else {
                    Engine.assume(otherLength > 0);
                    int i = 0;
                    start -= 1;
                    end -= 1;
                    if ((c != null && c.getClass() == java.util.ArrayList.class)) {
                        final SymbolicList<Object> otherStorage = ((ArrayList) ((Object) c)).storage;
                        Engine.assume(otherStorage != null);
                        for (i = end; i > start; i += -1) {
                            final Object item = this.storage.get(i);
                            if ((LibSLRuntime.ListActions.find(otherStorage, item, 0, this.storage.size()) == -1) == complement) {
                                _deleteElement(i);
                            }
                        }
                        ;
                    } else {
                        for (i = end; i > start; i += -1) {
                            final Object item = this.storage.get(i);
                            if (c.contains(item) != complement) {
                                _deleteElement(i);
                            }
                        }
                        ;
                    }
                    result = oldLength != this.storage.size();
                }
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] ArrayListAutomaton::_do_sort(int, int, Comparator) -> void
     * Source: java/util/ArrayList.main.lsl:430
     */
    public void _do_sort(int start, int end, Comparator c) {
        /* body */ {
            if (start < end) {
                final int expectedModCount = this.modCount;
                Engine.assume(start >= 0);
                Engine.assume(end > 0);
                final int outerLimit = end - 1;
                int innerLimit = 0;
                int i = 0;
                int j = 0;
                if (c == null) {
                    for (i = start; i < outerLimit; i += 1) {
                        innerLimit = (end - i) - 1;
                        for (j = start; j < innerLimit; j += 1) {
                            final int idxA = j;
                            final int idxB = j + 1;
                            final Object a = this.storage.get(idxA);
                            final Object b = this.storage.get(idxB);
                            if (((Comparable) a).compareTo(b) > 0) {
                                this.storage.set(idxA, b);
                                this.storage.set(idxB, a);
                            }
                        }
                        ;
                    }
                    ;
                } else {
                    for (i = start; i < outerLimit; i += 1) {
                        innerLimit = (end - i) - 1;
                        for (j = start; j < innerLimit; j += 1) {
                            final int idxA = j;
                            final int idxB = j + 1;
                            final Object a = this.storage.get(idxA);
                            final Object b = this.storage.get(idxB);
                            if (c.compare(a, b) > 0) {
                                this.storage.set(idxA, b);
                                this.storage.set(idxB, a);
                            }
                        }
                        ;
                    }
                    ;
                }
                _checkForComodification(expectedModCount);
            }
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::add(ArrayList, Object) -> boolean
     * Source: java/util/ArrayList.main.lsl:553
     */
    public boolean add(Object e) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.storage.insert(this.storage.size(), e);
            this.modCount += 1;
            result = true;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::add(ArrayList, int, Object) -> void
     * Source: java/util/ArrayList.main.lsl:563
     */
    public void add(int index, Object element) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            _addElement(index, element);
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::addAll(ArrayList, Collection) -> boolean
     * Source: java/util/ArrayList.main.lsl:569
     */
    public boolean addAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _addAllElements(this.storage.size(), c);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::addAll(ArrayList, int, Collection) -> boolean
     * Source: java/util/ArrayList.main.lsl:575
     */
    public boolean addAll(int index, Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            _rangeCheckForAdd(index);
            result = _addAllElements(index, c);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::clear(ArrayList) -> void
     * Source: java/util/ArrayList.main.lsl:582
     */
    public void clear() {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.storage = Engine.makeSymbolicList();
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::clone(ArrayList) -> Object
     * Source: java/util/ArrayList.main.lsl:589
     */
    public Object clone() {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final SymbolicList<Object> storageCopy = Engine.makeSymbolicList();
            this.storage.copy(storageCopy, 0, 0, this.storage.size());
            result = (java.util.ArrayList) ((Object) new ArrayList((Void) null, 
                /* state = */ ArrayList.__$lsl_States.Initialized, 
                /* storage = */ storageCopy, 
                /* modCount = */ 0
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::contains(ArrayList, Object) -> boolean
     * Source: java/util/ArrayList.main.lsl:600
     */
    public boolean contains(Object o) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.ListActions.find(this.storage, o, 0, this.storage.size()) != -1;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::containsAll(ArrayList, Collection) -> boolean
     * Source: java/util/ArrayList.main.lsl:607
     */
    public boolean containsAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = true;
            if ((c != null && c.getClass() == java.util.ArrayList.class)) {
                final SymbolicList<Object> otherStorage = ((ArrayList) ((Object) c)).storage;
                Engine.assume(otherStorage != null);
                final int otherLength = otherStorage.size();
                Engine.assume(otherLength >= 0);
                int i = 0;
                while (result && (i < otherLength)) {
                    final Object item = otherStorage.get(i);
                    result = LibSLRuntime.ListActions.find(this.storage, item, 0, this.storage.size()) != -1;
                    i += 1;
                }
                ;
            } else {
                final Iterator iter = c.iterator();
                while (result && iter.hasNext()) {
                    final Object item = iter.next();
                    result = LibSLRuntime.ListActions.find(this.storage, item, 0, this.storage.size()) != -1;
                }
                ;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::ensureCapacity(ArrayList, int) -> void
     * Source: java/util/ArrayList.main.lsl:650
     */
    public void ensureCapacity(int minCapacity) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::equals(ArrayList, Object) -> boolean
     * Source: java/util/ArrayList.main.lsl:657
     */
    public boolean equals(Object other) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (other == this) {
                result = true;
            } else {
                if ((other != null && other.getClass() == java.util.ArrayList.class)) {
                    final int expectedModCount = this.modCount;
                    final int otherExpectedModCount = ((ArrayList) ((Object) other)).modCount;
                    final SymbolicList<Object> otherStorage = ((ArrayList) ((Object) other)).storage;
                    if (this.storage.size() == otherStorage.size()) {
                        result = LibSLRuntime.equals(this.storage, otherStorage);
                    } else {
                        result = false;
                    }
                    ((ArrayList) ((Object) other))._checkForComodification(otherExpectedModCount);
                    _checkForComodification(expectedModCount);
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::forEach(ArrayList, Consumer) -> void
     * Source: java/util/ArrayList.main.lsl:687
     */
    public void forEach(Consumer _action) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (_action == null) {
                throw new NullPointerException();
            }
            final int expectedModCount = this.modCount;
            int i = 0;
            while ((this.modCount == expectedModCount) && (i < this.storage.size())) {
                final Object item = this.storage.get(i);
                _action.accept(item);
                i += 1;
            }
            ;
            _checkForComodification(expectedModCount);
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::get(ArrayList, int) -> Object
     * Source: java/util/ArrayList.main.lsl:712
     */
    public Object get(int index) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            _checkValidIndex(index, this.storage.size());
            result = this.storage.get(index);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::hashCode(ArrayList) -> int
     * Source: java/util/ArrayList.main.lsl:720
     */
    public int hashCode() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.hashCode(this.storage);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::indexOf(ArrayList, Object) -> int
     * Source: java/util/ArrayList.main.lsl:726
     */
    public int indexOf(Object o) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.ListActions.find(this.storage, o, 0, this.storage.size());
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::isEmpty(ArrayList) -> boolean
     * Source: java/util/ArrayList.main.lsl:732
     */
    public boolean isEmpty() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.storage.size() == 0;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::iterator(ArrayList) -> Iterator
     * Source: java/util/ArrayList.main.lsl:738
     */
    public Iterator iterator() {
        Iterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (stub.java.util.ArrayList_ListItr) ((Object) new ArrayList_ListItr((Void) null, 
                /* state = */ ArrayList_ListItr.__$lsl_States.Initialized, 
                /* parent = */ this, 
                /* cursor = */ 0, 
                /* expectedModCount = */ this.modCount, 
                /* lastRet = */ -1
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::lastIndexOf(ArrayList, Object) -> int
     * Source: java/util/ArrayList.main.lsl:748
     */
    public int lastIndexOf(Object o) {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = -1;
            final int size = this.storage.size();
            if (size != 0) {
                Engine.assume(size > 0);
                final SymbolicList<Object> items = this.storage;
                int i = 0;
                for (i = size - 1; i > -1; i += -1) {
                    final Object e = items.get(i);
                    if (LibSLRuntime.equals(o, e)) {
                        result = i;
                        break;
                    }
                }
                ;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::listIterator(ArrayList) -> ListIterator
     * Source: java/util/ArrayList.main.lsl:779
     */
    public ListIterator listIterator() {
        ListIterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (stub.java.util.ArrayList_ListItr) ((Object) new ArrayList_ListItr((Void) null, 
                /* state = */ ArrayList_ListItr.__$lsl_States.Initialized, 
                /* parent = */ this, 
                /* cursor = */ 0, 
                /* expectedModCount = */ this.modCount, 
                /* lastRet = */ -1
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::listIterator(ArrayList, int) -> ListIterator
     * Source: java/util/ArrayList.main.lsl:789
     */
    public ListIterator listIterator(int index) {
        ListIterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            _rangeCheckForAdd(index);
            result = (stub.java.util.ArrayList_ListItr) ((Object) new ArrayList_ListItr((Void) null, 
                /* state = */ ArrayList_ListItr.__$lsl_States.Initialized, 
                /* parent = */ this, 
                /* cursor = */ index, 
                /* expectedModCount = */ this.modCount, 
                /* lastRet = */ -1
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::parallelStream(ArrayList) -> Stream
     * Source: java/util/ArrayList.main.lsl:802
     */
    public Stream parallelStream() {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _makeStream(true);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::remove(ArrayList, Object) -> boolean
     * Source: java/util/ArrayList.main.lsl:808
     */
    public boolean remove(Object o) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int index = LibSLRuntime.ListActions.find(this.storage, o, 0, this.storage.size());
            result = index != -1;
            if (result) {
                _deleteElement(index);
            }
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::remove(ArrayList, int) -> Object
     * Source: java/util/ArrayList.main.lsl:817
     */
    public Object remove(int index) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _deleteElement(index);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::removeAll(ArrayList, Collection) -> boolean
     * Source: java/util/ArrayList.main.lsl:823
     */
    public boolean removeAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _batchRemove(c, false, 0, this.storage.size());
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::removeIf(ArrayList, Predicate) -> boolean
     * Source: java/util/ArrayList.main.lsl:829
     */
    public boolean removeIf(Predicate filter) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _removeIf(filter, 0, this.storage.size());
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::replaceAll(ArrayList, UnaryOperator) -> void
     * Source: java/util/ArrayList.main.lsl:835
     */
    public void replaceAll(UnaryOperator op) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (op == null) {
                throw new NullPointerException();
            }
            _replaceAllRange(op, 0, this.storage.size());
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::retainAll(ArrayList, Collection) -> boolean
     * Source: java/util/ArrayList.main.lsl:845
     */
    public boolean retainAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _batchRemove(c, true, 0, this.storage.size());
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::set(ArrayList, int, Object) -> Object
     * Source: java/util/ArrayList.main.lsl:851
     */
    public Object set(int index, Object element) {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _setElement(index, element);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::size(ArrayList) -> int
     * Source: java/util/ArrayList.main.lsl:857
     */
    public int size() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.storage.size();
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::sort(ArrayList, Comparator) -> void
     * Source: java/util/ArrayList.main.lsl:863
     */
    public void sort(Comparator c) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            _do_sort(0, this.storage.size(), c);
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::spliterator(ArrayList) -> Spliterator
     * Source: java/util/ArrayList.main.lsl:869
     */
    public Spliterator spliterator() {
        Spliterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (stub.java.util.ArrayList_Spliterator) ((Object) new ArrayList_Spliterator((Void) null, 
                /* state = */ ArrayList_Spliterator.__$lsl_States.Initialized, 
                /* parent = */ this, 
                /* index = */ 0, 
                /* fence = */ -1, 
                /* expectedModCount = */ 0
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::stream(ArrayList) -> Stream
     * Source: java/util/ArrayList.main.lsl:878
     */
    public Stream stream() {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _makeStream(false);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::subList(ArrayList, int, int) -> List
     * Source: java/util/ArrayList.main.lsl:884
     */
    public List subList(int fromIndex, int toIndex) {
        List result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            _subListRangeCheck(fromIndex, toIndex, this.storage.size());
            result = (stub.java.util.ArrayList_SubList) ((Object) new ArrayList_SubList((Void) null, 
                /* state = */ ArrayList_SubList.__$lsl_States.Initialized, 
                /* root = */ this, 
                /* parentList = */ null, 
                /* offset = */ fromIndex, 
                /* length = */ toIndex - fromIndex, 
                /* modCount = */ this.modCount
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::toArray(ArrayList) -> array<Object>
     * Source: java/util/ArrayList.main.lsl:898
     */
    public Object[] toArray() {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int len = this.storage.size();
            result = new Object[len];
            int i = 0;
            for (i = 0; i < len; i += 1) {
                result[i] = this.storage.get(i);
            }
            ;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::toArray(ArrayList, IntFunction) -> array<Object>
     * Source: java/util/ArrayList.main.lsl:918
     */
    public Object[] toArray(IntFunction generator) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final Object[] a = ((Object[]) generator.apply(0));
            final int aLen = a.length;
            final int len = this.storage.size();
            result = new Object[len];
            int i = 0;
            for (i = 0; i < len; i += 1) {
                result[i] = this.storage.get(i);
            }
            ;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::toArray(ArrayList, array<Object>) -> array<Object>
     * Source: java/util/ArrayList.main.lsl:936
     */
    public Object[] toArray(Object[] a) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int aLen = a.length;
            final int len = this.storage.size();
            if (aLen < len) {
                a = new Object[len];
            }
            result = a;
            int i = 0;
            for (i = 0; i < len; i += 1) {
                result[i] = this.storage.get(i);
            }
            ;
            if (aLen > len) {
                result[len] = null;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::toString(ArrayList) -> String
     * Source: java/util/ArrayList.main.lsl:959
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.toString(this.storage);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayListAutomaton::trimToSize(ArrayList) -> void
     * Source: java/util/ArrayList.main.lsl:965
     */
    public void trimToSize() {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::writeObject(ArrayList, ObjectOutputStream) -> void
     * Source: java/util/ArrayList.main.lsl:974
     */
    private void writeObject(ObjectOutputStream s) throws java.io.IOException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    /**
     * [FUNCTION] ArrayListAutomaton::readObject(ArrayList, ObjectInputStream) -> void
     * Source: java/util/ArrayList.main.lsl:982
     */
    private void readObject(ObjectInputStream s) throws java.io.IOException,
            java.lang.ClassNotFoundException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(ArrayList.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
