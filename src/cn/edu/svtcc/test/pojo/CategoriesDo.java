package cn.edu.svtcc.test.pojo;

import java.io.Serializable;

public class CategoriesDo implements Serializable {
	private Integer id;
	private String name;
	public CategoriesDo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CategoriesDo [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
