package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	/**
	 * Restore IP addresses.
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {
        List<String>result = new ArrayList<String>();
        if(s == null || s.length() == 0)
        	return result;
        helper(result, s, 0, 0, "");
        return result;
    }
	
	private void helper(List<String>result, String str, int index, int count, String ret){
		if(count > 4)
			return;
		if(count == 4 && index == str.length()){
			result.add(ret);
			return;
		}
		for(int i=1;i<4;i++){
			if(index + i > str.length())
				break;
			String temp = str.substring(index, index + i);
			if((temp.startsWith("0") && temp.length() > 1) || (i == 3 && Integer.parseInt(temp) >= 256))
				continue;
			helper(result, str, index + i, count + 1, ret + temp + (count == 3?"":"."));
		}
	}
}
