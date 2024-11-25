import java.util.*;
public class MultiLevelQueue {
    //list of queues for different priority levels
    private final List<Queue<Process>> queues;

    public MultiLevelQueue(int levels) {
        queues = new ArrayList<>();
        for (int i = 0; i < levels; i++) {
            queues.add(new LinkedList<>());
        }
    }

    public void schedule(List<Process> processes){

        List<Process> ans = new ArrayList<>();
        //assign process to queue based on their priority
        for(Process process : processes) {
            queues.get(process.priority - 1).add(process);
        }

        int currentTime = 0;
        for(int i = 0; i < queues.size(); i++) {
            Queue<Process> q = queues.get(i);

            while (!q.isEmpty()) {
                Process process = q.poll();


                if(currentTime < process.arrivalTime) {
                    currentTime = process.arrivalTime;
                }

                process.completionTime = currentTime + process.burstTime;
                process.turnaroundTime = process.completionTime - process.arrivalTime;
                process.waitingTime = process.turnaroundTime - process.burstTime;

                currentTime = process.completionTime;
                ans.add(process);
            }
        }

        System.out.println("Using MultiLevelQueue");

        for(Process p : ans) {
            System.out.println(p);
        }

        System.out.println();
    }
}
