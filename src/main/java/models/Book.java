package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;

public class Book {

    private Integer id;
    @Nullable
    private String title;
    @Nullable
    private String description;
    private Integer pageCount;
    @Nullable
    private String excerpt;
    private String publishDate;

    public Book() {
    }

    public Book(Integer id, @Nullable String title, @Nullable String description, Integer pageCount, @Nullable String excerpt, String publishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public Book(Integer id, Integer pageCount, String publishDate) {
        this.id = id;
        this.pageCount = pageCount;
        this.publishDate = publishDate;
    }

    public Book(@Nullable String title, @Nullable String description, Integer pageCount, @Nullable String excerpt, String publishDate) {
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }


    public Book(Integer id, @Nullable String title, @Nullable String description, @Nullable String excerpt, String publishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public Book(Integer id, @Nullable String title, @Nullable String description, Integer pageCount, @Nullable String excerpt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Nullable
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(@Nullable String description) {
        this.description = description;
    }


    @JsonProperty("pageCount")
    public Integer getPageCount() {
        return pageCount;
    }

    @JsonProperty("pageCount")
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Nullable
    @JsonProperty("excerpt")
    public String getExcerpt() {
        return excerpt;
    }

    @JsonProperty("excerpt")
    public void setExcerpt(@Nullable String excerpt) {
        this.excerpt = excerpt;
    }

    @JsonProperty("publishDate")
    public String getPublishDate() {
        return publishDate;
    }

    @JsonProperty("publishDate")
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

}
