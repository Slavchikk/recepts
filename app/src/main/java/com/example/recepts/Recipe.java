package com.example.recepts;


import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;

import android.os.Parcelable;

public class Recipe implements Parcelable {


    public Integer idRecipe;
    public String fullRecipe;
    public String nameRecipe;

    public String image;
    public String calory;
    public String timeGot;
    public Recipe(Integer idRecipe, String fullRecipe, String nameRecipe,String image,String calory,String timeGot) {
        this.idRecipe = idRecipe;
        this.fullRecipe = fullRecipe;
        this.nameRecipe = nameRecipe;
        this.calory = calory;
        this.timeGot = timeGot;
        this.image = image;
    }


    protected Recipe(Parcel in) {
        idRecipe = in.readInt();
        fullRecipe = in.readString();
        nameRecipe = in.readString();
        calory = in.readString();
        timeGot = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idRecipe);
        dest.writeString(fullRecipe);
        dest.writeString(nameRecipe);
        dest.writeString(calory);
        dest.writeString(timeGot);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getCalory() {return calory;}
    public String getTimeGot() {return timeGot;}

    public Integer getIdRecipe() {
        return idRecipe;
    }
    public  void setCalory(String calory) {this.calory = calory;}
    public  void setTimeGot(String timeGot) {this.timeGot = timeGot;}

    public void setIdRecipe(Integer idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getFullRecipe() {
        return fullRecipe;
    }

    public void setFullRecipe(String fullRecipe) {
        this.fullRecipe = fullRecipe;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}