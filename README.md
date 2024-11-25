# CPU Scheduling Algorithms in Java

This project demonstrates various CPU scheduling algorithms implemented in Java. It serves as an educational resource for understanding how different scheduling strategies work in operating systems.

## Features

The project includes implementations of the following CPU scheduling algorithms:

1. **First-Come, First-Served (FCFS)**  
   Non-preemptive scheduling algorithm where processes are executed in the order they arrive.

2. **Shortest Job Next (SJN)**  
   Non-preemptive scheduling algorithm that selects the process with the smallest execution time.

3. **Priority Scheduling**  
   Both preemptive and non-preemptive versions, where processes are scheduled based on priority.

4. **Round Robin (RR)**  
   Preemptive scheduling algorithm that assigns a fixed time quantum to each process.

5. **Multilevel Queue Scheduling**  
   Scheduling where processes are divided into categories, each handled by different queues with specific rules.

6. **Multilevel Feedback Queue Scheduling**  
   Advanced scheduling with dynamic priority adjustment.

## Getting Started

### Prerequisites

Ensure you have the following installed:
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) 8 or higher
- An IDE like [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/ide/)

### Installation

1. Clone this repository:
  https://github.com/DipankarSethi3012/CPU_Scheduling.git
2. Open the project in your preferred Java IDE.
3. Build and run the project

# How to Use
**Select the scheduling algorithm you want to simulate**.
Provide input parameters, such as:
  1.Process IDs
  2.Arrival times
  3.Burst times
  4.Priorities (if applicable)
  5.Time quantum (for Round Robin)
  
**View the output, including:**
Gantt Chart
Average waiting time
Average turnaround time
# Example Input
Number of processes: 4
Process IDs: P1, P2, P3, P4
Arrival Times: 0, 1, 2, 3
Burst Times: 6, 8, 7, 3
Priorities: 2, 1, 3, 4
Time Quantum: 4 (for RR)

# Example Output
**FCFS Scheduling:**
Gantt Chart: | P1 | P2 | P3 | P4 |
Average Waiting Time: 5.5 ms
Average Turnaround Time: 11.0 ms

**Round Robin Scheduling:**
Gantt Chart: | P1 | P2 | P3 | P4 | P1 | P3 | ...
Average Waiting Time: 7.75 ms
Average Turnaround Time: 12.25 ms

**Contributing**
Contributions are welcome! Please follow these steps:

Fork the repository.
1.Create a feature branch
git checkout -b feature-name

2.Commit your changes
git commit -m "Add your message here"

3.Push to the branch:
git push origin feature-name

4.Submit a pull request.

**Acknowledgments**
Inspired by concepts from Operating Systems courses.
Thanks to the contributors of open-source Java resources.

