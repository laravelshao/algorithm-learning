package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author qinghua.shao
 * @date 2024/3/7
 * @since 1.0.0
 */
public class QuickSort {

    private static void quickSort(int[] nums, int left, int right) {

        // 子数组长度为 1 时终止递归
        if (left >= right) {
            return;
        }

        // 哨兵选择
        int pivot = partition(nums, left, right);

        // 递归左右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /**
     * 哨兵选择
     */
    private static int partition(int[] nums, int left, int right) {

        // 以 nums[left] 作为基准值
        int i = left, j = right;
        while (i < j) {
            // 从右向左找出第一个小于基准值的元素
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }

            // 从左往右找出第一个大于基准值的元素
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }

            // 交换两个元素
            swap(nums, i, j);
        }

        // 将基准数交换至两子数组的分界线
        swap(nums, i, left);

        return i;
    }

    /**
     * 交换两个元素
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 9, 2, 6, 5};
        System.out.println("排序前：" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
