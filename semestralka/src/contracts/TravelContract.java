package contracts;

import company.InsuranceCompany;
import objects.LegalForm;
import objects.Person;
import payment.ContractPaymentData;

import java.util.Set;

public class TravelContract extends AbstractContract{
    private final Set<Person> insuredPersons;

    public TravelContract(String contractNumber, InsuranceCompany insurer, Person policyHolder, ContractPaymentData contractPaymentData, int coverageAmount, Set<Person> personsToInsure){
        super(contractNumber, insurer, policyHolder, contractPaymentData, coverageAmount);

        if (personsToInsure == null || personsToInsure.isEmpty())
            throw new IllegalArgumentException("Set of persons to insure must not be null or empty.");
        if (contractPaymentData == null)
            throw new IllegalArgumentException("ContractPaymentData must not be null.");

        for(Person eachOne : personsToInsure){
            if(eachOne.getLegalForm() != LegalForm.NATURAL)
                throw new IllegalArgumentException("Only natural persons can be insured.");
        }

        this.insuredPersons = personsToInsure;
    }

    public Set<Person> getInsuredPersons(){
        return insuredPersons;
    }
}
