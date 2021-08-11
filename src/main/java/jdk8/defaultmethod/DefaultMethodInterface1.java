package jdk8.defaultmethod;

public interface DefaultMethodInterface1 {

    String method();

    default String defaultMethod() {
        return "Default Method 1st";
    }

    static String staticMethod() {
        return "Static Method 1st";
    }
}
