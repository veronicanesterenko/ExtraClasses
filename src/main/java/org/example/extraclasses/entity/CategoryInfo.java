package org.example.extraclasses.entity;

public class CategoryInfo {
    private int id;
    private String name;
    private int discount;
    private String alias;

    public CategoryInfo(int id, String name, int discount, String alias) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public String getAlias() {
        return alias;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
