package dynamicprogramming;

/**
 * @author zhanghongjie
 * @date 2020/10/20
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.solution(3));
        System.out.println(climbingStairs.solution(6));
    }

    public int solution(int n) {
        //使用动态规划来解，首先有dp数组，但由于空间复杂度为O(n)，可以进行优化只记录最近两个的数据，把空间复杂度提升为O(1)
//        int[] dp = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            if (i == 1) {
//                dp[i] = 1;
//                continue;
//            }
//            if (i == 2) {
//                dp[i] = 2;
//                continue;
//            }
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];

        //优化为O(1)

//        int first = 0;
//        int second = 1;
//        int third = 0;
//        for (int i = 1; i <= n; i++) {
//            third = first + second;
//            first = second;
//            second = third;
//        }
//        return third;

        //因为其实是一个斐波那契数列，所以可以直接代入公式计算 把时间复杂度降低到O(1)
        double sqrt5 = Math.sqrt(5);
        double result = (Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1)) / sqrt5;
        return (int) result;



    }
}
