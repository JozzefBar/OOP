
package tasks;

public class SimpleTask extends AbstractTask{
    public SimpleTask(String message, long runAtTick){
        super(message, runAtTick);
    }

    @Override
    public void run() {
        System.out.println("Task " + getId() + ": " + message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleTask rightOne = (SimpleTask) obj;
        return this.getId().equals(rightOne.getId());
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
