package recursion;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头返回来返回每个节点的值
 * @author zhanghongjie
 * @date 2020/11/4
 */
public class ReversePrintListNode {

    /**
     * 使用递归解决，时间负责度O(n)，空间复杂度O(n)
     * @param head
     * @return
     */
    public int[] solution(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reversePrintCore(head, list);
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            res[index++] = i;
        }
        return res;
    }

    public void reversePrintCore(ListNode node, List<Integer> list) {
        if (node == null) {
            //递归终结条件
            return;
        }
        //当前层不处理
        //直接进入下一层
        reversePrintCore(node.next, list);
        //清理数据
        list.add(node.val);
    }

    /**
     * 辅助栈，利用栈的性质将链表翻转
     *
     * 空间复杂度O(n)，时间复杂度O(n)
     * @param head
     * @return
     */
    public int[] solution2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    /**
     * 先遍历链表的长度，再反着填进数组中
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param head
     * @return
     */
    public int[] solution3(ListNode head) {
        int size = resize(head);
        int arr[] = new int[size];
        ListNode temp = head;
        for(int x = size - 1; x >= 0; x--){
            arr[x] = temp.val;
            temp = temp.next;
        }
        return arr;
    }

    public int resize(ListNode node){
        ListNode temp = node;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
