package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(n)
 *
 * @author qinghua.shao
 * @date 2024/3/7
 * @since 1.0.0
 */
public class MergeSort {

    private static void mergeSort(int[] nums, int left, int right) {

        // 终止条件：当子数组长度为 1 时终止递归
        if (left >= right) {
            return;
        }

        // 计算中间位置
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 合并
        merge(nums, left, mid, right);
    }

    /**
     * 合并数组
     */
    private static void merge(int[] nums, int left, int mid, int right) {

        // 左子数组区间 [left, mid]，右子数组区间 [mid + 1, right]
        // 临时空间存放合并结果
        int[] tmp = new int[right - left + 1];

        // 初始化左右子数组的起始索引
        int i = left, j = mid + 1, k = 0;
        // 左右子数组都存在元素时，比较放入临时数组
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        // 将左右子数组剩余元素复制到临时数组
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        // 将临时数组元素复制到原始数组对应区间
        for (int l = 0; l < tmp.length; l++) {
            nums[left + l] = tmp[l];
        }
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 9, 2, 6, 5};
        System.out.println("排序前：" + Arrays.toString(nums));
        mergeSort(nums, 0, nums.length - 1);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
