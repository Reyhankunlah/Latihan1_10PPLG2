package com.example.mobiledev;

public class ModelMakanan {
    private String namaMakanan;
    private String hargaMakanan;
    private String deskripsiMakanan;
    private String detailMakanan;
    private int gambarMakanan;

    public ModelMakanan(String namaMakanan, String hargaMakanan, String deskripsiMakanan, String detailMakanan, int gambarMakanan) {
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
        this.gambarMakanan = gambarMakanan;
        this.deskripsiMakanan = deskripsiMakanan;
        this.detailMakanan = detailMakanan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public String getDeskripsiMakanan() {
        return deskripsiMakanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public String getDetailMakanan(){
        return detailMakanan;
    }

    public int getGambarMakanan() {
        return gambarMakanan;
    }
}
