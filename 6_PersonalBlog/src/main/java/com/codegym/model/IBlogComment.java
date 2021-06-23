package com.codegym.model;

import java.util.Date;

public interface IBlogComment {
    Long getId();
    String getContent();
    Date getDate();
    String getTitle();
    int getLikes();
    Long getCategoryId();
    String getImage();
    String getCategoryName();
    Integer getCommentCount();
}
