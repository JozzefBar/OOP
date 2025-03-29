package tasks;

public abstract class AbstractTask {
    private String id;
    protected String message;
    protected long runAtTick;

    public AbstractTask(String message, long runAtTick){
        assert message != null && !message.isEmpty() : "Správa nesmie byť null alebo prázdna!";
        assert runAtTick >= 0 : "Čas (runAtTick) nemôže byť záporný!";

        this.message = message;
        this.runAtTick = runAtTick;
        this.id = TaskIdGenerator.generateTaskId(this);
    }

    public long getRunAtTick() {
        return runAtTick;
    }

    public String getId(){
        return id;
    }

    public abstract void run();

    public abstract boolean isFinished();
}
