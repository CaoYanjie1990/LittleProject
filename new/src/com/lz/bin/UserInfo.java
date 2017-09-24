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
		//打印用户列表
		Set<String> set = map.keySet();
		for(String username:set){
			System.out.println("用户名："+username);
		}
	}
	
	/**
	 * 校验用户
	 * @param userName 需要校验的用户名
	 * @param password 需要校验的密码
	 * @return 是否存在 true:存在 false:不存在
	 * 
	 * 校验用户名是否重复
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
