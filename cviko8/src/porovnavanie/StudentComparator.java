package porovnavanie;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int yearDiff = s1.getStartYear() - s2.getStartYear();
        if (yearDiff != 0) {
            return yearDiff;
        }
        else {
            return s1.getName().compareTo(s2.getName());
        }
    }
}
