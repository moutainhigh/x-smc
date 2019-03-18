package com.x.smc.bill.util;

import com.x.base.vo.PageInfo;

/**
 * 
 * @author Easy
 *
 */
public class ClassUtils {

	/**
	 * com.github.pagehelper.PageInfo转成com.x.base.vo.PageInfo
	 * 
	 * @author Easy
	 * @param source
	 * @return
	 */
	public static <T> PageInfo<T> transfer(com.github.pagehelper.PageInfo<T> source) {
		PageInfo<T> target = new PageInfo<>();
		target.setCount((int)source.getTotal());
		target.setPageCount(source.getPages());
		target.setPageNo(source.getPageNum());
		target.setPageSize(source.getPageSize());
		target.setResult(source.getList());
		return target;
	}
}
