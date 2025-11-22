package deque;

import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayDequeTest {
    @Test
    public void  ArrayisEmptySizeTest(){
        ArrayDeque<String> al1 = new ArrayDeque<>();

        assertTrue("A newly initialized arraylist should be empty",al1.isEmpty() );
    }




}
