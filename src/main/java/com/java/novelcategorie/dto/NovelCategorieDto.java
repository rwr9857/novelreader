package com.java.novelcategorie.dto;

import java.util.ArrayList;
import java.util.List;

public class NovelCategorieDto {
	private int C_CATEGORIE_ID;
	private int N_NUM;

	
	
	public int getC_CATEGORIE_ID() {
		return C_CATEGORIE_ID;
	}

	public void setC_CATEGORIE_ID(int c_CATEGORIE_ID) {
		C_CATEGORIE_ID = c_CATEGORIE_ID;
	}

	public int getN_NUM() {
		return N_NUM;
	}

	public void setN_NUM(int n_NUM) {
		N_NUM = n_NUM;
	}

	@Override
	public String toString() {
		return "NovelCategorieDto [C_CATEGORIE_ID=" + C_CATEGORIE_ID + ", N_NUM=" + N_NUM + "]";
	}


	

	
}
