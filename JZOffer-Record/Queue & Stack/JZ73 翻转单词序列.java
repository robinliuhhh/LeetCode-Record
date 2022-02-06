public class Solution {
    public String ReverseSentence(String str) {
        String res = ""; // 反转之后的句子
        String tmp = ""; // 当前正在处理的单词
        for(int i = 0; i < str.length(); i++) {
            // 遇到空格 断词
            if(str.charAt(i) == ' ') {
                res = ' ' + tmp + res;
                tmp = ""; // tmp刷新
            } else {
                tmp += str.charAt(i);
            }
        }
        // 最后一个单词 前面不加空格
        if(tmp != null) res = tmp + res;
        return res;
    }
}