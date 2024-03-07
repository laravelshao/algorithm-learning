package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * @author qinghua.shao
 * @date 2024/3/6
 * @since 1.0.0
 */
public class BubbleSort {

    /**
     * 设数组的长度为 n，冒泡排序步骤：
     * 1.首先，对 n 个元素执行“冒泡”，将数组的最大元素交换至正确位置（尾部）。
     * 2.接下来，对剩余 n - 1 个元素执行“冒泡”，将第二大元素交换至正确位置。
     * 3.以此类推，经过 n - 1 轮“冒泡”后，前 n - 1 大的元素都被交换至正确位置。
     * 4.仅剩的一个元素必定是最小元素，无须排序，因此数组排序完成。
     *
     * @param nums 待排序数组
     */
    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        // 外循环：遍历次数
        for (int i = 0; i < n - 1; i++) {
            // 内循环：需要比较的下标区间 [0, n - 1 - i)，每次外层迭代，都会将本轮最大值移至末尾区间末尾位置，尾部元素已有序
            for (int j = 0; j < n - 1 - i; j++) {
                // 判断大小，如果左元素大于右元素，则交换位置
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 9, 2, 6, 5};
        System.out.println("排序前：" + Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
