/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 这道题让我们判断一个数是否为2的次方数，而且要求时间和空间复杂度都为常数，那么对于这种玩数字的题，我们应该首先考虑位操作 Bit
 * Operation。在LeetCode中，位操作的题有很多，比如比如Repeated DNA Sequences 求重复的DNA序列， Single
 * Number 单独的数字, Single Number II 单独的数字之二 ， Grey Code 格雷码， Reverse Bits
 * 翻转位，Bitwise AND of Numbers Range 数字范围位相与，Number of 1 Bits 位1的个数 和 Divide Two
 * Integers 两数相除等等。那么我们来观察下2的次方数的二进制写法的特点：
 * 
 * 1     2       4         8         16 　　....（十进制）
 * 1    10      100       1000       10000　....（二进制）
 * 
 * 那么我们很容易看出来2的次方数都只有一个1，剩下的都是0，所以我们的解题思路就有了，我们只要每次判断最低位是否为1，然后向右移位，最后统计1的个数即可判断是否是2的次方数
 * 
 * @author cassie9082
 * 
 */
public class PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		int cnt = 0;
		while (n > 0) {
			cnt += n & 1;
			n = n >> 1;
		}
		return cnt == 1;
	}
	
	public static void main(String[] args){
		System.out.println(isPowerOfTwo(4));
	}
}
