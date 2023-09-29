package CodingInterviewPatterns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    //https://leetcode.com/problems/permutations/description/

    /**
     * Time complexity, what you should say in an interview: O(n⋅n!)
     * <p>
     * Finding permutations is a well-studied problem in combinatorics.
     * Given a set of length n, the number of permutations is n!.
     * There are n options for the first number, n−1 for the second, and so on.
     * <p>
     * For each of the n! permutations, we need O(n) work to copy curr into the answer.
     * This gives us O(n⋅n!) work.
     * <p>
     * To reiterate:
     * <p>
     * Number of Permutations: The number of permutations for a set of length n is n!.
     * This is because there are n options for the first number, n-1 for the second, and so on.
     * <p>
     * Work for Each Permutation: For each of the n! permutations generated by the algorithm,
     * there's a copying step where the current permutation (tempList) is added to the result list. This copying step takes O(n) time.
     * <p>
     * Overall Time Complexity: Combining these two factors, the overall time complexity of the algorithm becomes O(n * n!).
     * This accounts for both the number of permutations and the work required for each permutation.
     */
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(new ArrayList<>(), ans, nums);
            return ans;
        }

        public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
            if (curr.size() == nums.length) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            for (int num : nums) {
                if (!curr.contains(num)) {
                    curr.add(num);
                    backtrack(curr, ans, nums);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
