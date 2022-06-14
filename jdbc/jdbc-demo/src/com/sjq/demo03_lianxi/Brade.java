package com.sjq.demo03_lianxi;

public class Brade {
    private Integer id;
    private String brandName;
    private  String compyName;
    private Integer ordered;
    private String description;
    private Integer status;

    @Override
    public String toString() {
        return "Brade{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", compyName='" + compyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompyName() {
        return compyName;
    }

    public void setCompyName(String compyName) {
        this.compyName = compyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Brade(Integer id, String brandName, String compyName, Integer ordered, String description, Integer status) {
        this.id = id;
        this.brandName = brandName;
        this.compyName = compyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    public Brade() {
    }
}
