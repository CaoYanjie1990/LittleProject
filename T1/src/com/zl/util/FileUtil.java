package com.zl.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	/**
	 * 将输入流的数据写入到路径中
	 * 参数1:输入流
	 * 参数2:路径
	 */
	public static void StreamWritePath(InputStream in,String path){
		try {
			//输出流
			OutputStream os = new FileOutputStream(path);
			int ava = in.available();//获取剩余的字节数
			byte[] data = new byte[ava>1024?1024:ava];
			while(in.read(data)!=-1){
				os.write(data,0,ava>data.length?data.length:ava);
				ava = in.available();
			}
			os.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 根据路径读取list
	 */
	public static List<String> getCharacterList(String path){
		//保存读取出来的敏感字
		List<String> list = new ArrayList<String>();
		InputStream is =null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//创建字符增强流(输入)
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			String line = null;
			while((line=reader.readLine())!=null){
				list.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
