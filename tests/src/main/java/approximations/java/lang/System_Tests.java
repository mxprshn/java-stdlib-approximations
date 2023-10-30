package approximations.java.lang;

import approximations.Test;

import java.lang.System;

public final class System_Tests {

    public static int test_in (int exe) {
        if (System.in == null)
            return -1;

        // TODO: more tests

        return 0;
    }

    @Test(executionMax = 1)
    public static int test_out (int exe) {
        switch (exe) {
            case 0: {
                if (System.out == null)
                    return -1;
                break;
            }

            case 1: {
                System.out.println();
                System.out.println(1);
                System.out.println("2");
                break;
            }

            // TODO: more tests

            default: return 0;
        }
        return exe;
    }

    @Test(executionMax = 1)
    public static int test_err (int exe) {
        switch (exe) {
            case 0: {
                if (System.err == null)
                    return -1;
                break;
            }

            case 1: {
                System.err.println();
                System.err.println(1);
                System.err.println("2");
                break;
            }

            // TODO: more tests

            default: return 0;
        }
        return exe;
    }

}
