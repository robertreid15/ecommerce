package com.example.c15347186.e_commerce_app.reviews;

public class ReviewBuilder {
    private String review;
    private String itemTitle;
    private String userId;

    public ReviewBuilder setReview(String review) {
        this.review = review;
        return this;
    }

    public ReviewBuilder setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }

    public ReviewBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Review createReview() {
        return new Review(review, itemTitle, userId);
    }
}