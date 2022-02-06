public class Solution {
    public int StrToInt(String str) {
        int res = 0;
        int sign = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                // 字符转数字：此数字的ASCII码 与 0的ASCII码相减即可
                // 拼接时把前一位挪到相应位数
                res = res * 10 +str.charAt(i) - '0';
            } else if (str.charAt(i) == '+') {
                // 判断符号是否在首位 符号位是否已赋值
                if(i > 0 || sign != 0) return 0;
                sign = 1;
            } else if (str.charAt(i) == '-') {
                if(i > 0 || sign != 0) return 0;
                sign = -1;
            } else return 0; // 不合法 返回0
        }
        // sign >= 0是正数
        return sign >= 0 ? res : res * sign;
    }
}