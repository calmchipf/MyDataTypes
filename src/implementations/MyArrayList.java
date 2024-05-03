package implementations;

import exceptions.EmptyArrayException;
import interfaces.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    int capacity = 10;
    private T[] elements;

    public MyArrayList() {
        elements = (T[]) new Object[capacity];
    }
    @Override
    public void add(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        elements[size++] = item;
    }

    private void increaseBuffer(){
        capacity = 2 * capacity;
        T[] new_elements = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            new_elements[i] = elements[i];
        }
        elements = new_elements;
    }

    @Override
    public void add(int index, T item) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size + 1 == capacity) {
            increaseBuffer();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = item;
        size++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        elements[index] = item;
    }

    @Override
    public void addFirst(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    @Override
    public T getFirst() throws EmptyArrayException{
        if (size == 0) {
            throw new EmptyArrayException("Array is empty, cannot retrieve the first element.");
        }

        return elements[0];
    }

    @Override
    public T getLast() throws EmptyArrayException{
        if (size == 0) {
            throw new EmptyArrayException("Array is empty, cannot retrieve the last element.");
        }

        return elements[size - 1];
    }

    public void swap(int index1, int index2) throws Exception {
        if (index1 < 0 || index1 >= size) throw new IndexOutOfBoundsException("Index: " + index1 + ", Size: " + size);
        if (index2 < 0 || index2 >= size) throw new IndexOutOfBoundsException("Index: " + index2 + ", Size: " + size);
        if (size == 0) throw new EmptyArrayException("Array is empty, cannot swap elements in empty array.");
        if (size == 1) throw new Exception("Array contains only one element, cannot swap the element with itself.");
        T temp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = temp;
    }

    @Override
    public void remove(int index) {
        if (size == 0) {
            throw new EmptyArrayException("Array is empty, cannot remove the element.");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        for (int i = index; i < size - 1;) {
            elements[i] = elements[++i];
        }

        size--;
    }

    public T retrieve(int index) {
        if (size == 0) {
            throw new EmptyArrayException("Array is empty, cannot remove the element.");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T temp = elements[index];

        for (int i = index; i < size - 1;) {
            elements[i] = elements[++i];
        }

        size--;

        return temp;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(T object) {
        return 0;
    }

    @Override
    public int lastIndexOf(T object) {
        return 0;
    }

    @Override
    public boolean exists(T object) {
        return false;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    public String toString() {
        String string = "[";
        for (int i = 0; i < size; i++) {
            string += elements[i];
            string += " ";
        }
        string = string.substring(0,string.length() - 1) + "]";
        return string;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
