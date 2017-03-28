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
        quickSort(list,0,list.length-1);
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
    //how to make it generic? currently just assuming array is array of ints
    static int lastElementPivot(int list[], int n)
    {
        int pivot=list[n-1];
        return pivot;
    }

    static void  quickSort(int list[], int first,int last)
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
        int pivot= list[last];
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
            if(list[first]<list[last])
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
            if(list[front]<=pivot)
            {
                //if end index is larger than pivot we will swap it to be on the left side

                    switched=0;
                    while(end>front && switched==0)
                    {

                        if(list[end]>pivot)
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
            else if(list[front]>pivot)
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
    static void swap(int [] list,int first, int second)
    {
        int temp=list[first];
        list[first]=list[second];
        list[second]=temp;
        return;

    }
        //puts pivot in its right place and returns its index
        static int insertPivot(int list[],int pivotIndex,int front)
        {
            //front will be now pointing at last element in the left array or 1st in right array
            if(list[front]>=list[pivotIndex])
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
}
