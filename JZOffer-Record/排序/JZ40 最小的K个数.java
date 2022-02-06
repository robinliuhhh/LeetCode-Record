import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        
        // 大根堆 实时维护数组的前 k 小值
        // 首先将前 k 个数插入大根堆中，随后从第 k+1 个数开始遍历
        // 如果当前遍历到的数比大根堆的堆顶的数要小，就把堆顶的数弹出，再插入当前遍历到的数。
        // 最后将大根堆里的数存入数组返回即可。

        if(k == 0 || input.length == 0) return new ArrayList<>(); // 避免空指针异常
        
        // PriorityQueue默认小根堆 大根堆需要重写比较器
		/*
			堆的定义：
				1、堆是一个完全二叉树
				2、节点大于等于所有子节点叫做大顶堆，小于等于所有子节点叫做小顶堆
		*/
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		/*PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});*/
        
        for(int num : input) {
            if(maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if(maxHeap.peek() > num) { // maxHeap.peek()即为堆中最大值
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length) return list; // 不够k个数
        for(int num : maxHeap) {
            list.add(num);
        }
        return list;
    }
}