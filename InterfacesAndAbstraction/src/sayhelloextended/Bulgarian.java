package sayhelloextended;

public class Bulgarian extends BasePerson {
    public Bulgarian(String name) {
        super(name);
    }

    private String name;


    @Override
    public String sayHello() {
        return "Здравей";
    }
}
