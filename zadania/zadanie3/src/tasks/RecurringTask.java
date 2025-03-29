package tasks;


public class RecurringTask extends AbstractTask {
    private long delayBetweenRuns;
    private Integer numberOfRuns;

    public RecurringTask(String message, long runAtTick, long delayBetweenRuns, Integer numberOfRuns){
        super(message, runAtTick);
        assert numberOfRuns > 0 || numberOfRuns == null : "numberOfRuns musí byť kladné alebo null!";
        assert delayBetweenRuns > 0 : "delayBetweenRuns musí byť kladné!";

        this.delayBetweenRuns = delayBetweenRuns;
        this.numberOfRuns = numberOfRuns;
    }

    public Integer getNumberOfRuns() {
        return numberOfRuns;
    }

    public long getDelayBetweenRuns(){
        return delayBetweenRuns;
    }

    @Override
    public void run() {
        if(numberOfRuns == null){
            System.out.println("Task {" + getId() + "}: " + message);
        }
        else if(numberOfRuns > 0){
            numberOfRuns--;
            System.out.println("Task " + getId() + ": " + message);
        }
        runAtTick += delayBetweenRuns;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RecurringTask rightOne = (RecurringTask) obj;
        return this.getId().equals(rightOne.getId());
    }

    @Override
    public boolean isFinished() {
        return numberOfRuns == 0;  // Skončí, keď už nemá žiadne ďalšie opakovania
    }
}
