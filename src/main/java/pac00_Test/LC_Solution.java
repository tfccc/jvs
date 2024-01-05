package pac00_Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-02-06 21:49
 * @desc:
 **/
@SuppressWarnings("unused")
public class LC_Solution {


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
        if ("".contentEquals(numStr)) {
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

    //两数相加 https://leetcode-cn.com/problems/add-two-numbers/
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

    //https://leetcode.cn/problems/3sum/
    public static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    //https://leetcode.cn/problems/longest-valid-parentheses/
    public static int longestValidParentheses(String s) {
        Pattern pattern = Pattern.compile("\\(+\\)+");

        Matcher matcher = pattern.matcher(s);

        int res = 0;
        while (matcher.find()) {
            String group = matcher.group();

            String[] split = group.split("\\(\\)");

            if (split.length == 2) {
                String s1 = split[0];
                String s2 = split[1];
                res += ((Math.min(s1.length(), s2.length())) + 1) * 2;
            } else if (split.length == 1) {
                String s1 = split[0];
                res += s1.length() * 2;
            } else {
                res += 2;
            }
        }
        return res;
    }

    //https://leetcode.cn/problems/regular-expression-matching/
    public static boolean isMatch(String s, String p) {
        String[] split = p.split("");
        List<String> list = new ArrayList<>();

        String star = "*";
        StringBuilder temp = new StringBuilder();
        int length = split.length;

        for (int i = 0; i < length; i++) {
            String crtStr = split[i];
            String nxtStr = (i == length - 1) ? null : split[i + 1];

            if (nxtStr != null && !crtStr.equals(star) && nxtStr.equals(star)) {
                temp.append(crtStr).append(nxtStr);
                list.add(temp.toString());
                temp = new StringBuilder();
                i++;
            } else if (nxtStr != null && crtStr.equals(star) && nxtStr.equals(star)) {
                temp.append("\\").append(crtStr).append(nxtStr);
                list.add(temp.toString());
                temp = new StringBuilder();
                i++;
            } else {
                temp.append(crtStr);
            }
        }
        list.add(temp.toString());

        p = String.join("", list);

        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    //https://leetcode.cn/problems/median-of-two-sorted-arrays/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merge, 0, nums1.length);
        System.arraycopy(nums2, 0, merge, nums1.length, nums2.length);

        Arrays.sort(merge);

        int length = merge.length;

        // 偶数，取(length/2) + (length/2-1)的平均值
        if (length % 2 == 0) {
            int a = merge[length / 2];
            int b = merge[length / 2 - 1];
            return (a + b) / 2D;
        }
        // 奇数，取(length/2)
        else {
            return (merge[length / 2]);
        }
    }

    //https://leetcode.cn/problems/reverse-nodes-in-k-group/
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode crt = head;
        int[] arr = new int[getLen(head, 0)];
        int index = 0;

        for (; ; ) {
            if (crt == null) {
                break;
            }
            arr[index++] = crt.val;
            crt = crt.next;
        }

        int loopRound = arr.length / k;

        for (int i = 0; i < loopRound; i++) {
            int start = i * k;
            int end = start + k - 1;

            int idx = 0;
            for (int j = 0; j < k / 2; j++) {
                int small = arr[start + idx];
                int big = arr[end - idx];
                arr[start + idx] = big;
                arr[end - idx] = small;
                idx++;
            }
        }

        head = null;
        ListNode crtNode = null;
        for (int num : arr) {
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                crtNode = node;
            } else {
                crtNode.next = node;
                crtNode = crtNode.next;
            }
        }
        return head;
    }

    public static int getLen(ListNode node, int i) {
        if (node == null) {
            return i;
        }
        return getLen(node.next, ++i);
    }

    //https://leetcode.cn/problems/divide-two-integers/
    public static int divide(int dividend, int divisor) {
        BigDecimal beiChuShu = new BigDecimal(dividend);
        BigDecimal chuShu = new BigDecimal(divisor);
        BigDecimal max = new BigDecimal(Integer.MAX_VALUE);
        BigDecimal min = new BigDecimal(Integer.MIN_VALUE);

        BigDecimal res = beiChuShu.divide(chuShu, RoundingMode.DOWN);

        if (res.compareTo(max) > 0) {
            return max.intValue();
        } else if (res.compareTo(min) < 0) {
            return min.intValue();
        }
        return res.intValue();
    }

    //https://leetcode.cn/problems/wildcard-matching/
    public static boolean isMatch0(String s, String p) {
        p = p.replaceAll("[*]+", "[a-z]*").replace("?", ".");

        Pattern pattern = Pattern.compile(p);

        return pattern.matcher(s).matches();
    }

    //https://leetcode.cn/problems/permutation-sequence/
    public static String getPermutation(int n, int k) {
        // 结果数组
        ArrayList<String> res = new ArrayList<>();

        // 构建一个n位的数组[1,2,3,4...n]
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // 循环n次, 找1~n, 每一位对应的数字
        for (int i = 1; i <= n; i++) {
            // 推导公式, 通过公式得到当前需要取的index
            int index = (k - 1) / factorial((n - i)) % (n + 1 - i);
            // index对应的数字, 加入结果数组
            res.add(list.get(index) + "");
            // 移除已用的数字
            list.remove(index);
        }
        // 返回结果
        return String.join("", res);
    }

    /** 计算阶乘 **/
    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1,2,3}));
    }

    //https://leetcode.cn/problems/largest-rectangle-in-histogram/
    public static int largestRectangleArea(int[] heights) {
        List<Integer> area = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            int crt = heights[i];
            int width = 1;

            // 向左遍历, 直到找到<当前高度的柱子
            for (int j = i - 1; j >= 0; j--) {
                int leftCrt = heights[j];
                if (leftCrt < crt) {
                    break;
                }
                width++;
            }

            // 向右遍历, 直到找到<当前高度的柱子
            for (int j = i + 1; j <= heights.length - 1; j++) {
                int rightCrt = heights[j];
                if (rightCrt < crt) {
                    break;
                }
                width++;
            }
            area.add(width * crt);
        }
        // 最后用最小高度求一下
        int minHeight = Arrays.stream(heights).min().orElse(0);
        area.add(minHeight * heights.length);

        return area.stream().max(Integer::compareTo).orElse(0);
    }
}

@SuppressWarnings("unused")
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