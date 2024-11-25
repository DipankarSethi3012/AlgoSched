public class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int priority;
    int completionTime;
    int waitingTime;
    int turnaroundTime;

    public Process(int processId, int arrivalTime, int burstTime, int priority) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId +
                ", arrivalTime=" + arrivalTime +
                ", burstTime=" + burstTime +
                ", priority=" + priority +
                ", completionTime=" + completionTime +
                ", waitingTime=" + waitingTime +
                ", turnaroundTime=" + turnaroundTime +
                '}';
    }
}
