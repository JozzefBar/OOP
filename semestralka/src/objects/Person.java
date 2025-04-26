package objects;

import contracts.AbstractContract;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private final String id;
    private final LegalForm legalForm;
    private int paidOutAmount;
    private final Set<AbstractContract> contracts;

    public Person(String id){
        if(id == null || id.isEmpty() || !(isValidBirthNumber(id) || isValidRegistrationNumber(id)))
            throw new IllegalArgumentException("Failure to fulfill the condition");

        this.id = id;
        this.legalForm = isValidBirthNumber(id) ? LegalForm.NATURAL : LegalForm.LEGAL;
        paidOutAmount = 0;
        this.contracts = new LinkedHashSet<>();
    }

    public static boolean isValidBirthNumber(String birthNumber){
        if(birthNumber == null || birthNumber.length() < 9 || birthNumber.length() > 10) return false;

        for (char c : birthNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int month = Integer.parseInt(birthNumber.substring(2, 4));
        if (!((month >= 1 && month <= 12) || (month >= 51 && month <= 62))) {
            return false;
        }

        int year = Integer.parseInt(birthNumber.substring(0, 2));
        int day = Integer.parseInt(birthNumber.substring(4, 6));

        if(birthNumber.length() == 9) {
            try {
                LocalDate date = LocalDate.of(1900 + year, month, day);
            } catch (DateTimeException e) {
                return false;
            }
        }
        else{
            int sum = 0;
            for(int i = 0; i < 10; i++){
                sum += (i % 2 == 0) ? Character.getNumericValue(birthNumber.charAt(i)) : -Character.getNumericValue(birthNumber.charAt(i));
            }

            if(sum % 11 != 0) return false;

            int correctYear = (year <= 53) ? 2000 + year : 1900 + year;
            int monthFixed = (month >= 51) ? month - 50 : month;

            try {
                LocalDate date = LocalDate.of(correctYear, monthFixed, day);
            } catch (DateTimeException e) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidRegistrationNumber(String registrationNumber){
        if (registrationNumber == null || !(registrationNumber.length() == 6 || registrationNumber.length() == 8)) return false;

        for (char c : registrationNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public String getId(){
        return id;
    }

    public int getPaidOutAmount(){
        return paidOutAmount;
    }

    public LegalForm getLegalForm(){
        return legalForm;
    }

    public Set<AbstractContract> getContracts(){
        return contracts;
    }

    public void addContract(AbstractContract contract){
        if(contract == null)
            throw new IllegalArgumentException("Failure to fulfill the condition");
        contracts.add(contract);
    }

    public void payout(int paidOutAmount){
        if(paidOutAmount <= 0)
            throw new IllegalArgumentException("Failure to fulfill the condition");

        this.paidOutAmount += paidOutAmount;
    }
}
