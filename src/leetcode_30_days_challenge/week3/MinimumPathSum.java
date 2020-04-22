package leetcode_30_days_challenge.week3;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum pathSum = new MinimumPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(pathSum.minPathSum(grid));
        //https://www.youtube.com/watch?v=ItjZdu6jEMs
    }

    public int minPathSum(int[][] grid) {
        if (grid == null && grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[i].length; j++) {
                int n = grid[i][j];
                //System.out.print(n);

                dp[i][j] += grid[i][j];

                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }

        }


        return dp[dp.length - 1][dp[0].length - 1]; //bottom right conner sum
    }
}
