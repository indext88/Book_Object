package cn.edu.svtcc.test.test;

import java.util.List;

import cn.edu.svtcc.test.dao.CategoriesDaoimpl;
import cn.edu.svtcc.test.pojo.CategoriesDo;

public class test {
	public static void main(String[] args) {
		CategoriesDaoimpl daoimpl=new CategoriesDaoimpl();
		List<CategoriesDo>list=daoimpl.listCategories();
		System.out.println(list.size());
	}

}
