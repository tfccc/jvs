package pac00_Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-06 21:49
 * @desc:
 **/
public class LC_Solution {


    public static void main(String[] args) {
        //int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = new int[]{0, 0, 0, 0, 0, 0};
        System.out.println(trap(height));
    }


    //接雨水--https://leetcode.cn/problems/trapping-rain-water/
    private static int trap(int[] height) {
        //找到最高点, 用最高点二分柱状图, 左侧顺序遍历, 右侧倒序遍历, 遇到墙则填充
        System.out.println(Arrays.toString(height));
        // 原面积
        int preSize = Arrays.stream(height)
                .reduce(Integer::sum)
                .orElse(0);

        // 找到最高点
        int max = Arrays.stream(height).max().orElse(0);

        // 从左到右, 获取第一个最大高度的索引
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (max == height[i]) {
                maxIndex = i;
                break;
            }
        }

        // 左侧顺序遍历
        for (int i = 0; i < maxIndex; i++) {
            int crt = height[i];
            // 第一个=0, 跳过
            if ((i == 0) && height[0] == 0) {
                continue;
            }
            // 从当前位置, 最高点遍历
            for (int j = i + 1; j <= maxIndex; j++) {
                int nxt = height[j];
                // 遇到墙
                if (crt <= nxt) {
                    // 填充数组
                    for (int x = i + 1; x < j; x++) {
                        height[x] = crt;
                    }
                    // 指针移到墙的位置
                    i = j - 1;
                    break;
                }
            }
        }

        // 右侧倒序遍历
        for (int i = height.length - 1; i > maxIndex; i--) {
            int crt = height[i];
            // 第一个=0, 跳过
            if ((i == height.length - 1) && height[height.length - 1] == 0) {
                continue;
            }
            // 从当前位置, 最高点遍历
            for (int j = i - 1; j >= maxIndex; j--) {
                int nxt = height[j];
                // 遇到墙
                if (crt <= nxt) {
                    // 填充数组
                    for (int x = i - 1; x > j; x--) {
                        height[x] = crt;
                    }
                    // 指针移到墙的位置
                    i = j + 1;
                    break;
                }
            }
        }
        return (Arrays.stream(height).reduce(Integer::sum).orElse(0) - preSize);
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