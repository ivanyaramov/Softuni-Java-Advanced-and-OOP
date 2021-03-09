package sayhelloextended;

public interface Person {
    public String getName();
    default String sayHello(){
        return "Hello";
    }
}
