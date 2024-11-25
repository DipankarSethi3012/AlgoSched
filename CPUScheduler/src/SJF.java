import java.util.*;
public class SJF {
    public void schedule(List<Process> processes) {
        System.out.println();
        System.out.println("Using Shortest Job First ");
//        System.out.println();

        List<Process> ans = new ArrayList<>();
        processes.sort(Comparator.comparingInt(p->p.arrivalTime));

        PriorityQueue<Process> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.burstTime));
        int currentTime = 0 ;
        int index = 0;

        while (index < processes.size() || !pq.isEmpty()) {

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
                if(index < processes.size()) {
                    currentTime = processes.get(index).arrivalTime;
                }
            }
        }



        for(Process p : ans) {
            System.out.println(p);
        }
        System.out.println();
    }
}
