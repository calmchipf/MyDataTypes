import implementations.MyArrayList;
import implementations.MyMinHeap;

public class Main {
    public static void main(String[] args) {
        MyMinHeap<Integer> minHeap = new MyMinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(10);
        minHeap.insert(5);
        System.out.println(minHeap.toString());
    }
}