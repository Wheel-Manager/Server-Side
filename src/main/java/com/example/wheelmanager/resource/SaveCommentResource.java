package com.example.wheelmanager.resource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveCommentResource {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date publicationDate;

    @NotNull
    @Lob
    private String content;



}