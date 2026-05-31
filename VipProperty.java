// Demonstrates multiple inheritance - extends Property and implements VipListing
public class VipProperty extends Property implements VipListing{

    public VipProperty(String propertyId, String location, double area, double price) {
        super(propertyId, location, area, price);
    }

    @Override
    public double calculateVipFee() {
        return getPrice() * 0.05;       //5% VIP fee - my decision
    }

    @Override
    public String getVipBenefits() {
        return "Vip Benefits here";
    }

    @Override
    public double calculateCommission() {
        return getPrice() * 0.04;       // 4% - our own decision
    }

    // Final price includes VIP fee on top of commission
    @Override
    public double calculateFinalPrice() {
        return getPrice() + calculateCommission() + calculateVipFee();
    }

    @Override
    public void displayBasicInfo(){
        super.displayBasicInfo();
        System.out.println("VIP Benefits: " + getVipBenefits() +
                " | VIP Fee: " + calculateVipFee() + "AZN");
    }
}
