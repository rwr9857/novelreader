package com.java.category.dto;


public class CategoryDto {
    private int c_category_id;
    private String c_category_name;

    public int getC_category_id() {
        return c_category_id;
    }

    public void setC_category_id(int c_category_id) {
        this.c_category_id = c_category_id;
    }

    public String getC_category_name() {
        return c_category_name;
    }

    public void setC_category_name(String c_category_name) {
        this.c_category_name = c_category_name;
    }

    @Override
    public String toString() {
        return "CategoryDto[" +
                "c_category_id=" + c_category_id +
                ", c_category_name='" + c_category_name +
                ']';
    }
}
