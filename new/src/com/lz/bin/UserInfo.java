package com.lz.bin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserInfo {
	private static Map<String,String> map = new HashMap<String, String>();
	
	static {
		map.put("admin", "000000");
		map.put("root", "000000");
		map.put("cyj", "000000");
	}
	
	public static void addinfo(String name,String psw){
		map.put(name, psw);
		//��ӡ�û��б�
		Set<String> set = map.keySet();
		for(String username:set){
			System.out.println("�û�����"+username);
		}
	}
	
	/**
	 * У���û�
	 * @param userName ��ҪУ����û���
	 * @param password ��ҪУ�������
	 * @return �Ƿ���� true:���� false:������
	 * 
	 * У���û����Ƿ��ظ�
	 */
	
	public static boolean findUser(String name){
		boolean res = false;
		Set<String> set = map.keySet();
		for(String username:set){
			if(username.equals(name)){
				res = true;
				break;
			}
		}
		return res;
	} 
	
	public static boolean findUser(String name,String psw){
		boolean res = false;
		Set<String> set = map.keySet();
		for(String username:set){
			if(username.equals(name)&&map.get(username).equals(psw)){
				res = true;
				break;
			}
		}
		return res;
	} 

}
