package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 思路：单调栈
 */
class Solution402 {

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        stack.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while (!stack.empty() && stack.peek() > num.charAt(i) && k-- > 0) {
                stack.pop();
            }
            stack.push(num.charAt(i));
        }
        while (k-- > 0) {
            stack.pop();
        }
        List<Character> list = new ArrayList<>(stack);
        boolean effective = false;
        for (Character character : list) {
            if (character == '0' && !effective) {
                continue;
            } else {
                effective = true;
            }
            stringBuilder.append(character);
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.toString();
    }
}
