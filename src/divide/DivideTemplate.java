package divide;

/**
 * 分治模板，分治本质上就是递归，是递归的一个分支，最重要的是找重复性
 * 分治比泛型的递归多了一步，在drill down 和 revert 之间，拼接子结果再返回
 * @author zhanghongjie
 * @date 2020/11/5
 */
public class DivideTemplate {

    public int divideProblem(Problem problem) {
        if (problem == null) {
            int res = processLastResult();
            return res;
        }

        Problem[] subProblems = splitProblem(problem);

        int res0 = divideProblem(subProblems[0]);
        int res1 = divideProblem(subProblems[1]);

        int result = processResult(res0, res1);
        return result;
    }

    private int processResult(int res0, int res1) {
        return 0;
    }

    private Problem[] splitProblem(Problem problem) {
        return new Problem[0];
    }

    private int processLastResult() {
        return 0;
    }


    public class Problem {

    }
}
