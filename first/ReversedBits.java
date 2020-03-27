package com.example.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReversedBits {
	/**
	 * Reversed Bits.
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {
		int result = 0;
		for(int i=0;i<32;i++){
			result |= ((n>>i)&1) << (31-i);
		}
		return result;
    }
}
