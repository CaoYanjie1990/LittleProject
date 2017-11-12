package com.zl.util;
/**
 * 配置分页信息
 */
public class PageUtil {
	//确定每页显示的数据数量
	public static int NEWSDETAIL_COUNT = 5;
	/**
	 * 
	 * @param count 总数量
	 * @param page	每页显示的数量
	 * @return
	 */
	public static int getPageTotal(int count,int page){
		int res = count/page;
		//计算显示的页数
		//页数=总数量/每页显示的数据数量（+1:总数量和每页显示的数量取余不为0） 
		if(count % page !=0)
			res+=1;
		return res;
	}
}
