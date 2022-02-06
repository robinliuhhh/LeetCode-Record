import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param s string字符串 
     * @return string字符串
     */
    public String replaceSpace (String s) {
        StringBuilder sb = new StringBuilder();
        // 字符串s中的每个字符都拆出来 一个个比较
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                // 空格换成%20再拼接
                sb.append("%20");
            } else {
                // 字符直接拼接
                sb.append(c);
            }
        }
        return sb.toString();
    }
}