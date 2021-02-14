package com.fresnostate;
import java.util.*;
public class Main{

    public List<Integer> inputList()
    {
        List<Integer> x = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        x.add(Integer.MAX_VALUE);
        System.out.println("Enter numbers in a list");
        while(sc.hasNextInt())
        {
            int n = sc.nextInt();
            x.add(n);
        }
        return x;
    }
    protected void printIt(List<Integer> x )
    {
        for(int i=1;i<x.size();i++){
            System.out.print(x.get(i)+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Main m = new Main();
        List<Integer> x = m.inputList();
        System.out.println("The list is:-");
        m.printIt(x);
        MaxHeap mh = new MaxHeap(x);
        mh.BuildMaxHeap();
        System.out.println("After BuildMaxHeap");
        mh.printList();
        mh.HeapSort();
        System.out.println("After HeapSort");
        mh.printList();
        System.out.println("Max is " +mh.extractMax() + "\nAfter extractMax is ");
        mh.printList();
    }
}
