package Heap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ICY on 3/15/2017.
 */

public class Heappy   {
    Timer time = new Timer();
    Compare com = new Compare();
    Representation rep = new Representation();
    public String sorttext = new String();
    public String swappy = new String();

    private ArrayList<Integer> Tree = new ArrayList<Integer>();

    //  int test=0;
    int x=0;

    public ArrayList<Integer> getTree() {
        return Tree;
    }

    public void setTree(ArrayList<Integer> tree) {
        Tree = tree;
    }

    public Heappy() {
        rep.setSize(0);
        Tree.clear();
    }

    void merge() {

        MergeSort merge = new MergeSort(this, Tree);
        merge.ini();
        merge.merge_sort(0, rep.getSize() - 1);
        sorttext = merge.printmerge(rep.getSize());
        swappy = "Tree is sorted ";

    }

    public static void main(String[] args) {

        Heappy heap = new Heappy();
        heap.create();


    }


    public void create(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        //System.out.println("Enter size of Binary heap");
        //we didn' take the size? then why print it
        /** Make object of BinaryHeap **/

        char ch;
        /**  Perform Binary Heap operations  **/
        do {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check empty");
            System.out.println("4. GUI");
            System.out.println("5. heap sort");
            System.out.println("6. selection sort");
            System.out.println("7. quick sort");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:

                    try {
                        //size of insertion
                        System.out.println("Enter Size");
                        int size = scan.nextInt();
                        System.out.println("Enter integer element to insert");


                        while (x != size) {
                            insert(scan.nextInt());
                            x++;
                        }



                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Min Element : " + remove());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Empty status = " + isEmpty());
                    break;
                case 4:
                    Heap_Gui gui = new Heap_Gui();
                    gui.setVisible(true);
                    break;
                case 5:
                    heapSort();
                    break;
                case 6:
                    selectionSort();
                    break;
                case 7:
                    time.start();
                    quickSort(Tree,0,rep.getSize()-1);
                    time.end();
                    System.out.println("quickSort took " + time.execution + " Nano Sec");
                    com.setQuicksort(time.execution);
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /** Display heap **/
            printHeap();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');


    }
    public int remove() {
        // what do want return?

        try {
            int last = minChild();
            Tree.remove(0);
            rep.Sizedec();
            System.out.println(rep.getSize());
            bubbleDown();
            return last;


        } catch (Exception e) {
            System.out.println("Remove Error: " + e.getMessage());

        }

        return -1;

    }
    private int minChild()
    {
        return  Tree.get(0);
    }

    public void insert(int value)
    {
        // test++;
        rep.Sizeinc();
        int index = rep.getSize()-1;
        Tree.add(index,value);
        swappy = value + " is added ";
        bubbleUp();

    }

    public boolean isEmpty() {
        return rep.getSize() < 0;
    }
    protected void bubbleDown() {
        int index = 0;

        // bubble down
        while (rep.hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = rep.leftIndex(index);

            // bubble with the smaller child, if I have a smaller child
            if (rep.hasRightChild(index) && Tree.get(rep.leftIndex(index))<(Tree.get(rep.rightIndex(index))))  {

                smallerChild = rep.rightIndex(index);
            }

            if (Tree.get(index)< Tree.get(smallerChild)) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }

            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }
    }

    public void bubbleUp() {
        // When adding value to last node we must bubble up to rearrange
        int index = rep.getSize()-1;

        while ((parent(index) < Tree.get(index))) {

            swap(index, rep.parentIndex(index));
            swappy = "Swapped " + Tree.get(index) + " with" + Tree.get(rep.parentIndex(index));
            index = rep.parentIndex(index);
        }


    }
    public int parent(int i) {
        //Get Parent of the node am standing On
        return Tree.get(rep.parentIndex(i));
    }

