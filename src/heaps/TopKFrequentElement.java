package heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    //https://www.geeksforgeeks.org/priority-queue-class-in-java/
    //https://leetcode.com/problems/top-k-frequent-elements/

    /**
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * k is in the range [1, the number of unique elements in the array].
     * It is guaranteed that the answer is unique.
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int a : nums){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>();
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(Map.Entry.comparingByValue(Collections.reverseOrder()));

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            minHeap.add(entry);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[minHeap.size()];
        int index=0;

        while(!minHeap.isEmpty()){
            result[index++] = minHeap.poll().getKey();
        }

        return result;

    }
}
