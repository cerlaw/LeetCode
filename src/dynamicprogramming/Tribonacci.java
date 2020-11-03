package dynamicprogramming;

/**
 * 第N个泰波那契数
 * 时间复杂度O(n)，空间复杂度O(1)
 * @author zhanghongjie
 * @date 2020/11/3
 */
public class Tribonacci {

    public int solution(int n) {
        if (n < 3) {
            return n == 0 ? 9 : 1;
        }
        //使用常量来代替dp数组，节约空间
        int i = 0, j = 1, k = 1;
        int sum = 0;
        for (int a = 3; a <= n; a++) {
            sum = i + j + k;
            i = j;
            j = k;
            k = sum;
        }
        return sum;
    }
}
