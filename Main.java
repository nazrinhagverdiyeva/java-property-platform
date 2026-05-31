import java.util.ArrayList;

public class Main{
    // static final - accessible everywhere, value never changes
    public static final double VAT_RATE = 0.18;

    public static void main(String[] args){
        // Upcasting - ArrayList holds different property types under one parent type
        ArrayList<Property> properties = new ArrayList<>();

        properties.add(new ResidentialApartment("R-01", "Baku, Center", 125.45, 500000, 3, 4, true));
        properties.add(new CommercialSpace("R-02", "Baku, Yasamal",204.12, 350000, "Office", false ));
        properties.add(new LandPlot("R-03", "Baku, WhiteCity", 150.89, 750000, true, "Commercial"));
        properties.add(new VipProperty("R-04", "Baku, 28 May", 89.25, 450000));

        for (Property property : properties){
            System.out.println("========================================");
            property.displayBasicInfo(); // dynamic method dispatch - calls the correct subclass method at runtime
            System.out.printf("Commission: %.2f AZN%n", property.calculateCommission());
            // VAT applied on top of final price
            System.out.println("Final Price (inc. VAT & fees): " + (property.calculateFinalPrice() * (1 + VAT_RATE)) + " AZN");

            // instanceof - checks if property implements MortgageEligible (only ResidentialApartment does)
            if (property instanceof MortgageEligible m) {
                System.out.println("Mortgage Eligible: " + (m.isEligibleForMortgage() ? "Yes" : "No"));
                System.out.printf("Monthly Payment (20 years, 5.5): %.2f AZN%n" , m.calculateMonthlyPayment(20, 5.5));
            }

            // instanceof - checks if property implements VipListing (only VipProperty does)
            if (property instanceof VipListing v) {
                System.out.println("VIP Fee: " + v.calculateVipFee());
            }
        }


    }
}
