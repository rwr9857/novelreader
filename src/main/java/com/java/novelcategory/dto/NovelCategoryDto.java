package com.java.novelcategory.dto;

public class NovelCategoryDto {
	private int c_category_id;
	private int n_num;

	public int getC_category_id() {
		return c_category_id;
	}

	public void setC_category_id(int c_category_id) {
		this.c_category_id = c_category_id;
	}

	public int getN_num() {
		return n_num;
	}

	public void setN_num(int n_num) {
		this.n_num = n_num;
	}

	@Override
	public String toString() {
		return "NovelCategoryDto [c_category_id=" + c_category_id + ", n_num=" + n_num + "]";
	}

}
