import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author cassie9082
 * 
 */
public class RepeatedDNASequences {
	/*
	 * A,C,G,T的ASCII码用二进制来表示
	 * A:0100 0001
	 * C:0100 0011
	 * G:0100 0111
	 * T:0101 0100
	 * 每个Character需要1 byte（8 bits）的空间
	 * 题目要求10个字符串长度，如果我们把string放到map里面，会得到memory limit exceeding error
	 * space complexity 是 O(10^n)
	 * 
	 * 用bit manipulation
	 * Since the string contains only 4 characters, 
	 * we could encode the characters using 2 bits each, i.e, 
	 * 'A' -- 00
	 * 'C' -- 01
	 * 'G' -- 10
	 * 'T'  -- 11
	 * And since the length of the substring is only 10 characters, 
	 * the total number of bits needed are only 20. 
	 * Therefore we could encode a string into a integer. 
	 */
    private static Map<Character, Integer> codingMap = new HashMap<Character, Integer>();
    private static int encode(String s){
        int value = 0;
        for(int i = 0; i < s.length(); i++){
            value = (value << 2) + codingMap.get(s.charAt(i));
        }
        return value;
    }
    
    private static void fill(){
        codingMap.put('A', 0);
        codingMap.put('C', 1);
        codingMap.put('G', 2);
        codingMap.put('T', 3);
    }
    
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() < 10){
            return result;
        }
        
        fill();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int lo = 0;
        int hi = 9;
        while(hi < s.length()){
            String substring = s.substring(lo, hi + 1);
            int hashCode = encode(substring);
            if(map.containsKey(hashCode) && map.get(hashCode) == 1){
                result.add(substring);
                map.put(hashCode, map.get(hashCode) + 1);
            }else{
                if(!map.containsKey(hashCode)){
                    map.put(hashCode, 1);
                }else{
                    map.put(hashCode, map.get(hashCode) + 1);
                }
            }
            lo ++;
            hi ++;
        }
        return result;
    }
    
    public static void main(String[] args){
    	System.out.println(Arrays.toString(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toArray()));
    }
}
