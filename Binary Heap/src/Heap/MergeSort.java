package Heap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ICY on 3/25/2017.
 */
public class MergeSort {
    /*
    1. Divide the unsorted list into two sublists of about half the size
    2. Sort each of the two sublists
    3. Merge the two sorted sublists back into one sorted list

     */
    Heappy heap = new Heappy();
    public ArrayList<Integer> array = new ArrayList<Integer>();
    Integer[] a = new Integer[array.size()];

    public MergeSort(Heappy heap, ArrayList<Integer> array) {
        this.heap = heap;
        this.array = array;
        a = this.array.toArray(a);
    }

    public void ini() {
        for (Integer s : a)
            System.out.println(s);

    }

    public void merge_sort(int low, int high) {
        heap.time.start();
        int mid;
        //if there is only one element to sort. In this case the list is already sorted.
        if (low < high) {
            // Split the set
            mid = (low + high) / 2;
            //Solve First half
            merge_sort(low, mid);
            // Solve Second Half
            merge_sort(mid + 1, high);
            // Combine
            merge(low, mid, high);
        }
        heap.time.end();
        System.out.println(heap.time.execution + "Nano Sec");
        heap.com.setMergeSort(heap.time.execution);
    }

    public void merge(int low, int mid, int high) {
        int Leftindex, mainindex, Rightindex, k;
        int b[] = new int[50];
        Leftindex = low;
        mainindex = low;
        Rightindex = mid + 1;
        try {
            while ((Leftindex <= mid) && (Rightindex <= high)) {

                if (a[Leftindex] <= a[Rightindex]) {
                    b[mainindex] = a[Leftindex];
                    Leftindex++;
                } else {
                    b[mainindex] = a[Rightindex];
                    Rightindex++;
                }
                mainindex++;
            }

            // If one of splitted array is done you must fill rest of position with the rest
            //if Left array is full
            if (Leftindex > mid) {
                for (k = Rightindex; k <= high; k++) {
                    b[mainindex] = a[k];
                    mainindex++;
                }
            } else
            // If Right array is full
            {
                for (k = Leftindex; k <= mid; k++) {
                    b[mainindex] = a[k];
                    mainindex++;
                }
            }

            for (k = low; k <= high; k++)
                a[k] = b[k];
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public String printmerge(int num) {
        StringBuilder value = new StringBuilder();
        String last = "";
        for (int i = 0; i < num; i++) {
            value.append(a[i] + "  ");
            last = value.toString();

        }
        return last;
    }

}