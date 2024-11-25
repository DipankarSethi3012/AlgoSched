import java.util.*;

public class FCFS {
    public void schedule(List<Process> processes) {
        //sorting processes based on arrival time
        System.out.println("Using First Come First Serve ");
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        List<Process> ans = new ArrayList<>();

        int currentTime = 0;
        for(Process process : processes) {
            if(currentTime < process.arrivalTime) {
                currentTime = process.arrivalTime;
            }

            process.completionTime = currentTime + process.burstTime;
            process.turnaroundTime = process.completionTime - process.arrivalTime;
            process.waitingTime = process.turnaroundTime - process.burstTime;

            currentTime = process.completionTime;
            ans.add(process);
        }

        for(Process p : ans) {
            System.out.println(p);
        }
    }
}
