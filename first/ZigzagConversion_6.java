package com.example.first;

public class ZigzagConversion_6 {
    public String convert(String s, int numRows) {
        if(s == null)
        	return null;
        if(numRows == 0)
        	return s;
        char [] ch = s.toCharArray();
        StringBuffer [] sb = new StringBuffer[numRows];
        for(int k=0;k<numRows;k++){
        	sb[k] = new StringBuffer();
        }
        int i = 0;
        while(i < ch.length){
        	for(int j = 0;j<numRows && i<ch.length;j++,i++)
        		sb[j].append(ch[i]);
        	for(int j = numRows-2;j>=1 && i<ch.length;j--,i++)
        		sb[j].append(ch[i]);
        }
        
        for(int j=1;j<numRows;j++)
        	sb[0].append(sb[j]);
        return sb[0].toString();
    }
    
    /*public String convert2(String s,int nRows){
    	char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }*/
}
