package generated.testing.junit5;

import org.apiguardian.api.API;
import org.jacodb.approximation.annotation.Approximate;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static org.apiguardian.api.API.Status.DEPRECATED;
import static org.apiguardian.api.API.Status.STABLE;

@Approximate(Assertions.class)
public class AssertionsImpl {
    public static <V> V fail() {
        throw new AssertionFailedError();
    }

    public static <V> V fail(String message) {
        throw new AssertionFailedError(message);
    }

    public static <V> V fail(String message, Throwable cause) {
        throw new AssertionFailedError(message, cause);
    }

    public static <V> V fail(Throwable cause) {
        throw new AssertionFailedError("Assertions.fail was called", cause);
    }

    public static <V> V fail(Supplier<String> messageSupplier) {
        throw new AssertionFailedError(messageSupplier.get());
    }

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionFailedError();
        }
    }

    public static void assertTrue(boolean condition, Supplier<String> messageSupplier) {
        if (!condition) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    public static void assertTrue(BooleanSupplier booleanSupplier) {
        if (!booleanSupplier.getAsBoolean()) {
            throw new AssertionFailedError();
        }
    }

    public static void assertTrue(BooleanSupplier booleanSupplier, String message) {
        if (!booleanSupplier.getAsBoolean()) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertTrue(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier) {
        if (!booleanSupplier.getAsBoolean()) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    public static void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionFailedError();
        }
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertFalse(boolean condition, Supplier<String> messageSupplier) {
        if (condition) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    public static void assertFalse(BooleanSupplier booleanSupplier) {
        if (booleanSupplier.getAsBoolean()) {
            throw new AssertionFailedError();
        }
    }

    public static void assertFalse(BooleanSupplier booleanSupplier, String message) {
        if (booleanSupplier.getAsBoolean()) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertFalse(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier) {
        if (booleanSupplier.getAsBoolean()) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    public static void assertNull(Object actual) {
        if (actual != null) {
            throw new AssertionFailedError();
        }
    }

    public static void assertNull(Object actual, String message) {
        if (actual != null) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertNull(Object actual, Supplier<String> messageSupplier) {
        if (actual != null) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    public static void assertNotNull(Object actual) {
        if (actual == null) {
            throw new AssertionFailedError();
        }
    }

    public static void assertNotNull(Object actual, String message) {
        if (actual == null) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertNotNull(Object actual, Supplier<String> messageSupplier) {
        if (actual == null) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    // --- assertEquals --------------------------------------------------------

    private static boolean floatsAreEqual(float value1, float value2, float delta) {
        assertValidDelta(delta);
        return floatsAreEqual(value1, value2) || Math.abs(value1 - value2) <= delta;
    }

    private static void assertValidDelta(float delta) {
        if (Float.isNaN(delta) || delta < 0.0) {
            throw new AssertionFailedError("Invalid delta");
        }
    }

    private static void assertValidDelta(double delta) {
        if (Double.isNaN(delta) || delta < 0.0) {
            throw new AssertionFailedError("Invalid delta");
        }
    }

    private static boolean floatsAreEqual(float value1, float value2) {
        return Float.floatToIntBits(value1) == Float.floatToIntBits(value2);
    }

    private static boolean doublesAreEqual(double value1, double value2, double delta) {
        assertValidDelta(delta);
        return doublesAreEqual(value1, value2) || Math.abs(value1 - value2) <= delta;
    }

    private static boolean doublesAreEqual(double value1, double value2) {
        return Double.doubleToLongBits(value1) == Double.doubleToLongBits(value2);
    }

    public static void assertEquals(short expected, short actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    public static void assertEquals(short expected, Short actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    public static void assertEquals(Short expected, short actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Short expected, Short actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    public static void assertEquals(short expected, short actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertEquals(short expected, Short actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    public static void assertEquals(Short expected, short actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Short expected, Short actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(short expected, short actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(short expected, Short actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(Short expected, short actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Short expected, Short actual, Supplier<String> messageSupplier) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(byte expected, byte actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(byte expected, Byte actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(Byte expected, byte actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Byte expected, Byte actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(byte expected, byte actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(byte expected, Byte actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(Byte expected, byte actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Byte expected, Byte actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(byte expected, byte actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(byte expected, Byte actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(Byte expected, byte actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Byte expected, Byte actual, Supplier<String> messageSupplier) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(int expected, Integer actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(Integer expected, int actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Integer expected, Integer actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(int expected, Integer actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(Integer expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Integer expected, Integer actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(int expected, int actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(int expected, Integer actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(Integer expected, int actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Integer expected, Integer actual, Supplier<String> messageSupplier) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(long expected, Long actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(Long expected, long actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Long expected, Long actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(long expected, long actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(long expected, Long actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(Long expected, long actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Long expected, Long actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(long expected, long actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(long expected, Long actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(Long expected, long actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Long expected, Long actual, Supplier<String> messageSupplier) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     */
    public static void assertEquals(float expected, float actual) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     */
    public static void assertEquals(float expected, Float actual) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     */
    public static void assertEquals(Float expected, float actual) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Float expected, Float actual) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(float expected, float actual, String message) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(float expected, Float actual, String message) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(Float expected, float actual, String message) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Float expected, Float actual, String message) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(float expected, float actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(float expected, Float actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(Float expected, float actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Float expected, Float actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     */
    public static void assertEquals(float expected, float actual, float delta) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual, delta)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(float expected, float actual, float delta, String message) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual, delta)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Float#equals(Object)} and
     * {@link Float#compare(float, float)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(float expected, float actual, float delta, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.floatsAreEqual(expected, actual, delta)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     */
    public static void assertEquals(double expected, double actual) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     */
    public static void assertEquals(double expected, Double actual) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     */
    public static void assertEquals(Double expected, double actual) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Double expected, Double actual) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(double expected, double actual, String message) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(double expected, Double actual, String message) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(Double expected, double actual, String message) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Double expected, Double actual, String message) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(double expected, double actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(double expected, Double actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(Double expected, double actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Double expected, Double actual, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     */
    public static void assertEquals(double expected, double actual, double delta) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual, delta)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(double expected, double actual, double delta, String message) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual, delta)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal within the given non-negative {@code delta}.
     * <p>Equality imposed by this method is consistent with {@link Double#equals(Object)} and
     * {@link Double#compare(double, double)}.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(double expected, double actual, double delta, Supplier<String> messageSupplier) {
        if (!AssertionsImpl.doublesAreEqual(expected, actual, delta)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(char expected, char actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(char expected, Character actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     */
    public static void assertEquals(Character expected, char actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Character expected, Character actual) {
        if (expected != actual) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(char expected, char actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(char expected, Character actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     */
    public static void assertEquals(Character expected, char actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Character expected, Character actual, String message) {
        if (expected != actual) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(char expected, char actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(char expected, Character actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     */
    public static void assertEquals(Character expected, char actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @since 5.4
     */
    @API(status = STABLE, since = "5.4")
    public static void assertEquals(Character expected, Character actual, Supplier<String> messageSupplier) {
        if (expected != actual) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If both are {@code null}, they are considered equal.
     *
     * @see Object#equals(Object)
     */
    public static void assertEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError();
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>Fails with the supplied failure {@code message}.
     *
     * @see Object#equals(Object)
     */
    public static void assertEquals(Object expected, Object actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(message);
        }
    }

    /**
     * <em>Assert</em> that {@code expected} and {@code actual} are equal.
     * <p>If both are {@code null}, they are considered equal.
     * <p>If necessary, the failure message will be retrieved lazily from the supplied {@code messageSupplier}.
     *
     * @see Object#equals(Object)
     */
    public static void assertEquals(Object expected, Object actual, Supplier<String> messageSupplier) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionFailedError(messageSupplier.get());
        }
    }
}
