package com.zl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
		private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		public static Date getDate(String strDate){
			try {
				return sdf.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public static String getStr(Date date){
			return sdf2.format(date);
		}
}
