import java.util.*;

class Process {
    String pid;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int completionTime;

    Process(String pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        ArrayList<Process> processes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID: ");
            String pid = sc.next();
            System.out.print("Enter Arrival Time of " + pid + ": ");
            int at = sc.nextInt();
            System.out.print("Enter Burst Time of " + pid + ": ");
            int bt = sc.nextInt();

            processes.add(new Process(pid, at, bt));
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        Queue<Process> queue = new LinkedList<>();
        ArrayList<String> ganttChart = new ArrayList<>();

        int time = 0, completed = 0;
        Set<Process> added = new HashSet<>();

        while (completed < n) {
            // Add new processes to the queue
            for (Process p : processes) {
                if (p.arrivalTime <= time && p.remainingTime > 0 && !added.contains(p)) {
                    queue.add(p);
                    added.add(p);
                }
            }

            if (queue.isEmpty()) {
                time++;
                continue;
            }

            Process current = queue.poll();
            ganttChart.add(current.pid);

            int execTime = Math.min(quantum, current.remainingTime);
            time += execTime;
            current.remainingTime -= execTime;

            // Check again for newly arrived processes during execution
            for (Process p : processes) {
                if (p.arrivalTime <= time && p.remainingTime > 0 && !added.contains(p)) {
                    queue.add(p);
                    added.add(p);
                }
            }

            if (current.remainingTime > 0) {
                queue.add(current); // Add back to queue
            } else {
                current.completionTime = time;
                completed++;
            }
        }

        System.out.println("\nGantt Chart:");
        for (String id : ganttChart) {
            System.out.print(" | " + id);
        }
        System.out.println(" |");

        double totalTAT = 0, totalWT = 0;
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for (Process p : processes) {
            int tat = p.completionTime - p.arrivalTime;
            int wt = tat - p.burstTime;
            totalTAT += tat;
            totalWT += wt;

            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\n", p.pid, p.arrivalTime, p.burstTime, p.completionTime, tat, wt);
        }

        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTAT / n);
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / n);
    }
}
/*
input
 Enter number of processes: 3
Enter Process ID: P1
Enter Arrival Time of P1: 0
Enter Burst Time of P1: 5
Enter Process ID: P2
Enter Arrival Time of P2: 1
Enter Burst Time of P2: 4
Enter Process ID: P3
Enter Arrival Time of P3: 2
Enter Burst Time of P3: 2
Enter Time Quantum: 2

 */