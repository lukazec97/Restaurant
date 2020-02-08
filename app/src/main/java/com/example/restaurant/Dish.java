package com.example.restaurant;

import org.json.JSONObject;

public class Dish {

    private String  naziv, tip;
    private boolean dostava;
    private int id, cena;

    public Dish() {

    }

    public Dish(int id,  String naziv, String tip, boolean dostava, int cena) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.dostava = dostava;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isDostava() {
        return dostava;
    }

    public void setDostava(boolean dostava) {
        this.dostava = dostava;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }


    public static Dish parseJSON(JSONObject object) {
        Dish dish = new Dish();

        try {
            if (object.has("id")) {
                dish.setId(object.getInt("id"));
            }
            if (object.has("naziv")) {
                dish.setNaziv(object.getString("naziv"));
            }
            if (object.has("tip")) {
                dish.setTip(object.getString("tip"));
            }
            if (object.has("dostava")) {
                dish.setDostava(object.getBoolean("dostava"));
            }
            if (object.has("cena")) {
                dish.setCena(object.getInt("cena"));
            }

        } catch (Exception e) {

        }

        return dish;
    }

}