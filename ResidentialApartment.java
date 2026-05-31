// Implements MortgageEligible - we decided this type is most suitable for mortgage eligibility
public class ResidentialApartment extends Property implements MortgageEligible {
    private int floor;
    private int numberOfRooms;
    private boolean hasElevator;

    // super() calls the parent constructor
    public ResidentialApartment(String propertyId, String location, double area, double price, int floor, int numberOfRooms, boolean hasElevator){
        super(propertyId, location, area, price);
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.hasElevator = hasElevator;
    }

    @Override
    public double calculateCommission(){
        return getPrice()*0.02;
    }

    @Override
    public double calculateFinalPrice(){
        return getPrice() + calculateCommission();
    }

    @Override
    public void displayBasicInfo(){
        super.displayBasicInfo();
        System.out.println("Floor: " + floor +
                " | Rooms: " + numberOfRooms +
                " | Elevator: " + (hasElevator ? "Yes" : "No"));
    }

    // Our own condition: properties under 600,000 AZN are mortgage eligible
    @Override
    public boolean isEligibleForMortgage() {
        return getPrice() < 600000;
    }

    // Standard mortgage formula: monthly = (P * r) / (1 - (1+r)^-n)
    @Override
    public double calculateMonthlyPayment(int years, double interestRate) {
        double monthly = (interestRate / 100) / 12;
        int payments = years * 12;
        return (getPrice() * monthly) / (1 - Math.pow(1 + monthly, -payments));
    }

}
