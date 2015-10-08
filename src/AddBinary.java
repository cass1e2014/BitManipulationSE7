/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, 
 * a = "11" 
 * b = "1" 
 * Return "100".
 * 
 * @author cassie9082
 * 
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if(a == null && b == null){
            return null;
        }
        
        if(a == null && b != null){
            return b;
        }
        
        if(a != null && b == null){
            return a;
        }
        
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;
        String rst = "";
        
         while(pb >= 0){
             int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;
             rst = String.valueOf(sum % 2) + rst;
             carries = sum / 2;
             pa --;
             pb --;
         }
         
         while(pa >= 0){
             int sum = (int)(a.charAt(pa) - '0') + carries;
             rst = String.valueOf(sum % 2) + rst;
             carries = sum / 2;
             pa --;
         }
         
         if(carries == 1){
             rst = "1" + rst;
         }
         
         return rst;
	}
}
