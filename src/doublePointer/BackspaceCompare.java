package doublePointer;

/**
 * @author zhanghongjie
 * @date 2020/10/20
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        System.out.println(backspaceCompare.solution("ab#c", "ad#c"));
        System.out.println(backspaceCompare.solution("ab##", "c#d#"));
        System.out.println(backspaceCompare.solution("a#c", "b"));
    }

    public boolean solution(String S, String T) {

        //采用双指针 + 倒叙遍历的方法 ，空间复杂度为O(1)
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;

//        return DBS(S).equals(DBS(T));
    }

    /**
     * 一开始自己使用的是两个栈来比较，在题解中看到使用StringBuilder的方法原理基本一致，但更优雅，但空间复杂度为O(N + M)
     * @param s
     * @return
     */
    public String DBS (String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
