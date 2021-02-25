package HotelReservation;

public class PriceCalculator {
    double pricePerDay;
    int days;
    Season season;
    DiscountType discountType;

    public PriceCalculator(double pricePerDay, int days, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
    }

    public String calculate(){
        double value=pricePerDay*days*season.getValue()*(1-discountType.getValue()/100.0);

        return String.format("%.2f",value);
    }
}
