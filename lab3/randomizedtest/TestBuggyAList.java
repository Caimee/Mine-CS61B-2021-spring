package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
@Test
    public void addandremovetest(){
    AList<Integer> arr = new AList<>();
    arr.addLast(15);
    arr.addLast(5);
    arr.addLast(10);
    BuggyAList<Integer> barr = new BuggyAList<>();
    barr.addLast(15);
    barr.addLast(5);
    barr.addLast(10);
assertEquals(arr.size(),barr.size());
    assertEquals(arr.removeLast(),barr.removeLast());
    assertEquals(arr.removeLast(),barr.removeLast());
    assertEquals(arr.removeLast(),barr.removeLast());
}
@Test
    public void randomnizedtest(){
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> J = new BuggyAList<>();
    int N = 5000;
    for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        if (operationNumber == 0) {
            // addLast
            int randVal = StdRandom.uniform(0, 100);
            L.addLast(randVal);
            J.addLast(randVal);
            System.out.println("addLast(" + randVal + ")");

        } else if (operationNumber == 1) {
            // size
            int size = L.size();
            System.out.println("size: " + size);
            assertEquals(L.size(),J.size());

        } else if (operationNumber == 2) {
            if(L.size() <= 0 || J.size() <= 0){
                continue;
            }
            L.getLast();
            assertEquals(L.getLast(), J.getLast());
            System.out.println("getlast");

        }
        else if (operationNumber == 3){
            if(L.size() <= 0 || J.size() <= 0){
                continue;
            }
            System.out.println("removelast");
            assertEquals(L.removeLast(),J.removeLast());
        }
    }



}

}
