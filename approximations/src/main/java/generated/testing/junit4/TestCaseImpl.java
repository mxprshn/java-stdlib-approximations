package generated.testing.junit4;

import junit.framework.TestCase;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;

@Approximate(TestCase.class)
public class TestCaseImpl {

    TestCaseImpl(Void voidArg) {
        // Dummy ctor to avoid default ctor overriding
    }

    protected void runTest() throws Throwable {
        Engine.runTestMethod();
    }
}
