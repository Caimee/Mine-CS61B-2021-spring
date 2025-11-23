package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>  {
    private Comparator<T> method;

    public MaxArrayDeque(Comparator<T> t) {
        super();
        this.method = t;
    }

    public T max() {
        return max(method);
    }

    public T max(Comparator<T> c) {
        T maxitem = this.get(0);
        for (int i = 0; i < size(); i++) {
            if (c.compare(this.get(i), maxitem) > 0) {
                maxitem = this.get(i);
            }
        }
        return maxitem;

    }


}
