package genericketypy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerickeTypyAplikacia {
    public static void main(String[] args) throws QueueException {
        List<String> ll = new LinkedList<String>(); // diamant: new LinkedList<>()
        ll.add("one");
        ll.add("two");
        ll.add("three");
        ll.add("four");
        ll.add("five");
        System.out.println(ll);

        List<String> al = new ArrayList<>();
        al.add("ONE");
        al.add("TWO");
        al.add("THREE");
        System.out.println(al);

        Queue<String> qs = new Queue<String>(5);
        qs.add("jeden");
        qs.add("dva");
        qs.add("tri");
        qs.add("styri");
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        qs.add("pat");
        qs.add("sest");
        qs.add("sedem");
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        qs.add("osem");
        System.out.println(qs.remove());
        System.out.println(qs.remove());

        Queue<Integer> qi = new Queue<>(3); // za ELEMENT mozeme dosadit len referencny typ, nemozeme pouzit primitivny typ (nemozeme pouzit Queue<int>)
        qi.add(1); // auto boxing - automaticke zabalenie 'int' do 'Integer'
        qi.add(2);
        qi.add(3);
        System.out.println(qi.remove());
        System.out.println(qi.remove());
        qi.add(4);
        qi.add(5);
        System.out.println(qi.remove());
        System.out.println(qi.remove());
        System.out.println(qi.remove());
    }
}
