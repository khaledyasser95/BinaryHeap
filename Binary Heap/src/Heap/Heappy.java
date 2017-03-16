package Heap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ICY on 3/15/2017.
 */

public class Heappy   {
    Representation rep = new Representation();
    ArrayList<Integer> Tree= new ArrayList<Integer>() ;
    int test=0;

    public Heappy() {
        rep.setSize(0);
        Tree.clear();
    }


    public static void main(String[] args) {

        Heappy heap = new Heappy();
        heap.create();

    }
    public void create(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        System.out.println("Enter size of Binary heap");
        /** Make object of BinaryHeap **/

        char ch;
        /**  Perform Binary Heap operations  **/
        do {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check empty");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter integer element to insert");
                        insert(scan.nextInt());
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
        int last = minChild();
        Tree.set(0, Tree.get(Tree.size() - 1));
      //  System.out.println( "\n hey" +last_index);
        Tree.remove(Tree.get(Tree.size()-1));
        rep.Sizedec();
        bubbleDown();
        return last;
    }
    private int minChild()
    {
        return  Tree.get(0);
    }
    private void insert(int value)
    {
        test++;
        rep.Sizeinc();
        int index = rep.getSize()-1;
        Tree.add(index,value);
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

        while (rep.hasParent(index) && (parent(index) < Tree.get(index)) ) {
            // parent/child are out of order; swap them
            System.out.print(" hi "+parent(index)+"");
            swap(index, rep.parentIndex(index));
            index = rep.parentIndex(index);
        }
        System.out.print(" l "+parent(index)+"");

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
}


