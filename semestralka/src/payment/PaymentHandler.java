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

            int outstandingBalance = childContract.getContractPaymentData().outstandingBalance;

            if(outstandingBalance > 0)
                if(amount > outstandingBalance){
                    amount -= outstandingBalance;
                    childContract.getContractPaymentData().outstandingBalance = 0;
                }
            else{
                    childContract.getContractPaymentData().outstandingBalance -= amount;
                    amount = 0;
                    break;
                }

        }
        while(amount > 0){
            for(SingleVehicleContract childContract: contract.getChildContracts()){
                if (!childContract.isActive()) continue;

                int premium = childContract.getContractPaymentData().getPremium();

                if(amount >= premium){
                    childContract.getContractPaymentData().outstandingBalance -= premium;
                    amount -= premium;
                }
                else{
                    childContract.getContractPaymentData().outstandingBalance -= amount;
                    amount = 0;
                    break;
                }
            }
        }

        int paidAmount = originalAmount - amount;
        PaymentInstance payment = new PaymentInstance(insurer.getCurrentTime(), paidAmount);

        paymentHistory.put(contract, new TreeSet<>());
        paymentHistory.get(contract).add(payment);

        //paymentHistory.computeIfAbsent(contract, k -> new TreeSet<>()).add(payment);
        //to isté v jednom riadku
    }

    public void pay(AbstractContract contract, int amount){
        if (contract == null || amount <= 0) {
            throw new IllegalArgumentException("Failure to fulfill the condition");
        }
        if (!contract.isActive() || !contract.getInsurer().equals(insurer)) {
            throw new InvalidContractException("contract");
        }

        contract.getContractPaymentData().outstandingBalance -= amount;
        PaymentInstance payment = new PaymentInstance(insurer.getCurrentTime(), amount);

        paymentHistory.put(contract, new TreeSet<>());
        paymentHistory.get(contract).add(payment);

        //paymentHistory.computeIfAbsent(contract, k -> new TreeSet<>()).add(payment);
        //to isté v jednom riadku
    }
}
