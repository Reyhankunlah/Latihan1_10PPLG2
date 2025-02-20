package com.example.mobiledev;

public class ModelMakanan {
    private String namaMakanan;
    private String hargaMakanan;
    private int gambarMakanan;

    public ModelMakanan(String namaMakanan, String hargaMakanan, int gambarMakanan) {
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
        this.gambarMakanan = gambarMakanan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public int getGambarMakanan() {
        return gambarMakanan;
    }
}
