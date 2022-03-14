package com.example.fitvita20;

public class Model {
    String food_name, gramaj, calorii, proteine, carbs, fat;

    public Model() {
    }

    public Model(String name, String serving, String calories, String protein, String carbs, String fat) {
        this.food_name = name;
        this.gramaj = serving;
        this.calorii = calories;
        this.proteine = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Model{" +
                "food_name='" + food_name + '\'' +
                ", gramaj='" + gramaj + '\'' +
                ", calorii='" + calorii + '\'' +
                ", proteine='" + proteine + '\'' +
                ", carbs='" + carbs + '\'' +
                ", fat='" + fat + '\'' +
                '}';
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getGramaj() {
        return gramaj;
    }

    public void setGramaj(String gramaj) {
        this.gramaj = gramaj;
    }

    public String getCalorii() {
        return calorii;
    }

    public void setCalorii(String calorii) {
        this.calorii = calorii;
    }

    public String getProteine() {
        return proteine;
    }

    public void setProteine(String proteine) {
        this.proteine = proteine;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarbs() {
        return carbs;
    }

    public String getFat() {
        return fat;
    }
}
