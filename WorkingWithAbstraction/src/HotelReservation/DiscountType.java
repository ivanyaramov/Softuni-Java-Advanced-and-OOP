package HotelReservation;

public enum DiscountType {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);
    private int percentage;

    private DiscountType(int percentage) {
        this.percentage = percentage;
    }
    public int getValue(){
        return this.percentage;
    }

}
