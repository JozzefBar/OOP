package payment;

import company.InsuranceCompany;
import contracts.AbstractContract;
import contracts.InvalidContractException;
import contracts.MasterVehicleContract;
import contracts.SingleVehicleContract;

import java.util.*;

public class PaymentHandler {
    private final Map<AbstractContract, Set<PaymentInstance>> paymentHistory;
    private final InsuranceCompany insurer;

    public PaymentHandler(InsuranceCompany insurer){
        if(insurer == null)
            throw new IllegalArgumentException("Failure to fulfill the condition");

        this.insurer = insurer;
        this.paymentHistory = new HashMap<>();
    }

    public Map<AbstractContract, Set<PaymentInstance>> getPaymentHistory(){
        return paymentHistory;
    }

    public void pay(MasterVehicleContract contract, int amount){
        int originalAmount = amount;

        if (contract == null || amount <= 0) {
            throw new IllegalArgumentException("Failure to fulfill the condition");
        }
        if (!contract.isActive() || !contract.getInsurer().equals(insurer) || contract.getChildContracts().isEmpty()) {
            throw new InvalidContractException("contract");
        }

        for(SingleVehicleContract childContract: contract.getChildContracts()){
            if (!childContract.isActive()) continue;

            ContractPaymentData data = childContract.getContractPaymentData();
            int outstandingBalance = data.getOutstandingBalance();

            if(outstandingBalance > 0)
                if(amount > outstandingBalance){
                    amount -= outstandingBalance;
                    data.setOutstandingBalance(0);
                }
            else{
                    data.setOutstandingBalance(outstandingBalance - amount);
                    amount = 0;
                    break;
                }
        }
        while(amount > 0){
            boolean isProgress = false;
            for(SingleVehicleContract childContract: contract.getChildContracts()){
                if (!childContract.isActive()) continue;

                ContractPaymentData data = childContract.getContractPaymentData();
                int outstandingBalance = data.getOutstandingBalance();
                int premium = data.getPremium();

                if(amount >= premium){
                    data.setOutstandingBalance(outstandingBalance - premium);
                    amount -= premium;
                    isProgress = true;
                }
                else{
                    data.setOutstandingBalance(outstandingBalance - amount);
                    amount = 0;
                    isProgress = true;
                    break;
                }
            }

            if (!isProgress) break;    //pripad len ak by bolo amount > 0 a vsetky kontrakty neaktivne, (for by isiel furt dokola)
        }

        int paidAmount = originalAmount - amount;
        PaymentInstance payment = new PaymentInstance(insurer.getCurrentTime(), paidAmount);

        paymentHistory.computeIfAbsent(contract, k -> new TreeSet<>()).add(payment);
    }

    public void pay(AbstractContract contract, int amount){
        if (contract == null || amount <= 0) {
            throw new IllegalArgumentException("Failure to fulfill the condition");
        }
        if (!contract.isActive() || !contract.getInsurer().equals(insurer)) {
            throw new InvalidContractException("contract");
        }

        ContractPaymentData data = contract.getContractPaymentData();
        data.setOutstandingBalance(data.getOutstandingBalance() - amount);

        PaymentInstance payment = new PaymentInstance(insurer.getCurrentTime(), amount);

        paymentHistory.computeIfAbsent(contract, k -> new TreeSet<>()).add(payment);
    }
}
