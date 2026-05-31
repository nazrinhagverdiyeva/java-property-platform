// Interface - only method signatures, no implementation
// Any class that implements this must override both methods
public interface MortgageEligible {
    public boolean isEligibleForMortgage();
    public double calculateMonthlyPayment(int years, double interestRate);
}
