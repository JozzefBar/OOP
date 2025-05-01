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
        legalForm = isValidBirthNumber(id) ? LegalForm.NATURAL : LegalForm.LEGAL;
        paidOutAmount = 0;
        contracts = new LinkedHashSet<>(); //neobsahuje duplikáty a a zachováva poradie
    }

    public static boolean isValidBirthNumber(String birthNumber){
        if(birthNumber == null || !(birthNumber.length() == 9 || birthNumber.length() == 10)) return false;

        for (char c : birthNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        int month = Integer.parseInt(birthNumber.substring(2, 4));
        int fixedMonth = (month >= 51) ? month - 50 : month;

        if (!(fixedMonth >= 1 && fixedMonth <= 12))
            return false;

        int year = Integer.parseInt(birthNumber.substring(0, 2));
        int day = Integer.parseInt(birthNumber.substring(4, 6));

        int fullYear;
        if (birthNumber.length() == 9) {
            if (year > 53) return false;
            fullYear = 1900 + year;
        }
        else {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int digit = Character.digit(birthNumber.charAt(i), 10);
                sum += (i % 2 == 0) ? digit : -digit;
            }

            if (sum % 11 != 0)
                return false;

            fullYear = (year >= 54) ? 1900 + year : 2000 + year;
        }
        try {
            LocalDate date = LocalDate.of(fullYear, fixedMonth, day);
        } catch (DateTimeException e) {
            return false;
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
