package com.java.novelcategorie.dto;

public class NovelCategorieDto {
	private int c_categorie_id;
	private int n_num;

	public int getC_categorie_id() {
		return c_categorie_id;
	}

	public void setC_categorie_id(int c_categorie_id) {
		this.c_categorie_id = c_categorie_id;
	}

	public int getN_num() {
		return n_num;
	}

	public void setN_num(int n_num) {
		this.n_num = n_num;
	}

	@Override
	public String toString() {
		return "NovelCategorieDto[" +
				"c_categorie_id=" + c_categorie_id +
				", n_num=" + n_num +
				']';
	}
}
