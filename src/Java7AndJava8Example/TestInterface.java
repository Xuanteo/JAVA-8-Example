package Java7AndJava8Example;

@FunctionalInterface
public interface TestInterface {
    public void add();

    default String sayHi() {
        return "Hi";
    }

    static boolean isTrue() {
        return true;
    }
}

