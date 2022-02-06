public class Solution {
    public static int GetNumberOfK(int[] array, int k) {
        // 排序数组中的搜索问题 首先想到二分法
        // 统计次数 找到左右边界 次数= right - left + 1
        if (array.length == 0) return 0;

        return right(array, k) - left(array, k) + 1;
    }

    // 获取k第一次出现的下标
    public static int left(int[] array, int k) {
        int i = 0, j = array.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            System.out.println("m = " + m);
            if (array[m] >= k)
                // array[m] == k时缩右边界
                j = m - 1;
            else
                i = m + 1;
        }
        // i定位在最左端
        System.out.println("i = " + i);
        return i;
    }

    // 获取k最后一次出现的下标
    public static int right(int[] array, int k) {
        int i = 0, j = array.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (array[m] <= k)
                // array[m] == k时缩左边界
                i = m + 1;
            else
                j = m - 1;
        }
        // j定位在最右端
        System.out.println("j = " + j);
        return j;
    }
}