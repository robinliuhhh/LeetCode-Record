import java.util.*;
public class Solution {
    
    ArrayList<String> res = new ArrayList<>();
    TreeSet<String> paths = new TreeSet<>(); // 去重
    char[] arr;
    boolean[] visited;
    StringBuilder sb = new StringBuilder();
    
    public ArrayList<String> Permutation(String str) {
        
        if(str==null||str.length()==0) return null;
        
        arr = str.toCharArray();
        visited = new boolean[arr.length];
        dfs(0);
        // 去重
        res.addAll(paths);
        return res;
    }
    
    // 回溯法（走不通就退回再走）
    public void dfs(int len) {
        // 动态字符串sb长度与原始str长度相同
        if(len == arr.length) {
            paths.add(new String(sb)); // 就添加到TreeSet中
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                sb.append(arr[i]);
                visited[i] = true;
                dfs(len + 1);
                // 回溯 状态重置
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;;
            }
        }
    }
}

/*
import java.util.*;
public class Solution {
    
    ArrayList<String> res = new ArrayList<>();
    char[] arr;
    StringBuilder sb = new StringBuilder();
    
    public ArrayList<String> Permutation(String str) {
        
        if(str==null||str.length()==0) return null;
        
        arr = str.toCharArray();
        dfs(0);
        return res;
    }
    
    public void dfs(int i) {
        // 动态字符串sb长度与原始str长度相同
        if(sb.length() == arr.length) {
            res.add(new String(sb)); // 就添加到结果列表
            return;
        }
        
        Set<Character> set = new HashSet<>();
        for(int j = i; j < arr.length; j++) {
            // 剪枝 去掉重复项
            if(set.contains(arr[j])) continue;
            
            // 保持第一个字符不动 从第二个位置开始依次跟后面的字符进行比较
            sb.append(arr[j]);
            set.add(arr[j]);
            // 不同则交换 由此确定第一个位置的字符
            swap(arr, i, j);
            // 递归
            dfs(i + 1);
            // 换回来 以便往后判断是否需要跟i交换
            swap(arr, i, j);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
*/