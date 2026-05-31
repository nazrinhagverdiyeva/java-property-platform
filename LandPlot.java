public class LandPlot extends Property {
    private boolean isZonedForConstruction;
    private String landCategory;

    public LandPlot(String propertyId, String location, double area, double price, boolean isZonedForConstruction, String landCategory) {
        super(propertyId, location, area, price);
        this.isZonedForConstruction = isZonedForConstruction;
        this.landCategory = landCategory;
    }

    @Override
    public double calculateCommission(){
        return getPrice() * 0.015;      // 1.5% commission - lowest
    }

    @Override
    public double calculateFinalPrice(){
        return getPrice() + calculateCommission();
    }

    @Override
    public void displayBasicInfo(){
        super.displayBasicInfo();
        System.out.println("ZonedForConstruction: " + (isZonedForConstruction ? "Yes" : "No") +
                " | LandCategory: " + landCategory);
    }
}


