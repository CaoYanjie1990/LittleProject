package com.zl.util;
/**
 * ���÷�ҳ��Ϣ
 */
public class PageUtil {
	//ȷ��ÿҳ��ʾ����������
	public static int NEWSDETAIL_COUNT = 5;
	/**
	 * 
	 * @param count ������
	 * @param page	ÿҳ��ʾ������
	 * @return
	 */
	public static int getPageTotal(int count,int page){
		int res = count/page;
		//������ʾ��ҳ��
		//ҳ��=������/ÿҳ��ʾ������������+1:��������ÿҳ��ʾ������ȡ�಻Ϊ0�� 
		if(count % page !=0)
			res+=1;
		return res;
	}
}
