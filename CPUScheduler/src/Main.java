import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Process> processList = new ArrayList<>();
        processList.add(new Process(2, 3, 4, 1));
        processList.add(new Process(1, 4, 4, 3));
        processList.add(new Process(3, 2, 5, 6));
        processList.add(new Process(4,1,2,3));

        FCFS fcfs = new FCFS();
        fcfs.schedule(processList);

       SJF sjf = new SJF();
       sjf.schedule(processList);

        PriorityScheduling priorityScheduling = new PriorityScheduling();
        priorityScheduling.schedule(processList);

        RoundRobin roundRobin = new RoundRobin();
        roundRobin.scheduler(processList, 2);

        MultiLevelQueue multiLevelQueue = new MultiLevelQueue(6);
        multiLevelQueue.schedule(processList);
    }
}