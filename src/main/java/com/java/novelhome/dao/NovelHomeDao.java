package com.java.novelhome.dao;

import com.java.novelcategorie.dto.NovelCategorieDto;
import com.java.novelhome.dto.NovelHomeDto;

public interface NovelHomeDao {

	public int novelHomeUpload(NovelHomeDto novelHomeDto);

	public int novelHomeCategorie(NovelCategorieDto novelCategorieDto);

}
