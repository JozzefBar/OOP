import handler.TaskHandler;
import tasks.RecurringTask;
import tasks.SimpleTask;

public class Main {
    public static void main(String[] args) {
        SimpleTask t1 = new SimpleTask("uvariť obed", 2);
        SimpleTask t2 = new SimpleTask("nakúpiť potraviny", 1);
        RecurringTask t3 = new RecurringTask("umyť si zuby", 1, 2, 5);
        TaskHandler taskHandler = new TaskHandler();
        taskHandler.addTask(t1);
        taskHandler.addTask(t2);
        taskHandler.addTask(t3);
        System.out.println(t1.getId());
        taskHandler.tickLoop(10);
    }
}