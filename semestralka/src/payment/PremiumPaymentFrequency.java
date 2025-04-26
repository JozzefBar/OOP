package payment;

public enum PremiumPaymentFrequency {
    ANNUAL, SEMI_ANNUAL, QUARTERLY, MONTHLY;

    public int getValueInMonths(){
        return this == ANNUAL ? 12 : this == SEMI_ANNUAL ? 6 : this == QUARTERLY ? 3 : 1;
    }
}
