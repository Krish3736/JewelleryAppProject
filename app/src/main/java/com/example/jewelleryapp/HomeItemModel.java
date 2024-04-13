package com.example.jewelleryapp;


public class HomeItemModel {
    int img,id;
    String name,price;

    public HomeItemModel(int img,String name,String price){
        this.img=img;
        this.name=name;
        this.price=price;
    }
    public HomeItemModel(int img,String name){
        this.img=img;
        this.name=name;
    }

}
