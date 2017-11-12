package com.zl.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * ������־
 * @author Administrator
 *
 */
public class Logger {
	private static File file ;
	private static FileWriter fw;
	public Logger(){
		file = new File("F:\\summer\\file\\T1.log");
		try {
			/**
			 * ������:true������writeʱ��׷��ģʽ
			 */
			fw = new FileWriter(file,true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void info(String msg){
		try {
			fw.write("[INFO]"+DateUtil.getStr(new Date())+":"+msg+"\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void error(String msg){
		try {
			fw.write("[ERROR]"+DateUtil.getStr(new Date())+":"+msg+"\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
