package genericketypy;

import java.util.ArrayList;
import java.util.LinkedList;

public class GenerickeTypyAplikacia {
    public static void main(String[] args) throws QueueException{
        LinkedList<String> ll = new LinkedList<>();
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.add("four");
        ll.add("five");
        System.out.println(ll);

        ArrayList<String> al = new ArrayList<>();
        al.add("ONE");
        al.add("TWO");
        al.add("THREE");
        System.out.println(al);

        Queue<String> qs = new Queue<>(5);
        qs.add.("jeden");
        qs.add("dva");

        Queue<String> qi = new Queue<>(3);
        qi.add(1);
        qi.add(2);
    }
}
