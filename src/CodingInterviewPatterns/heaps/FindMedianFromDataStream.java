package CodingInterviewPatterns.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    //https://leetcode.com/problems/find-median-from-data-stream/
    //https://www.youtube.com/watch?v=itmhHWaHupI
    PriorityQueue<Integer> maxHeap; //should store the small numbers
    PriorityQueue<Integer> minHeap; //should store the large numbers


    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);

        //make sure maxheap has the smaller numbers <= to numbers in min heap;
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int val = maxHeap.poll(); //remove value from maxheap which should have small no
            minHeap.add(val); //add it to minHeap
        }
        //check for the case when the heaps are not even. one heap has more than 2 items
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll()); //
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll()); //
        }

    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size())
            return (float) (minHeap.peek() + maxHeap.peek()) / 2;
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();

    }


    public static void main(String[] args) {
        FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();

        // Adding numbers
        medianFinder.addNum(5);
        medianFinder.addNum(10);
        medianFinder.addNum(2);
        medianFinder.addNum(8);
        medianFinder.addNum(3);

        // Finding the median
        double median = medianFinder.findMedian();
        System.out.println("Median: " + median);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

