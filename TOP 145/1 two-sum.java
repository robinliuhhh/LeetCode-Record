class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 有下标有元素值 想到哈希表
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0); // 放入数组第一个值 及其下标
        for(int i = 1; i < nums.length; i++) {
            int res = target - nums[i]; // target减去当前数组的值所得的数 若存在于map中 则构成一组结果
            if(map.containsKey(res)) 
                return new int[] {i, map.get(res)}; // 返回一组下标
            else  
                map.put(nums[i], i); // 未存储过 存入   
        }
        return null; // 没有符合条件的结果
    }
}