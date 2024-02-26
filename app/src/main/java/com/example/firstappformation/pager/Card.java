package com.example.firstappformation.pager;

import androidx.annotation.NonNull;

public class Card {
    private int imageId;
    private double sold;
    private boolean visible;

    public Card(int imageId, double sold, boolean visible) {
        this.imageId = imageId;
        this.sold = sold;
        this.visible = visible;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void toggleVisibility() {
        this.visible = !this.visible;
    }
}
