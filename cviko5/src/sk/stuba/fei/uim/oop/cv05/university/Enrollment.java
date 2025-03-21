package sk.stuba.fei.uim.oop.cv05.university;

class Enrollment {
    private Student student;
    private char grade;

    public Enrollment(Student student) { // konstruktor - automaticky inicializuje novu premennu
        this.student = student;
        this.grade = '?';
    }

    public Student getStudent() {
        return this.student;
    }

    public char getGrade() {
        return this.grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override // @Override si zatial nevsimajte
    public String toString() {
        return this.student.toString() + ": " + this.grade;
    }
}
