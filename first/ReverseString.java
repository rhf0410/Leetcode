package com.example.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseString {
	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
    }
}
