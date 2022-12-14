package com.example.boutique;

public class Shoose {
    String shooseName;
    String shoosePrice;
    int shooseImage;
    String shooseDescription;
    public Shoose(String shooseName,String shoosePrice,int shooseImage,String shooseDescription){
        this.shooseName = shooseName;
        this.shoosePrice = shoosePrice;
        this.shooseImage = shooseImage;
        this.shooseDescription = shooseDescription;
    }
    public String getShooseName() {
        return shooseName;
    }

    public String getShoosePrice() {
        return shoosePrice;
    }

    public int getShooseImage() {
        return shooseImage;
    }

    public String getShooseDescription() { return shooseDescription; }
}
