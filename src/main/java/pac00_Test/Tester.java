package pac00_Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-06-23 19:52
 * @desc:
 **/
public class Tester {


    public static void main(String[] args) {
      
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

}