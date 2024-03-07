package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 时间复杂度：O(n^2)
 *
 * @author qinghua.shao
 * @date 2024/3/7
 * @since 1.0.0
 */
public class InsertionSort {

    private static void insertionSort(int[] nums) {

        int n = nums.length;
        // 外循环：已排序好元素数量，初始第1个元素已经算是有序，从第2个数开始，往前插入数字
        for (int i = 1; i < n; i++) {
            // 每次拿一个数字往前插入，判断 j > 0 且 nums[j] < nums[j - 1] 则交换位置
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 9, 2, 6, 5};
        System.out.println("排序前：" + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
