package com.java.categorie.dto;

public class CategorieDto {
	private int C_CATEGORIE_ID;
	private String C_CATEGORIE_NAME;

	public int getC_CATEGORIE_ID() {
		return C_CATEGORIE_ID;
	}

	public void setC_CATEGORIE_ID(int c_CATEGORIE_ID) {
		C_CATEGORIE_ID = c_CATEGORIE_ID;
	}

	public String getC_CATEGORIE_NAME() {
		return C_CATEGORIE_NAME;
	}

	public void setC_CATEGORIE_NAME(String c_CATEGORIE_NAME) {
		C_CATEGORIE_NAME = c_CATEGORIE_NAME;
	}

	@Override
	public String toString() {
		return "CategorieDto [C_CATEGORIE_ID=" + C_CATEGORIE_ID + ", C_CATEGORIE_NAME=" + C_CATEGORIE_NAME + "]";
	}

}
