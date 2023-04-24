package com.igeek.hbut.shixi.entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class Comment {
    private Long rpid;

    private String oid;

    private String mid;

    private String root;

    private String content;

    private LocalDateTime ctime;

    private String like;

    private String floor;

    private String rcount;

    private LocalDateTime create_time;

    private LocalDateTime update_time;

    public Long getRpid() {
        return rpid;
    }

    public void setRpid(Long rpid) {
        this.rpid = rpid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRcount() {
        return rcount;
    }

    public void setRcount(String rcount) {
        this.rcount = rcount;
    }

    public LocalDateTime getCreate_time() {
    	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	//System.out.println(formatter.format(local));
        return create_time;
    }

    public void setCreate_time(LocalDateTime now) {
        this.create_time = now;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }
}