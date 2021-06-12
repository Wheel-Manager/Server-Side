package com.example.wheelmanager.resource;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveCommentResource {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date publicationDate;

    @NotNull
    @Lob
    private String content;

    public Date getPublicationDate() {
        return publicationDate;
    }

    public SaveCommentResource setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SaveCommentResource setContent(String content) {
        this.content = content;
        return this;
    }
}
