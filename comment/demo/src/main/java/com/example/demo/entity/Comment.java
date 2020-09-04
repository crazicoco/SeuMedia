package com.example.demo.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:56
 */
public class Comment {
    private BigInteger id;
    private String content;
    private BigInteger author_id;
    private String ip;
    private String create_by;
    private String modified_by;
    private int is_effect;
    private int idDeleted;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigInteger getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(BigInteger author_id) {
        this.author_id = author_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public int getIs_effect() {
        return is_effect;
    }

    public void setIs_effect(int is_effect) {
        this.is_effect = is_effect;
    }

    public int getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(int idDeleted) {
        this.idDeleted = idDeleted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author_id=" + author_id +
                ", ip='" + ip + '\'' +
                ", create_by=" + create_by +
                ", modified_by=" + modified_by +
                ", is_effect=" + is_effect +
                ", idDeleted=" + idDeleted +
                '}';
    }
}
