package Heap;


import java.util.ArrayList;

/**
 * Created by ICY on 3/15/2017.
 */
public class Representation {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void Sizeinc() {
        size++;
    }

    public void Sizedec() {
        size--;
    }
    //why?
    ArrayList T= new ArrayList() ;

    public boolean hasParent(int i) {
        return i >= 0;
    }


    public int leftIndex(int i) {
        return i * 2 + 1;
    }


    public int rightIndex(int i) {
        return i * 2 + 2;
    }


    public boolean hasLeftChild(int i) {
        return leftIndex(i) < size;
    }


    public boolean hasRightChild(int i) {
        return rightIndex(i) < size;
    }



    public int parentIndex(int i) {
        //didn't handle zero case ?
        return (int) Math.floor(((i - 1) / 2));
       // return Integer.MIN_VALUE;
    }



}
