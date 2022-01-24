package com.java.categorie.dto;

import java.util.List;

public class CategorieDto {
    private int c_categorie_id;
    private String c_categorie_name;

    private List<CategorieDto> categorieDtoList;

    public List<CategorieDto> getCategorieDtoList() {
        return categorieDtoList;
    }


    public int getC_categorie_id() {
        return c_categorie_id;
    }

    public void setC_categorie_id(int c_categorie_id) {
        this.c_categorie_id = c_categorie_id;
    }

    public String getC_categorie_name() {
        return c_categorie_name;
    }

    public void setC_categorie_name(String c_categorie_name) {
        this.c_categorie_name = c_categorie_name;
    }

    public void setCategorieDtoList(List<CategorieDto> categorieDtoList) {
        this.categorieDtoList = categorieDtoList;
    }

    @Override
    public String toString() {
        return "CategorieDto[" +
                "c_categorie_id=" + c_categorie_id +
                ", c_categorie_name='" + c_categorie_name  +
                ", categorieDtoList=" + categorieDtoList +
                ']';
    }
}
