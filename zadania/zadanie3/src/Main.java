import handler.TaskHandler;
import tasks.RecurringTask;
import tasks.SimpleTask;
import tasks.AbstractTask;

public class Main {
    public static void main(String[] args) {
        /*
        SimpleTask t1 = new SimpleTask("uvariť obed", 2);
        SimpleTask t2 = new SimpleTask("nakúpiť potraviny", 1);
        RecurringTask t3 = new RecurringTask("umyť si zuby", 1, 2, 0);
        TaskHandler taskHandler = new TaskHandler();
        taskHandler.addTask(t1);
        taskHandler.addTask(t2);
        taskHandler.addTask(t3);
        taskHandler.tickLoop(6);
        */

        /*
        AbstractTask t1 = new SimpleTask("Kúpiť xantánovú gumu.", 10);
        AbstractTask t2 = t1; // t2 je nova referencia, ale ukazuje na ten istý objekt
        AbstractTask t3 = new SimpleTask("Kúpiť xantánovú gumu.", 10);
        AbstractTask t4 = new RecurringTask("Kúpiť topánky pre shi-tzu.", 15, 5, null);
        System.out.println(t1.equals(t1)); // true, lebo t1 == t1
        System.out.println(t1.equals(t2)); // true, true, lebo t2 je referencia na t2, čiže t1 == t2
        System.out.println(t1.equals(t3)); // false, lebo t1 a t3 majú rovnaké atribúty, ale majú iné id. Ak by sme v SimpleTask nemali generovanie id a id by sme nastavili rovnako pre t1 a t3, tak by sme očakávali true.
        System.out.println(t1.equals(t4)); // false, lebo t1 a t4 sú odlišné dátové typy
         */

        AbstractTask t1 = new SimpleTask("Kúpiť xantánovú gumu.", 5);
        TaskHandler taskHandler = new TaskHandler();
        taskHandler.addTask(t1);
        taskHandler.addTask(t1);
        taskHandler.tickLoop(6);
    }
}