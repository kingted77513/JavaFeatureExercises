package jdk8.defaultmethod;

public class DefaultMethodClass implements DefaultMethodInterface1, DefaultMethodInterface2 {
    @Override
    public String method() {
        return "Method";
    }

    @Override
    public String defaultMethod() {
        return DefaultMethodInterface1.super.defaultMethod();
    }
}
