package sk.stuba.fei.uim.oop.cv05.university;

public class UniversityApplication {
    public static void main(String[] args) {
        Student peter = new Student("Peter", "Prak");
        Student jan = new Student("Jan", "Jariabek");
        Student andrej = new Student("Andrej", "Drak");

        System.out.println(peter); // System.out.println(peter.toString());
        System.out.println(jan);
        System.out.println(andrej);

        Course oop = new Course("OOP", "vsetko su objekty");
        Course dbs = new Course("DBS", "o ukladani udajov");

        oop.add(peter);
        oop.add(jan);
        dbs.add(peter);
        dbs.add(andrej);

        oop.setGrade(peter, 'A');
        dbs.setGrade(andrej, 'B');

        System.out.println(oop);
        System.out.println(dbs);
    }
}
