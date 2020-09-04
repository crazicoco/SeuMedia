package com.seumedia.demo01.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.sql.Clob;   // 如果context内容过大，考虑用clob替换java中的String类型

@Entity
public class Article_detail {
    @Id
    private long id;
    @Column
    private long article_id;
    @Column
    private long article_version;
    @Column
    private String title;
    @Column
    private long author_id;
    @Column
    private String abstracts;
    @Column
    private String keywords;
    @Column
    private String context;
    @Column
    private String source;
    @Column
    private String category;
    @Column
    private String subcategory;
    @Column
    private String topic;
    @Column
    private String copyright;
    @Column
    private String originality;
    @Column
    private byte idDeleted;

    public void setId(long id) {
        this.id = id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public void setArticle_version(long article_version) {
        this.article_version = article_version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setOriginality(String originality) {
        this.originality = originality;
    }

    public void setIdDeleted(byte idDeleted) {
        this.idDeleted = idDeleted;
    }

    public long getId() {
        return id;
    }

    public long getArticle_id() {
        return article_id;
    }

    public long getArticle_version() {
        return article_version;
    }

    public String getTitle() {
        return title;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getContext() {
        return context;
    }

    public String getSource() {
        return source;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getTopic() {
        return topic;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getOriginality() {
        return originality;
    }

    public byte getIdDeleted() {
        return idDeleted;
    }
}
