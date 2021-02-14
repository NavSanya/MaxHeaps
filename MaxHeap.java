package com.fresnostate;
import java.util.*;
public class MaxHeap {
    List<Integer> heap;//max heap

    //parameterised constructor
    protected MaxHeap( List<Integer> x)
    {
        heap = x;
    }

    //Printing the List
    protected void printList()
    {
        for(int i=1;i<heap.size();i++){
            System.out.print(heap.get(i)+"\t");
        }
        System.out.println();
    }

    //swap first position to the second position
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = heap.get(fpos);
        heap.set(fpos, heap.get(spos));
        heap.set(spos,tmp);
    }

    //Left Child
    public int Left(int x)
    {
        return ((2*x));
    }

    //Right Child
    public int Right(int x)
    {
        return ((2*x)+1);
    }

    //Parent
    public int Parent(int x)
    {
        return (x/2);
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (heap.size() / 2) && pos <= heap.size()) {
            return true;
        }
        return false;
    }

    public void MaxHeapify(int i, int n)
    {
        int l = Left(i);
        int r = Right(i);
        if(isLeaf(i))
        {
            return;
        }
        int largest = i;
        if(l<=n && heap.get(l)>heap.get(largest))
            largest = l;
        if(r<=n && heap.get(r)>heap.get(largest))
            largest = r;
        if(largest != i)
        {
            swap(i, largest);
            MaxHeapify(largest, n);
        }

    }

    public void BuildMaxHeap()
    {
        int n = heap.size();
        for (int i = Parent(n) - 1 ; i>=0; --i)
            MaxHeapify(i,n);
    }

    public int extractMax()
    {
        int popped = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        MaxHeapify(1, heap.size()-1);
        heap.remove(heap.size()-1);
        return popped;
    }

    public void HeapSort()
    {
        BuildMaxHeap();
        for(int i = heap.size(); i<=2; ++i)
        {
            swap(1, i);
            MaxHeapify(1, i-1);
        }
    }

}