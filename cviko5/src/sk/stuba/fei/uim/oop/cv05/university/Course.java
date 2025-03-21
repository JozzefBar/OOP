package sk.stuba.fei.uim.oop.cv05.university;

public class Course {
    private String name;
    private String description;
    private Enrollment[] entrollment;
    private int enrollmentCount;

    public Course(String name, String description) { // konstruktor - automaticky inicializuje novu premennu
        this.name = name;
        this.description = description;
        this.enrollmentCount = 0;
        this.entrollment = new Enrollment[100];
    }

    public void add(Student student) {
        if (this.enrollmentCount >= this.entrollment.length) {
            return;
        }
        Enrollment enroll = new Enrollment(student);
        this.entrollment[this.enrollmentCount] = enroll; // jednoducha implementacia, pretoze studntov len pridavame
        ++ this.enrollmentCount;
    }

    public void setGrade(Student student, char grade) {
        for (Enrollment e: this.entrollment) {
            if (e != null && e.getStudent() == student) { // porovnavanie referencii
                e.setGrade(grade);
                return;
            }
        }
    }

    @Override // @Override si zatial nevsimajte
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(": ");
        for (Enrollment e: entrollment) {
            if (e != null) {
                builder.append(e);
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
