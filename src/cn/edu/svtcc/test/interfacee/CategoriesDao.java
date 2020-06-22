package cn.edu.svtcc.test.interfacee;

import java.util.List;

import cn.edu.svtcc.test.pojo.CategoriesDo;

public interface CategoriesDao {
	/*
	 * 得到图书种类的列表
	 * 
	 * @return
	 */
	List<CategoriesDo> listCategories();

}
