package com.educandoweb.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URL {
	
	public static String decodeParam(String txt) {
		try {
			return URLEncoder.encode(txt, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
