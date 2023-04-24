package com.igeek.hbut.shixi.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Attention {
    
        private String mid;

        private String attention_id;

        private LocalDateTime create_time;

        private LocalDateTime update_time;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getAttention_id() {
        return attention_id;
    }

    public void setAttention_id(String attention_id) {
        this.attention_id = attention_id;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }
}
