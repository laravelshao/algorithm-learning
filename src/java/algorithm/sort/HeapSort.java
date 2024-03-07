package algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * <p>
 * 时间复杂度：O(n log n)
 * 空间复杂度：O(1)
 *
 * @author qinghua.shao
 * @date 2024/3/7
 * @since 1.0.0
 */
public class HeapSort {

    /**
     * 堆排序
     */
    private static void heapSort(int[] nums) {
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        // 从堆中提取最大元素，循环 n-1 轮
        for (int i = nums.length - 1; i > 0; i--) {
            // 交换根节点与最右叶节点（交换首元素与尾元素）
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            // 以根节点为起点，从顶至底进行堆化
            siftDown(nums, i, 0);
        }
    }

    /**
     * 堆的长度为 n ，从节点 i 开始，从顶至底堆化
     */
    private static void siftDown(int[] nums, int n, int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int ma = i;
            if (l < n && nums[l] > nums[ma])
                ma = l;
            if (r < n && nums[r] > nums[ma])
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            int temp = nums[i];
            nums[i] = nums[ma];
            nums[ma] = temp;
            // 循环向下堆化
            i = ma;
        }
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 9, 2, 6, 5};
        System.out.println("排序前：" + Arrays.toString(nums));
        heapSort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
