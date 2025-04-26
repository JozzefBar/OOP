package payment;

import java.time.LocalDateTime;

public class ContractPaymentData {
    private int premium;
    private PremiumPaymentFrequency premiumPaymentFrequency;
    LocalDateTime nextPaymentTime;
    int outstandingBalance;

    public ContractPaymentData(int premium, PremiumPaymentFrequency premiumPaymentFrequency, LocalDateTime nextPaymentTime, int outstandingBalance){
        if(premium <= 0 || premiumPaymentFrequency == null || nextPaymentTime == null)
            throw new IllegalArgumentException("Failure to fulfill the condition");

        this.premium = premium;
        this.premiumPaymentFrequency = premiumPaymentFrequency;
        this.nextPaymentTime = nextPaymentTime;
        this.outstandingBalance = outstandingBalance;
    }

    public int getPremium(){
        return premium;
    }

    public void setPremium(int premium){
        if (premium <= 0)
            throw new IllegalArgumentException("Premium must be positive");
        this.premium = premium;
    }

    public void setOutstandingBalance(int outstandingBalance){
        this.outstandingBalance = outstandingBalance;
    }

    public int getOutstandingBalance(){
        return outstandingBalance;
    }

    public void setPremiumPaymentFrequency(PremiumPaymentFrequency premiumPaymentFrequency){
        if (premiumPaymentFrequency == null)
            throw new IllegalArgumentException("Frequency cannot be null");
        this.premiumPaymentFrequency = premiumPaymentFrequency;
    }

    public PremiumPaymentFrequency getPremiumPaymentFrequency(){
        return premiumPaymentFrequency;
    }

    public LocalDateTime getNextPaymentTime(){
        return nextPaymentTime;
    }

    public void updateNextPaymentTime(){
        this.nextPaymentTime = nextPaymentTime.plusMonths(premiumPaymentFrequency.getValueInMonths());
    }
}
