package sk.stuba.fei.uim.oop.cv05.counter;

public class CounterApplication {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println(c1.getValue() + " " + c2.getValue());
        c1.add();
        System.out.println(c1.getValue() + " " + c2.getValue());
        c1.add();
        c2.add();
        System.out.println(c1.getValue() + " " + c2.getValue());

        c2.reduce();
        System.out.println(c1.getValue() + " " + c2.getValue());
        c2.reduce();
        System.out.println(c1.getValue() + " " + c2.getValue());
        c2.reduce();
        System.out.println(c1.getValue() + " " + c2.getValue());

//        c2.getValue();
//        int a = c1.value;
//        int b = c2.value;
//        c1.value = 10;
//        c1.setValue(10)

//        Course angl; // po naimportovani mozeme pouzit, pretoze je "public class"
//        Enrollment e; // nemozeme pouzit pretoze je (package-private) "class"  v inom baliku
    }
}
