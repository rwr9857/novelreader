package com.java.novelcategorie.dto;

public class NovelCategorieDto {
	private int C_CATEGORIE_ID;
	private String N_NUM;

	public int getC_CATEGORIE_ID() {
		return C_CATEGORIE_ID;
	}

	public void setC_CATEGORIE_ID(int c_CATEGORIE_ID) {
		C_CATEGORIE_ID = c_CATEGORIE_ID;
	}

	public String getN_NUM() {
		return N_NUM;
	}

	public void setN_NUM(String n_NUM) {
		N_NUM = n_NUM;
	}

	@Override
	public String toString() {
		return "CategorieDto [C_CATEGORIE_ID=" + C_CATEGORIE_ID + ", N_NUM=" + N_NUM + "]";
	}

}
