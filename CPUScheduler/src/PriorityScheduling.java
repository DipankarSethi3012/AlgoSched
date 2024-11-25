import java.util.*;
public class PriorityScheduling {
    public void schedule(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        //higher priority will be served first
        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> b.priority - a.priority);
        int currentTime = 0;
        int index = 0;
        List<Process> ans = new ArrayList<>();
        while(index < processes.size() || !pq.isEmpty()) {

            while (index < processes.size() && processes.get(index).arrivalTime <= currentTime) {
                pq.offer(processes.get(index++));
            }

            if(!pq.isEmpty()) {
                Process process = pq.poll();

                process.completionTime = currentTime + process.burstTime;
                process.turnaroundTime = process.completionTime - process.arrivalTime;
                process.waitingTime = process.turnaroundTime - process.burstTime;

                currentTime = process.completionTime;
                ans.add(process);
            } else{
                if(index < processes.size()){
                    currentTime = processes.get(index).arrivalTime;
                }
            }
        }

        System.out.println("Using Priority Scheduling");
        for(Process p : ans) {
            System.out.println(p);
        }
        System.out.println();
    }
}
