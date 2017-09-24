package com.zl.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserInfo {
		private static Map<String,String> map = new HashMap<String,String>();
		
		//添加新用户
		public static void setMap(String newName,String newPwd) {
				map.put(newName, newPwd);
				//打印用户列表
				Set<String> set = map.keySet();
				for (String key : set) {
					System.out.println("用户:"+key);
				}
		}
		static{
			map.put("admin", "123");
			map.put("jdit", "123");
			map.put("user", "123");
		}
		/**
		 * 校验用户
		 * @param userName 需要校验的用户名
		 * @param password 需要校验的密码
		 * @return 是否存在 true:存在 false:不存在
		 */
		public static boolean findUser(String userName,String password){
			boolean res = false;
			Set<String> keys =  map.keySet();
			for (String key : keys) {
				if(key.equals(userName)&&map.get(key).equals(password)){
					res = true;
					break;
				}
			}
			return res;
		}
		/**
		 * 判断该用户名是否被占用
		 * @param userName
		 * @return
		 */
		public static boolean findUser(String userName){
			boolean res = false;
			Set<String> keys =  map.keySet();
			for (String key : keys) {
				if(key.equals(userName)){
					res = true;
					break;
				}
			}
			return res;
		}
}
