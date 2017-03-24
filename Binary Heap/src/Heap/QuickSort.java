package Heap;
/* choosing pivot
1-can choose multiple elements and take their median
2-can choose element randomly
3-can choose last element of array

*/

//import java.util.Scanner;

/**
 * Created by Kareem on 24-Mar-17.
 */
//quick sort in descending order
public class QuickSort {

    public static void main(String args[])
    {
        int [] list={5,3,2,0,17,15,4,13};

        System.out.println("before sorting:");
        printArray(list,list.length);
        quickSort(list,list.length);
        System.out.println("after sorting:");
        printArray(list,list.length);

    }

    public static void printArray(int [] list,int n)
    {
        //new line
        System.out.println("");
        //print elements
        for(int i=0; i<n;i++)
        {
            System.out.print(list[i]+" ");
        }
        //new line
        System.out.println("");

    }

    /*
    int [] getList() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Enter Size");
            int size = scan.nextInt();
            int [size] mylist;
            System.out.println("Enter integer element to insert");
            while (x != size) {
                insert(scan.nextInt());
                x++;
                return mylist;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    */
    //how to make it generic? currently just assming array is array of ints
    static int lastElementPivot(int list[], int n)
    {
        int pivot=list[n-1];
        return pivot;
    }

    static void  quickSort(int list[], int n)
    {
        //if any other method used for generating pivot it should be swapped with last element in array after choosing it
        //for algorithm to work
        //if(n==1) return ;
        int pivot= lastElementPivot(list,n);
        int front=0;
        int end=n-1;
        int switched;

        while(front<end)
        {
            //if front index <= pivot we will swap it to be on it right side
            if(list[front]<=pivot)
            {
                //if end index is larger than pivot we will swap it to be on the left side
                if(list[end]>pivot)
                {
                    swap(list,front,end);
                    front++;
                    end--;

                }
                else
                {
                    switched=0;
                    while(end>front && switched==0)
                    {
                        end--;
                        if(list[end]>pivot)
                        {
                            swap(list,front,end);
                            front++;
                            end--;
                            switched=1;
                        }


                    }

                }

            }
            else if(list[front]>pivot)
            {
                front++;
            }


        }
        //L: equal case
        int pivotIndex;
        pivotIndex=insertPivot(list,n,front);

        if(n!=1)
        {
            quickSort(list,pivotIndex+1);
            quickSort(list,n-pivotIndex+1);
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
    static void swap(int [] list,int first, int second)
    {
        int temp=list[first];
        list[first]=list[second];
        list[second]=temp;
        return;

    }
        //puts pivot in its right place and returns its index
        static int insertPivot(int list[],int n,int front)
        {
            if(list[front]>=list[n-1])
            {
                swap(list,n-1,front+1);
                return front+1;
            }

            else
            {
                swap(list,n-1,front);
                return front;
            }

        }
}
