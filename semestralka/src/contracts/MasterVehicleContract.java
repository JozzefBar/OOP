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

        if(policyHolder.getLegalForm() == LegalForm.NATURAL)
            throw new IllegalArgumentException("MasterVehicleContract must be held by a legal entity.");

        childContracts = new LinkedHashSet<>();   //neobsahuje duplikáty a a zachováva poradie
    }

    public Set<SingleVehicleContract> getChildContracts(){
        return childContracts;
    }

    public void requestAdditionOfChildContract(SingleVehicleContract contract){
        insurer.moveSingleVehicleContractToMasterVehicleContract(this, contract);
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
        isActive = false;
    }

    @Override
    public void pay(int amount) {
        insurer.getHandler().pay(this, amount);
    }

    @Override
    public void updateBalance() {
        insurer.chargePremiumOnContract(this);
    }
}
