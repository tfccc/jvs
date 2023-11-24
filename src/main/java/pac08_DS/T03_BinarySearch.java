package pac08_DS;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author TFC
 * @date 2019年6月12日 上午10:37:02
 * @note 二分查找测试(数据结构s9_t2)
 */
public class T03_BinarySearch {

    public static int BS(int[] arr1, int arr2, int n1) {
        int low = 0;
        int high = arr1.length - 1;
        for (int i = 1; i <= high + 2; i++) {

            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr2 == arr1[mid]) {
                    if (arr2 == arr1[mid - 1]) {
                        return mid - 1;
                    } else
                        return mid;
                } else if (arr2 > arr1[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
        return low;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 = new int[n1 + 1];
        for (int i = 1; i <= n1; i++) {
            arr1[i] = in.nextInt();
        }
        Arrays.sort(arr1);

        int n2 = in.nextInt();
        int[] arr2 = new int[n2 + 1];
        for (int i = 1; i <= n2; i++) {
            arr2[i] = in.nextInt();

            System.out.print(
                    Arrays.binarySearch(arr1, arr2[i]) + " ");
        }

    }
}
