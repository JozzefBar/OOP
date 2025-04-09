package porovnavanie;


import java.util.Objects;

public class Student implements Comparable<Student>{
    public String name;
    private int startYear;

    public Student(String name, int startYear){
        this.name = name;
        this.startYear = startYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s (%d)", name, startYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return startYear == student.startYear && Objects.equals(name, student.name);
        //if (name != null) name.equals(student.name)
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startYear);
    }

    @Override
    public int compareTo(Student other){
        int nameOrder = name.compareTo(other.name);
        if(nameOrder != 0){
            return nameOrder;
        }
        else{
            return startYear - other.startYear;
        }
    }
}
