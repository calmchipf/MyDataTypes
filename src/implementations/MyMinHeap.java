package implementations;

import exceptions.EmptyArrayException;
import interfaces.MyHeap;

public class MyMinHeap<T extends Comparable<T>> implements MyHeap<T> {
    private MyArrayList<T> array = new MyArrayList<>();


    @Override
    public boolean empty() {
        return (array.size() == 0);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public T getRoot() throws EmptyArrayException{
        if(empty()) throw new EmptyArrayException("Array is empty, cannot retrieve the first element.");
        return array.getFirst();
    }

    @Override
    public T extractRoot() {
        if(empty()) throw new EmptyArrayException("Array is empty, cannot retrieve the first element.");
        return array.retrieve(0);
    }

    @Override
    public void insert(T item) {
        array.add(item);
        try {
            heapifyUp(array.size() - 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getParentIndex(int childIndex) { return (childIndex) / 2; }

    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private void heapify(MyArrayList<T> array, int index) throws Exception {
        int smallest = index;
        int left = leftChildOf(smallest);
        int right = rightChildOf(smallest);
        int length = array.size();
        if ((left < length) && (array.get(left).compareTo(array.get(smallest)) < 0)) smallest = left;
        if ((right < length) && (array.get(right).compareTo(array.get(smallest)) < 0)) smallest = right;
        if (smallest != index) {
            swap(smallest, index);
            heapify(array, smallest);
        }
    }

    private void heapifyUp(int index) throws Exception {
        traverseUp(size() - 1);
    }


    private void traverseUp(int index) throws Exception {
        if (!hasParent(index)) return;

        while (hasParent(index) && array.get(getParentIndex(index)).compareTo(array.get(index)) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }


    private int leftChildOf(int index) throws Exception {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        int left_child = index * 2;
        if (left_child >= size()) throw new Exception("No child found.");
        return left_child;
    }


    private int rightChildOf(int index) throws Exception{
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        int right_child = index * 2 + 1;
        if (right_child >= size()) throw new Exception("No child found.");
        return right_child;
    }

    private void swap(int index1, int index2) throws Exception {
        array.swap(index1, index2);
    }

    public String toString(){
        return array.toString();
    }
}
