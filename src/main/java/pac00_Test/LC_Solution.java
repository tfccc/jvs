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


    //����ˮ--https://leetcode.cn/problems/trapping-rain-water/
    private static int trap(int[] height) {
        //�ҵ���ߵ�, ����ߵ������״ͼ, ���˳�����, �Ҳ൹�����, ����ǽ�����
        System.out.println(Arrays.toString(height));
        // ԭ���
        int preSize = Arrays.stream(height)
                .reduce(Integer::sum)
                .orElse(0);

        // �ҵ���ߵ�
        int max = Arrays.stream(height).max().orElse(0);

        // ������, ��ȡ��һ�����߶ȵ�����
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (max == height[i]) {
                maxIndex = i;
                break;
            }
        }

        // ���˳�����
        for (int i = 0; i < maxIndex; i++) {
            int crt = height[i];
            // ��һ��=0, ����
            if ((i == 0) && height[0] == 0) {
                continue;
            }
            // �ӵ�ǰλ��, ��ߵ����
            for (int j = i + 1; j <= maxIndex; j++) {
                int nxt = height[j];
                // ����ǽ
                if (crt <= nxt) {
                    // �������
                    for (int x = i + 1; x < j; x++) {
                        height[x] = crt;
                    }
                    // ָ���Ƶ�ǽ��λ��
                    i = j - 1;
                    break;
                }
            }
        }

        // �Ҳ൹�����
        for (int i = height.length - 1; i > maxIndex; i--) {
            int crt = height[i];
            // ��һ��=0, ����
            if ((i == height.length - 1) && height[height.length - 1] == 0) {
                continue;
            }
            // �ӵ�ǰλ��, ��ߵ����
            for (int j = i - 1; j >= maxIndex; j--) {
                int nxt = height[j];
                // ����ǽ
                if (crt <= nxt) {
                    // �������
                    for (int x = i - 1; x > j; x--) {
                        height[x] = crt;
                    }
                    // ָ���Ƶ�ǽ��λ��
                    i = j + 1;
                    break;
                }
            }
        }
        return (Arrays.stream(height).reduce(Integer::sum).orElse(0) - preSize);
    }


    //����֮��--https://leetcode-cn.com/problems/two-sum/
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


    //�ַ���ת������(atoi)--https://leetcode-cn.com/problems/string-to-integer-atoi/
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

    //�������
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