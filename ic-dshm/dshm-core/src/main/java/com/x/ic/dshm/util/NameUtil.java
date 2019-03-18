package com.x.ic.dshm.util;


/**
 * 命名约定类
 * @author weichuang
 *
 */
public class NameUtil {
	/**
	 * 根据表的列名生成po类的属性名
	 * @param columnName
	 * @return
	 */
	public static String getProNameFromColumnName(String columnName){
		columnName = columnName.toLowerCase();
		String[] columnNameSplits=columnName.split("_");
		String proName="";
		boolean isFirst=true;
		for (int i = 0; i < columnNameSplits.length; i++) {
			if( !"".equals(columnNameSplits[i])) {
				if (isFirst) {
					proName=proName+(columnNameSplits[i].charAt(0)+"").toLowerCase()+columnNameSplits[i].substring(1);
					isFirst=false;
				}else {
					proName=proName+(columnNameSplits[i].charAt(0)+"").toUpperCase()+columnNameSplits[i].substring(1);
				}
			}else {
				
			}		
		}
		return proName;
	}
	/**
	 * 根据表名生成po的类名
	 * @param tableName
	 * @return
	 */
	public static String getClassNameFromTableName(String tableName){
		tableName = tableName.toLowerCase();
		String[] tableNameSplits=tableName.split("_");
		String className="";
		for (int i = 0; i < tableNameSplits.length; i++) {
			tableNameSplits[i]=tableNameSplits[i].toLowerCase();
			if( !"".equals(tableNameSplits[i])) {
				className=className+(tableNameSplits[i].charAt(0)+"").toUpperCase()+tableNameSplits[i].substring(1);
			}else {
				
			}		
		}
		className=className.replace("Wis", "");
		return className;
	}
	public static void main(String[] args) {
		//System.out.println(getProNameFromColumnName("_Cdf_DD"));
		System.out.println(getClassNameFromTableName("WissfIfdfU"));
	}
}
