import java.util.*;
public class RoundRobin {
    public void scheduler(List<Process> processes, int timeQuantum) {

        processes.sort(Comparator.comparingInt(p->p.arrivalTime));
        Queue<Process> q = new LinkedList<>();
        int currentTime = 0;
        int index = 0;

        List<Process> ans = new ArrayList<>();

        while (index < processes.size() || !q.isEmpty()) {
            while (index < processes.size() && processes.get(index).arrivalTime <= currentTime) {
                q.offer(processes.get(index++));
            }

            if(!q.isEmpty()) {
                Process p =q.poll();

                int executionTime = Math.min(p.burstTime, timeQuantum);
                currentTime += executionTime;
                p.burstTime -= timeQuantum;

                if(p.burstTime > 0) {
                    q.add(p);
                }  else{
                    p.completionTime = p.arrivalTime + currentTime;
                    p.turnaroundTime = p.completionTime - p.arrivalTime;
                    p.waitingTime = p.turnaroundTime - (p.burstTime + executionTime);
                    ans.add(p);
                }
            } else{
                if(index < processes.size()) {
                    currentTime = processes.get(index).arrivalTime;
                }
            }
        }


        System.out.println("Using Round Robin");

        for(Process p : ans) {
            System.out.println(p);
        }
        System.out.println();
    }
}
