package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * @author qinghua.shao
 * @date 2024/3/6
 * @since 1.0.0
 */
public class SelectionSort {

    /**
     * 选择排序的算法流程：
     * 1.初始状态下，所有元素未排序，即未排序（索引）区间为 [0，n - 1]。
     * 2.选取区间 [0，n - 1] 中的最小元素，将其与索引 0 处的元素交换。完成后，数组前 1 个元素已排序。
     * 3.选取区间 [1，n - 1] 中的最小元素，将其与索引 1 处的元素交换。完成后，数组前 2 个元素已排序。
     * 4.以此类推。经过 n - 1 轮选择与交换后，数组前 n - 1 个元素已排序。
     * 5.仅剩的一个元素必定是最大元素，无须排序，因此数组排序完成。
     *
     * @param nums 待排序数组
     */
    private static void selectionSort(int[] nums) {

        int n = nums.length;
        // 外循环：遍历未排序区间 [0，n - 1]，
        for (int i = 0; i < n - 1; i++) {
            // 记录最小元素的索引
            int minIdx = i;
            // 内层循环：遍历获取最小值索引
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }

            // 交换最小值与外层循环起始位置值
            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 9, 2, 6, 5};
        System.out.println("排序前：" + Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
