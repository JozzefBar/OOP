package porovnavanie;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name; // meno
    private int startYear; // rok zaciatku studia

    public Student(String name, int startYear) {
        this.name = name;
        this.startYear = startYear;
    }

    public String getName() {
        return name;
    }

    public int getStartYear() {
        return startYear;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name, startYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return startYear == student.startYear && Objects.equals(name, student.name);
//        if (name != null) name.equals(student.name)
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startYear);
    }

    @Override
    public int compareTo(Student other) {
        int nameOrder = name.compareTo(other.name);
        if (nameOrder != 0) {
            return nameOrder;
        }
        else {
            return startYear - other.startYear;
        }
    }
}

// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Object.html
// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Comparable.html
// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Comparator.html
