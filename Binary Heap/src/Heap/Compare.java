package Heap;

/**
 * Created by ICY on 3/27/2017.
 */
public class Compare {
    private long Quicksort;

    public long getQuicksort() {
        return Quicksort;
    }

    public long getMergeSort() {
        return mergeSort;
    }

    public long getSelection() {
        return selection;
    }

    public long getHeapSort() {
        return heapSort;
    }

    private long mergeSort;
    private long selection;
    private long heapSort;

    public void setQuicksort(long quicksort) {
        Quicksort = quicksort;
    }

    public void setMergeSort(long mergeSort) {
        this.mergeSort = mergeSort;
    }

    public void setSelection(long selection) {
        this.selection = selection;
    }

    public void setHeapSort(long heapSort) {
        this.heapSort = heapSort;
    }

    public void Kimoelshba7() {

        System.out.println("MergeSort: " + mergeSort + " QuickSort " + Quicksort);
        System.out.println("HeapSort: " + heapSort + " Selection " + selection);


    }
}

