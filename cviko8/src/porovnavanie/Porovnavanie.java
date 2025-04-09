package porovnavanie;

import java.util.Arrays;

public class Porovnavanie {
    public static void main(String[] args){
        Student peter = new Student("Peter", 2024);
        Student peter2 = new Student("Peter", 2024);
        Student peter3 = new Student("Peter", 2025);
        Student pavol = new Student("Pavol", 2023);
        Student igor = new Student("Igor", 2024);
        Student jozef = new Student("Jozef", 2023);

        //System.out.println(peter);
        System.out.println(peter.equals(peter2));
        System.out.println(peter.equals(pavol));

        Student[] array = {peter, peter3, pavol, igor, jozef};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new StudentComparator());
        System.out.println(Arrays.toString(array));
    }
}
