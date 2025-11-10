package timingtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> n = new AList<>();
        n.addLast(1000);
        n.addLast(2000);
        n.addLast(4000);
        n.addLast(8000);
        n.addLast(16000);
        n.addLast(32000);
        n.addLast(64000);
        n.addLast(128000);
        AList<Double> time = new AList<>();
        int m = 1000;
        for (int i = 0; i < n.size(); i++) {
            int item = n.get(i);
            SLList<Integer> lst = new SLList<>();
            for (int index = 1; index <= item; index++) {/*创建一个从1到N的list*/
                lst.addLast(index);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 1; j <= m; j++) {
                lst.getLast();
            }
            double eachtime = sw.elapsedTime();
            time.addLast(eachtime);
        }
        AList<Integer> calltimes = new AList<>();
        for (int j = 1; j <= n.size(); j++) {
            calltimes.addLast(m);
        }
        printTimingTable(n, time, n);
    }
}
