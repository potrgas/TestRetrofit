package com.example.testretrofit;

import java.io.Serializable;
import java.util.List;

public class Person extends BaseEntity implements Serializable{

    /**
     * href :
     * id : 11
     * remark :
     * status : 1
     * title :
     * type : PC
     * url : http://efile.autoimg.cn/g13/M0A/D9/CF/wKgH41ZBnHaAGZu_AAGRDZKdTtA384.jpg
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String href;
        private int id;
        private String remark;
        private int status;
        private String title;
        private String type;
        private String url;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
