package br.com.buylist.models;

import java.util.Date;

/**
 * Created by Igor on 29/04/2016.
 */
public class List {

    private String id;
    private String name;
    private String description;
    private String author;
    private Date createDate;
    private Boolean isPublic;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setIsDraft(Boolean isDraft) {
        this.isDraft = isDraft;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public Boolean getIsDraft() {
        return isDraft;
    }

    private Boolean isDraft;
}
