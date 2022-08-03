package hello.proxy.jdk.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello hello = new Hello();
        // 공통 로직 1
        log.info("start");
        String resultA = hello.callA();
        log.info("result = {}", resultA);

        // 공통 로직 2
        log.info("start");
        String resultB = hello.callB();
        log.info("result = {}", resultB);
    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 클래스 정보
        Class classHello = Class.forName("hello.proxy.jdk.dynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        dynamicCall(classHello.getMethod("callA"), target);
        dynamicCall(classHello.getMethod("callB"), target);
    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        String result = (String) method.invoke(target);
        log.info("result={}", result);
    }


    @Slf4j
   static class Hello {
        public String callA() {
            log.info("call A");
            return "A";
        }

        public String callB() {
            log.info("call B");
            return "B";
        }

   }
}
