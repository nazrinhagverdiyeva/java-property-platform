public class CommercialSpace extends Property{
    private String businessType;
    private boolean hasParking;

    public CommercialSpace(String propertyId, String location, double area, double price, String businessType, boolean hasParking){
        super(propertyId, location, area, price);
        this.businessType = businessType;
        this.hasParking = hasParking;
    }
    @Override
    public double calculateCommission(){
        return getPrice() * 0.035;      // 3.5% commission
    }

    // Extra 500 AZN listing fee for commercial spaces
    @Override
    public double calculateFinalPrice(){
        return getPrice() + calculateCommission() + 500;
    }

    @Override
    public void displayBasicInfo(){
        super.displayBasicInfo();
        System.out.println("BusinessType: " + businessType +
                " | Parking: " + (hasParking ? "Yes" : "No"));
    }
}