    public void swap(int index1, int index2) {
        int tmp = Tree.get(index1);
        Tree.set(index1,Tree.get(index2));
        Tree.set(index2,tmp);
    }
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < rep.getSize(); i++)
            System.out.print(Tree.get(i) +" ");
        System.out.println();
    }

    //one pass of heap sort: puts max element into its place
    void heapSortMax()
    {
        time.start();
        for(int i=0;i<Tree.size()-1;i++)
        {
            try {

                int lastArrayElementIndex=Tree.size() - 1-i;
                swap(0,lastArrayElementIndex);
                rep.Sizedec();
                bubbleDown();



            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
        for(int i=0;i<Tree.size()-1;i++)
        {
            rep.Sizeinc();
        }

        time.end();
        System.out.println("Heap Sort took" + time.execution + "Nano Sec");
        com.setHeapSort(time.execution);
    }

    public void heapSort()
    {

        heapSortMax();

    }

    public void selectionSort()
    {
        time.start();
        int listSize=Tree.size();
        int min;

        //each pass of this loop swaps the J th element with the min element in the array
        for(int j=0;j<listSize;j++)
        {
            min=j;
            //output of this loos is min=index of min element in the array
            for(int i=j+1;i<listSize;i++)
            {
                if(Tree.get(min)>Tree.get(i))
                {
                    min=i;
                }
            }
            swap(j,min);

        }


        time.end();
        System.out.println("selectionSort took " + time.execution + " Nano Sec");
        com.setSelection(time.execution);
    }



    public void  quickSort(ArrayList<Integer> list, int first, int last)
    {


       /* if(n==0)
        {
            System.out.print("zero");
        }*/
        //if any other method used for generating pivot it should be swapped with last element in array after choosing it
        //for algorithm to work
        //if(n==1) return ;
        int n=last-first+1;
        if(n==0||n==1)
        {
            return;
        }
        int pivot= list.get(last);
        int front=first;
        //because pivot is in n-1
        int end=last-1;
        int switched=0;
        if(end<0)
        {
            return;
        }
        if(n==2)
        {
            if(list.get(first) < list.get(last))
            {
                swap(list,front,last);
                return;
            }
            else
            {
                return;
            }

        }
        while(front<end)
        {
            //if front index <= pivot we will swap it to be on it right side
            if(list.get(front) <=pivot)
            {
                //if end index is larger than pivot we will swap it to be on the left side

                switched=0;
                while(end>front && switched==0)
                {

                    if(list.get(end) >pivot)
                    {
                        swap(list,front,end);
                        front++;
                        end--;
                        switched=1;
                    }
                    else
                    {
                        end--;
                    }


                }

            }
            else if(list.get(front) >pivot)
            {
                front++;
            }


        }
        //L: equal case
        int pivotIndex=last;
        pivotIndex=insertPivot(list,pivotIndex,front);

        if(n>1)
        {
           /* System.out.println(pivotIndex-1);
            System.out.println(n-pivotIndex+1);
            */
            quickSort(list,first,pivotIndex-1);
            quickSort(list,pivotIndex+1,last);

        }


    }
    //didn't work java call by value
    /*
    static void swap(int first, int second)
        {
            int temp=first;
            first=second;
            second=temp;
            return;

        }
        */
    static void swap(ArrayList<Integer> list, int first, int second)
    {
        int temp= list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
        return;

    }
    //puts pivot in its right place and returns its index
    static int insertPivot(ArrayList<Integer> list, int pivotIndex, int front)
    {
        //front will be now pointing at last element in the left array or 1st in right array
        if(list.get(front) >= list.get(pivotIndex))
        {
            //swap pivot with the next element to front
            swap(list,pivotIndex,front+1);
            return front+1;
        }

        else
        {
            swap(list,pivotIndex,front);
            return front;
        }

    }

    public void Quicksort() {
        time.start();
        quickSort(Tree, 0, rep.getSize() - 1);
        time.end();
        System.out.println("quickSort took " + time.execution + " Nano Sec");
        com.setQuicksort(time.execution);
    }

}//end heappy


