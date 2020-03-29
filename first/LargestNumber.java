package com.example.first;

public class LargestNumber {
	/**
	 * Largest Number.
	 * @param nums
	 * @return
	 */
	public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
        	return null;
        
        String result = new String("");
        for(int i=1;i<nums.length;i++){
        	for(int j=0;j<i;j++){
        		if(!compare(nums[j], nums[i])){
        			int k = nums[j];
        			nums[j] = nums[i];
        			nums[i] = k;
        		}
        	}
        }
        for(int i=0;i<nums.length;i++)
        	//System.out.print(nums[i] + " ");
        	result += nums[i];
        if(result.matches("0*")){
        	return "0";
        }
        return result;
    }
	
	private boolean compare(int num1, int num2){
		/*String snum1 = String.valueOf(num1);
		String snum2 = String.valueOf(num2);
		int length = snum1.length() > snum2.length() ? snum2.length() : snum1.length();
		for(int i=0;i<length;i++){
			int sub_num1 = snum1.charAt(i) - '0';
			int sub_num2 = snum2.charAt(i) - '0';
			if(sub_num1 > sub_num2)
				return true;
			if(sub_num1 < sub_num2)
				return false;
		}
		if(snum1.length() > snum2.length()){
			if(snum1.charAt(snum2.length()) >= snum2.charAt(0)){
				return true;
			}else{
				return false;
			}
		}else if(snum1.length() < snum2.length()){
			if(snum2.charAt(snum1.length()) >= snum1.charAt(0)){
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}*/
		String str1 = String.valueOf(num1) + String.valueOf(num2);
		String str2 = String.valueOf(num2) + String.valueOf(num1);
		for(int i=0;i<str1.length();i++){
			if(str2.charAt(i) > str1.charAt(i)){
				return false;
			}else if(str2.charAt(i) == str1.charAt(i)){
				continue;
			}else{
				break;
			}
		}
		return true;
	}
}
