package com.example.imlogin.bean;

import java.util.List;

public class DailyBean {

    /**
     * date : 20200615
     * stories : [{"image_hue":"0x48809e","title":"矿泉水的甜味是从哪来的？","url":"https://daily.zhihu.com/story/9724906","hint":"陈可乐 · 2 分钟阅读","ga_prefix":"061507","images":["https://pic3.zhimg.com/v2-28353e9cbabe0966e65cc62273ce9536.jpg"],"type":0,"id":9724906},{"image_hue":"0xb3897d","title":"蚊子为什么能上 32 层楼？","url":"https://daily.zhihu.com/story/9724915","hint":"苏澄宇 · 3 分钟阅读","ga_prefix":"061507","images":["https://pic4.zhimg.com/v2-30b4e83de4ff73015c5aadec76b0dc03.jpg"],"type":0,"id":9724915},{"image_hue":"0x050505","title":"年龄对男女生育能力的影响分别有多大？","url":"https://daily.zhihu.com/story/9724883","hint":"鹿辞鑫 · 3 分钟阅读","ga_prefix":"061507","images":["https://pic4.zhimg.com/v2-ddbe43eb4804eefeade7ef66ed877b1f.jpg"],"type":0,"id":9724883},{"image_hue":"0xb38779","title":"皮肤的角质层是什么？","url":"https://daily.zhihu.com/story/9724920","hint":"言雨潇 · 5 分钟阅读","ga_prefix":"061507","images":["https://pic4.zhimg.com/v2-f338c2495bb0886a3b830422436101cb.jpg"],"type":0,"id":9724920},{"image_hue":"0x1b180e","title":"有哪些角色让你意想不到居然是同一位演员饰演？","url":"https://daily.zhihu.com/story/9724922","hint":"向天歌 · 5 分钟阅读","ga_prefix":"061507","images":["https://pic3.zhimg.com/v2-f07cdce935eee0ea44dd82ff5375a42a.jpg"],"type":0,"id":9724922},{"image_hue":"0xb39d7d","title":"瞎扯 · 如何正确地吐槽","url":"https://daily.zhihu.com/story/9724805","hint":"VOL.2419","ga_prefix":"061506","images":["https://pic4.zhimg.com/v2-0e402b49234af4a7989f86d62135cd97.jpg"],"type":0,"id":9724805}]
     * top_stories : [{"image_hue":"0x2b373d","hint":"作者 / 一路春暖月圆","url":"https://daily.zhihu.com/story/9724896","image":"https://pic4.zhimg.com/v2-b3e72e59d6816c74ebb9d477c6e27b3b.jpg","title":"神奇动物在这里","ga_prefix":"061407","type":0,"id":9724896},{"image_hue":"0x344a3a","hint":"作者 / myosin myosin","url":"https://daily.zhihu.com/story/9724859","image":"https://pic1.zhimg.com/v2-03ddf071df9b58374797f4eb387be1f0.jpg","title":"年轻人很早洞察人事、谙于世故预示着本性平庸吗？","ga_prefix":"061307","type":0,"id":9724859},{"image_hue":"0x212f40","hint":"作者 / 黄Isabel","url":"https://daily.zhihu.com/story/9724809","image":"https://pic4.zhimg.com/v2-ebcd2881f09f31342b91f2f68fb3c2ff.jpg","title":"美学是什么？有什么用？","ga_prefix":"061207","type":0,"id":9724809},{"image_hue":"0xb3857d","hint":"作者 / 苗华栋","url":"https://daily.zhihu.com/story/9724781","image":"https://pic3.zhimg.com/v2-f04d87e0735140857e2da22f99fcb4de.jpg","title":"1000 桶水中 1 桶有毒，猪喝毒水会死，想找到这桶毒水需要几头猪？","ga_prefix":"061107","type":0,"id":9724781},{"image_hue":"0xb39256","hint":"作者 / 二氧化硅","url":"https://daily.zhihu.com/story/9724725","image":"https://pic1.zhimg.com/v2-b850e8e6e33ad7f6ef7879fe92dff554.jpg","title":"纯棉的衣服既不天然，也不环保","ga_prefix":"061007","type":0,"id":9724725}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * image_hue : 0x48809e
         * title : 矿泉水的甜味是从哪来的？
         * url : https://daily.zhihu.com/story/9724906
         * hint : 陈可乐 · 2 分钟阅读
         * ga_prefix : 061507
         * images : ["https://pic3.zhimg.com/v2-28353e9cbabe0966e65cc62273ce9536.jpg"]
         * type : 0
         * id : 9724906
         */

        private String image_hue;
        private String title;
        private String url;
        private String hint;
        private String ga_prefix;
        private int type;
        private int id;
        private List<String> images;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image_hue : 0x2b373d
         * hint : 作者 / 一路春暖月圆
         * url : https://daily.zhihu.com/story/9724896
         * image : https://pic4.zhimg.com/v2-b3e72e59d6816c74ebb9d477c6e27b3b.jpg
         * title : 神奇动物在这里
         * ga_prefix : 061407
         * type : 0
         * id : 9724896
         */

        private String image_hue;
        private String hint;
        private String url;
        private String image;
        private String title;
        private String ga_prefix;
        private int type;
        private int id;

        public String getImage_hue() {
            return image_hue;
        }

        public void setImage_hue(String image_hue) {
            this.image_hue = image_hue;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
