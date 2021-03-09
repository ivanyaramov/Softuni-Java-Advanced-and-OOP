package birthdaycelebrations;

public class Robot implements Identifiable{
    String id;
    String model;

    @Override
    public String getId() {
        return this.id;
    }
    public String getModel() {
        return this.model;
    }
}
