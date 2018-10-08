import java.lang.reflect.*;
import java.lang.annotation.*;

public class RunTests {
    public static void main(String args[]) throws Exception {
        int passed = 0;
        int failed = 0;
        for (Method m : Class.class.getMethods()) {
            if (!m.isAnnotationPresent(Test.class)) continue;
            try {
                m.invoke(null);
                ++passed;
            } catch (Throwable t) {
              System.out.printf("Test %s failed: %s %n", m, t.getCause());
              ++failed;
            }
        }

        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {}

class Foo {
    @Test public static void m1() {}
    public static void m2() {}
    @Test public static void m3() {
        throw new RuntimeException("Boom");
    }
    public static void m4() {}
    @Test public static void m5() {}
    public static void m6() {}
    @Test public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() {}
}

