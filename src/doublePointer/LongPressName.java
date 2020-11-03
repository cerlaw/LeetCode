package doublePointer;

/**
 * @author zhanghongjie
 * @date 2020/11/3
 */
public class LongPressName {

    public boolean solution(String name, String typed) {
        if (name == null || typed == null) {
            return false;
        }

        char[] ns = name.toCharArray();
        char[] ts = typed.toCharArray();
        int i = 0, j = 0;
        while (i < ns.length && j < ts.length) {
            if (ns[i] == ts[j]) {
                i++;
                j++;
            } else if (i > 0 && ns[i - 1] == ts[j]) {
                j++;
            } else {
                return false;
            }
        }
        return i == ns.length;
    }
}
