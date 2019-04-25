package com.example.c15347186.e_commerce_app.reviews;

public class Review {

    public String review;
    public String itemTitle;
    public String userId;

    public Review(){

    }

    public Review(String review, String itemTitle, String userId) {
        this.review = review;
        this.itemTitle = itemTitle;
        this.userId = userId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
