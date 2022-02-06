public class Solution {
	public double Power(double base, int exponent) {

		// 保证exponent不取0 即可保证base和exponent不同时为0
		if (exponent < 0) {
			// 巧妙转换 计算次方可以用下面同一个for循环
			base = 1 / base;
			// 进入下一阶段for循环 计算次方
			exponent = -exponent;
		}

		// 乘法基值
		double res = 1.0;
		if (exponent > 0) {
			// for(; exponent >= 1; exponent--) {
			for (int i = 0; i < exponent; i++) {
				res *= base;
			}
		}
		return res;
	}
}