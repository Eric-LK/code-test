package collection.my;

import java.util.Arrays;

/**
 * @author lb
 */
public class MyArrayList<T> {
    public static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] elements;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        //this.elements = new T[];
    }

    /**
     * 在数组末尾添加元素
     *
     * @param element 元素
     */
    public void add(T element) {
        elements[size++] = element;
    }

    /**
     * 数组添加
     *
     * @param index   下表
     * @param element 添加的元素
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        /*for(int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }*/
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * 删除具体某一个下标的元素
     *
     * @param index 下表
     * @return 之前此下标的值
     */
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = elements[index];
        for (int i = index; index < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 数组清除
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }

    /**
     * 数组扩容
     */
    @SuppressWarnings("unchecked")
    public void ensureCapacity() {
        if (size < elements.length) {
            return;
        }
        int newCapacity = elements.length + (elements.length >> 1);
        T[] newElements = (T[]) new Object[newCapacity];

        /*for(int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }*/
        System.arraycopy(elements, 0, newElements, 0, size);

        elements = newElements;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(2, 123);

        System.out.println(myArrayList);

    }
}
