package com.spakova19.booktracker.dto;

public class CreateBookRequest {
    private String title;

    private int numberOfPages;

    private String isbn;

    private Long authorId;

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
