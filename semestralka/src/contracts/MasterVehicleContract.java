package contracts;

import company.InsuranceCompany;
import objects.LegalForm;
import objects.Person;

import java.util.LinkedHashSet;
import java.util.Set;

public class MasterVehicleContract extends AbstractVehicleContract{
    private final Set<SingleVehicleContract> childContracts;

    public MasterVehicleContract(String contractNumber, InsuranceCompany insurer, Person beneficiary, Person policyHolder) {
        super(contractNumber, insurer, beneficiary, policyHolder, null, 0);

        if(contractPaymentData != null || coverageAmount != 0 || policyHolder.getLegalForm() == LegalForm.NATURAL)
            throw new IllegalArgumentException("Failure to fulfill the condition");

        childContracts = new LinkedHashSet<>();
    }

    public Set<SingleVehicleContract> getChildContracts(){
        return childContracts;
    }

    public void requestAdditionOfChildContract(SingleVehicleContract contract){
        childContracts.add(contract);
    }

    @Override
    public boolean isActive(){
        if(childContracts.isEmpty())
            return super.isActive();

        for(SingleVehicleContract eachOne : childContracts){
            if(eachOne.isActive())
                return true;
        }

        return false;
    }

    @Override
    public void setInactive(){
        for(SingleVehicleContract eachOne : childContracts){
            eachOne.setInactive();
        }
        super.setInactive();
    }

    @Override
    public void pay(int amount) {
        insurer.getHandler().pay(this, amount);
    }
}
