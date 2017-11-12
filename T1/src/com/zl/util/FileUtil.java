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
	 * ��������������д�뵽·����
	 * ����1:������
	 * ����2:·��
	 */
	public static void StreamWritePath(InputStream in,String path){
		try {
			//�����
			OutputStream os = new FileOutputStream(path);
			int ava = in.available();//��ȡʣ����ֽ���
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
	 * ����·����ȡlist
	 */
	public static List<String> getCharacterList(String path){
		//�����ȡ������������
		List<String> list = new ArrayList<String>();
		InputStream is =null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//�����ַ���ǿ��(����)
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
