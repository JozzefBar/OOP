package sk.stuba.fei.uim.oop.cv05.university;

public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) { // konstruktor - automaticky inicializuje novu premennu
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override // @Override si zatial nevsimajte
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
