package com.example.trianingdemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HomeBean {

    @Id
    private long id;
    private String img;
    private String title;
    private String name;
    private boolean attention;
    @Generated(hash = 1397670716)
    public HomeBean(long id, String img, String title, String name,
            boolean attention) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.name = name;
        this.attention = attention;
    }
    @Generated(hash = 931577662)
    public HomeBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getAttention() {
        return this.attention;
    }
    public void setAttention(boolean attention) {
        this.attention = attention;
    }


}
