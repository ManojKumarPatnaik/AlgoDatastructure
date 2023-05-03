package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    /**
     * Given NN as the length of temperatures,
     * <p>
     * Time complexity: O(N)O(N)
     * <p>
     * At first glance, it may look like the time complexity of this algorithm should be O(N^2)O(N
     * 2
     * ), because there is a nested while loop inside the for loop. However, each element can only be added to the stack once, which means the stack is limited to NN pops. Every iteration of the while loop uses 1 pop, which means the while loop will not iterate more than NN times in total, across all iterations of the for loop.
     * <p>
     * An easier way to think about this is that in the worst case, every element will be pushed and popped once. This gives a time complexity of O(2 \cdot N) = O(N)O(2⋅N)=O(N).
     * <p>
     * Space complexity: O(N)O(N)
     * <p>
     * If the input was non-increasing, then no element would ever be popped from the stack, and the stack would grow to a size of N elements at the end.
     * <p>
     * Note.md: answer does not count towards the space complexity because space used for the output format does not count.
     **/

    //https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
    public int[] dailyTemperatures(int[] temperatures) {
        int n =  temperatures.length;
        int [] ans = new int[n];

        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            int currentTemp = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[0]< currentTemp){
                int [] prevDay=stack.pop();
                int prevIndex = prevDay[1];
                ans[prevIndex] = i -prevIndex;
            }

            stack.push(new int [] {currentTemp,i});
        }

        return ans;
    }


    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int day = 0; day < n; day++) {
            for (int futureDay = day + 1; futureDay < n; futureDay++) {
                if (temperatures[futureDay] > temperatures[day]) {
                    answer[day] = futureDay - day;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 13 / 5;
        System.out.println(n);


    }

}
