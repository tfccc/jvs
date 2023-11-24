package pac00_Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-06 21:49
 * @desc:
 **/
public class LC_Solution {


    public static void main(String[] args) {

    }


    //两数之和--https://leetcode-cn.com/problems/two-sum/
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (valueIndexMap.containsKey(remainder)) {
                return new int[]{valueIndexMap.get(remainder), i};
            }
            valueIndexMap.put(nums[i], i);
        }
        return null;
    }


    //字符串转换整数(atoi)--https://leetcode-cn.com/problems/string-to-integer-atoi/
    public static int myAtoi(String s) {
        BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        s = s.replaceAll("^[ |\\t\\n]+", "");
        String[] chars = s.split("");
        StringBuilder numStr = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i].equals("-") || chars[i].equals("+"))) {
                numStr.append(chars[i].equals("-") ? "-" : "");
            } else if (chars[i].matches("\\d")) {
                numStr.append(chars[i]);
            } else {
                break;
            }
        }
        if (numStr.toString().equals("")) {
            numStr.append("0");
        }
        if (!numStr.toString().matches("-?\\d+")) {
            numStr = new StringBuilder("0");
        }
        BigInteger integer = new BigInteger(numStr.toString());
        if (integer.compareTo(max) > 0) {
            return Integer.MAX_VALUE;
        } else if (integer.compareTo(min) < 0) {
            return Integer.MIN_VALUE;
        } else {
            return Integer.parseInt(numStr.toString());
        }
    }

    //两数相加
    //https://leetcode-cn.com/problems/add-two-numbers/
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = 0;
        int s2 = 0;
        while (l1 != null) {
            s1 = (l1.val + s1 * 10);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2 = (l2.val + s2 * 10);
            l2 = l2.next;
        }
        int sum = s1 + s2;
        int loopTime = String.valueOf(sum).length();
        ListNode res = new ListNode(sum % 10);
        System.out.println(sum % 10);
        ListNode temp = res;
        for (int i = 1; i < loopTime; i++) {
            temp.next = new ListNode((int) (sum / (Math.pow(10, i)) % 10));
            temp = temp.next;
            System.out.println("*" + temp.val);
            if (i == loopTime - 1) return res;
        }
        return res;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "->");
        print(node.next);
    }
}