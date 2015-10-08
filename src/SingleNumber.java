/*
 * Question:
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Hint:
 * The key to solve this problem is bit manipulation.
 * XOR will return 1 only on two different bits.
 * So if two numbers are the same, XOR will return 0. Finally only one number left.
 */

/**
 * 这道题运用位运算的异或。异或是相同为0，不同为1。所以对所有数进行异或，得出的那个数就是single
 * number。初始时先让一个数与0异或，然后再对剩下读数挨个进行异或。
 * 
 * 这里运用到异或的性质：对于任何数x，都有x^x=0，x^0=x
 * 
 * @author cassie9082
 * 
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int result = 0;
		for(int i = 0; i < A.length; i++){
			result = result^A[i];
		}
		return result;
	}
}
