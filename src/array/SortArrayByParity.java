package array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * 按奇偶排序数组
 * @author zhanghongjie
 * @date 2020/11/12
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] res = sortArrayByParity.sortArrayByParityII(new int[]{4,2,9,7});
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] sortArrayByParityII(int[] array) {
        //暴力法，官方题解相比自己的优化点，用一个数组遍历两次即可，一次奇数，一次偶数
        int[] odds = new int[array.length];
        int[] evens = new int[array.length];
        int odd = 0, even = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evens[even++] = array[i];
            } else {
                odds[odd++] = array[i];
            }
        }
        odds = Arrays.copyOfRange(odds, 0, odd);
        evens = Arrays.copyOfRange(evens, 0, even);
        //题目没有要求按升序排列
//        Arrays.sort(odds);
//        Arrays.sort(evens);

        odd = 0;
        even = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = evens[even++];
            } else {
                array[i] = odds[odd++];
            }
        }
        return array;
    }

    public int[] sortArrayByParityII2(int[] array) {
        //使用双指针对原数组进行修改
        int n = array.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (array[i] % 2 == 1) {
                while (array[j] % 2 == 1) {
                    j += 2;
                }
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        return array;
    }
}
