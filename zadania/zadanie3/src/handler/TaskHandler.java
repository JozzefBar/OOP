
package handler;

import tasks.AbstractTask;

public class TaskHandler {
    private static final int MAXIMUM_TASKS = 5;
    private AbstractTask[] tasks;
    private int taskIndex;

    public TaskHandler() {
        tasks = new AbstractTask[MAXIMUM_TASKS];
        taskIndex = 0;
    }

    public AbstractTask[] getTasks() {
        return tasks;
    }

    public int getTaskIndex(){
        return taskIndex;
    }

    public void addTask(AbstractTask task){
        if (taskIndex < MAXIMUM_TASKS) {
            tasks[taskIndex] = task;
            taskIndex++;
        }
    }

    public void removeTask(AbstractTask task){
        for(int i = 0; i < taskIndex; i++){
            if (task.equals(tasks[i])){
                for(int j = i; j < taskIndex - 1; j++){
                    tasks[j] = tasks[j + 1];
                }
                tasks[taskIndex - 1] = null;
                taskIndex--;
                break;
            }
        }
    }

    public void tickLoop(long durationInNumberOfTicks){
        for(long i = 0; i < durationInNumberOfTicks; i++){
            System.out.println("Current tick: " + i);
            for (int j = 0; j < taskIndex; j++) {
                if (tasks[j] != null && tasks[j].getRunAtTick() == i) {
                    tasks[j].run();

                    if (tasks[j].isFinished()) {
                        removeTask(tasks[j]);
                        j--;
                    }

                }
            }
            System.out.println("===");
        }
    }
}
