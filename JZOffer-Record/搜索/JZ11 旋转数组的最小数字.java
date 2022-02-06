/**
* 要求时间复杂度 O(logn)
* 所以考虑二分搜索
*/
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        // base case
        if(array.length == 0) return 0;
        
        int lo = 0;
        int hi = array.length - 1;
        // 二分法
        // 旋转后 前后段各有序 如[2, 2, 2, 1, 2] (1, 2是旋转后的部分)
        while(lo < hi) { 
            int mid = lo + ((hi - lo) >> 1); // (hi - lo) / 2
            
            if(array[mid] < array[hi]) {
                hi = mid;
            } else if(array[mid] > array[hi]) {
                lo = mid + 1;
            } else {
				// array[mid] == array[hi]
                hi--; // hi = mid - 1;拆分 因为else总要有事做
            }
        }
		// !(lo < hi)
        return array[lo];
    }
}

/*
public class Main {
    public int minNumberInRotateArray(int[] array) {
        // base case
        if (array.length == 0) return 0;

        int lo = 0;
        int hi = array.length - 1;
        // 二分法
        // 旋转后 前后段各有序 如456 123(123是旋转后的部分)
        // 直到找到hi - lo == 1(相邻) && array[lo] > array[hi]时的array[hi]
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println("---------------");
            System.out.println("mid = " + mid+"   array[mid] = " + array[mid]);
            System.out.println("lo = " + lo + "  hi = " + hi);
            System.out.println("array[lo] = " + array[lo] + "   array[hi] = " + array[hi]);
            System.out.println("---------------");

            if (array[mid] < array[hi]) {
                hi = mid;
                System.out.println("array[mid] < array[hi]: hi = " + hi);
            } else if (array[mid] > array[hi]) {
                lo = mid + 1;
                System.out.println("array[mid] > array[hi]: lo = " + lo);
            } else {
                hi--;
                System.out.println("else: hi = " + hi);
            }
        }
        return array[lo];
    }

    public static void main(String[] args) {
        Main main = new Main();
        int i = main.minNumberInRotateArray(new int[]{3, 4});
        System.out.println(i);
    }
}
*/