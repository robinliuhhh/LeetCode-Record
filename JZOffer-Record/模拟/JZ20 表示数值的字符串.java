import java.util.*;
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @return bool布尔型
     */
    public boolean isNumeric (String str) {
        // 难点在于归纳各种正确的情况 常规思路：逐位遍历一遍并做好标记
        // ‘.’出现正确情况：只出现一次，且在e的前面
        // ‘e’或'E'出现正确情况：只出现一次，且出现前后有数字
        // ‘+’‘-’出现正确情况：只能在开头和e后一位
        
        // str为空或空字符串""
        if(str == null || str.length() == 0)
            return false;
        
        // 标记是否遇到数字、'.' 、'e'或'E'
        boolean isNum = false, isDot = false, ise_or_E = false;
        // 删除字符串头尾的空格
        String s = str.trim();
        for(int i = 0; i < s.length(); i++) {
            // 数字
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                isNum = true;
            // '.' 条件：之前没出现过‘.’以及‘e’或'E'
            else if(s.charAt(i) == '.' && !isDot && !ise_or_E)
                isDot = true;
            // 'e'或'E' 条件：之前没出现过‘e’或'E' 且 之前之后出现数字
            else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !ise_or_E && isNum) {
                ise_or_E = true;
                isNum = false; // 避免12e这种请求被判对
            }
            else if((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                // 什么都不做 i++
            }
            else 
                return false; //其他情况都是非法的
        }
        return isNum;
    }
}