package com.example.exam612.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HomeBean {

    @Id(autoincrement = true)
    private Long cid;
    private String id;
    private String uid;
    private String name;
    private String title;
    private String excerpt;
    private String lead;
    private String model;
    private String position;
    private String thumbnail;
    private String create_time;
    private String update_time;
    private String status;
    private String video;
    private String fm;
    private String link_url;
    private String publish_time;
    private String view;
    private String share;
    private String comment;
    private String good;
    private String bookmark;
    private String show_uid;
    private String fm_play;
    private String lunar_type;
    private String html5;
    private String author;
    private int tpl;
    private String avatar;
    private String discover;
    private String category;
    private int parseXML;
    @Generated(hash = 1342507139)
    public HomeBean(Long cid, String id, String uid, String name, String title,
            String excerpt, String lead, String model, String position,
            String thumbnail, String create_time, String update_time, String status,
            String video, String fm, String link_url, String publish_time,
            String view, String share, String comment, String good, String bookmark,
            String show_uid, String fm_play, String lunar_type, String html5,
            String author, int tpl, String avatar, String discover, String category,
            int parseXML) {
        this.cid = cid;
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.title = title;
        this.excerpt = excerpt;
        this.lead = lead;
        this.model = model;
        this.position = position;
        this.thumbnail = thumbnail;
        this.create_time = create_time;
        this.update_time = update_time;
        this.status = status;
        this.video = video;
        this.fm = fm;
        this.link_url = link_url;
        this.publish_time = publish_time;
        this.view = view;
        this.share = share;
        this.comment = comment;
        this.good = good;
        this.bookmark = bookmark;
        this.show_uid = show_uid;
        this.fm_play = fm_play;
        this.lunar_type = lunar_type;
        this.html5 = html5;
        this.author = author;
        this.tpl = tpl;
        this.avatar = avatar;
        this.discover = discover;
        this.category = category;
        this.parseXML = parseXML;
    }
    @Generated(hash = 931577662)
    public HomeBean() {
    }
    public Long getCid() {
        return this.cid;
    }
    public void setCid(Long cid) {
        this.cid = cid;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUid() {
        return this.uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getExcerpt() {
        return this.excerpt;
    }
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }
    public String getLead() {
        return this.lead;
    }
    public void setLead(String lead) {
        this.lead = lead;
    }
    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getCreate_time() {
        return this.create_time;
    }
    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    public String getUpdate_time() {
        return this.update_time;
    }
    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getVideo() {
        return this.video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    public String getFm() {
        return this.fm;
    }
    public void setFm(String fm) {
        this.fm = fm;
    }
    public String getLink_url() {
        return this.link_url;
    }
    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }
    public String getPublish_time() {
        return this.publish_time;
    }
    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }
    public String getView() {
        return this.view;
    }
    public void setView(String view) {
        this.view = view;
    }
    public String getShare() {
        return this.share;
    }
    public void setShare(String share) {
        this.share = share;
    }
    public String getComment() {
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getGood() {
        return this.good;
    }
    public void setGood(String good) {
        this.good = good;
    }
    public String getBookmark() {
        return this.bookmark;
    }
    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }
    public String getShow_uid() {
        return this.show_uid;
    }
    public void setShow_uid(String show_uid) {
        this.show_uid = show_uid;
    }
    public String getFm_play() {
        return this.fm_play;
    }
    public void setFm_play(String fm_play) {
        this.fm_play = fm_play;
    }
    public String getLunar_type() {
        return this.lunar_type;
    }
    public void setLunar_type(String lunar_type) {
        this.lunar_type = lunar_type;
    }
    public String getHtml5() {
        return this.html5;
    }
    public void setHtml5(String html5) {
        this.html5 = html5;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getTpl() {
        return this.tpl;
    }
    public void setTpl(int tpl) {
        this.tpl = tpl;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getDiscover() {
        return this.discover;
    }
    public void setDiscover(String discover) {
        this.discover = discover;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getParseXML() {
        return this.parseXML;
    }
    public void setParseXML(int parseXML) {
        this.parseXML = parseXML;
    }
}
