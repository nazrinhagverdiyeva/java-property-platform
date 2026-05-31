// Abstract class - cannot be instantiated directly, serves as a blueprint for all property types
public abstract class Property {
    private String propertyId;
    private String location;
    private double area;
    private double price;
    private final String PLATFORM_NAME = "Emlak.az";

    public Property(String propertyId, String location, double area, double price){
        this.propertyId = propertyId;
        this.location = location;
        this.area = area;
        this.price = price;
    }

    public void displayBasicInfo(){
        System.out.println("PROPERTY: " + propertyId +
                "\nLocation: " + location +
                "\nArea: " + area +
                " | Price: " + price +
                "\nPlatform Name: " + PLATFORM_NAME);
    }

    // Validation - prevents negative price input
    public void setPrice(double price){
        if (price < 0) {
            System.out.println("Price cannot be negative!");
        }else{
            this.price = price;
        }
    }

    // Getter needed because price is private - subclasses access it through here
    public double getPrice(){
        return price;
    }
    public String getPropertyID(){
        return propertyId;
    }

    // Subclasses must override these
    public abstract double calculateCommission();
    public abstract double calculateFinalPrice();
}
