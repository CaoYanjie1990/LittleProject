package com.zl.bean;

import java.util.List;

public class PageInfo {
	private List<User> list;//��ǰҳ����Ϣ
	private int current;//��ǰҳ
	private int total;//��ҳ��
	
	public PageInfo(List<User> list, int current, int total) {
		super();
		this.list = list;
		this.current = current;
		this.total = total;
	}

	public PageInfo(){
		
	}
	
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
