package jdk8.defaultmethod;

public interface DefaultMethodInterface2 {

    String method();

    default String defaultMethod() {
        return "Default Method 2nd";
    }

    static String staticMethod() {
        return "Static Method 2nd";
    }
}
