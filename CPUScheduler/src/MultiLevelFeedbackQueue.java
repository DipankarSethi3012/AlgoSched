import java.util.*;

public class MultiLevelFeedbackQueue {
    private final List<Queue<Process>> queueList;
    private int[] timeQuanta;

   public MultiLevelFeedbackQueue(int[] timeQuanta, int levels){
        queueList = new ArrayList<>();
        this.timeQuanta = timeQuanta;

        for(int i = 0; i < levels; i++) {
            queueList.add(new LinkedList<>());
        }
   }

    public void schedule(List<Process> processes) {
       processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
       List<Process> ans = new ArrayList<>();

       int currentTime = 0, index = 0;

       while (index < processes.size() || queueList.stream().anyMatch(q -> !q.isEmpty())) {
           while (index < processes.size() && processes.get(index).arrivalTime <= currentTime) {
               queueList.get(0).add(processes.get(index++));
           }

           boolean processExecuted = false;

           for(int i = 0; i < queueList.size(); i++) {
               Queue<Process> queue = queueList.get(i);

               if(!queue.isEmpty()) {
                   Process process = queue.poll();
                   int executionTime = Math.min(process.burstTime, timeQuanta[i]);

                   currentTime += executionTime;
                   process.burstTime -= executionTime;

                   if(process.burstTime > 0) {
                       if(i + 1 < queueList.size()) {
                           queueList.get(i + 1).add(process);
                       } else{
                           queue.add(process);
                       }
                   } else{
                       process.completionTime = currentTime;
                       process.turnaroundTime = process.completionTime - process.arrivalTime;
                       process.waitingTime = process.turnaroundTime - process.burstTime;

                       ans.add(process);
                   }

                   processExecuted = true;
                   break;
               }
           }

           if(!processExecuted) {
               currentTime++;
           }

       }

        System.out.println("USing MultiLevelFeedback Queue");
       for(Process process : ans) {
           System.out.println(process);
       }
        System.out.println();

    }


}
