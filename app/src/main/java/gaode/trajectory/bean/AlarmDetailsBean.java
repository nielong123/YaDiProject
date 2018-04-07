package gaode.trajectory.bean;

import java.util.List;

/**
 * Created by nielong123 on 2018/4/7.
 */

public class AlarmDetailsBean {

    /**
     * state : 0
     * msg : null
     * result : null
     * obj : {"content":[{"id":"353200001789_180407230232","mobile":"353200001789","alertCode":"001","alertEvent":"震动","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407230232","latitude":"123","longitude":"123","time":"180407230232","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407223708","mobile":"353200001789","alertCode":"001","alertEvent":"震动","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407223708","latitude":"123","longitude":"123","time":"180407223708","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407222541","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407222541","latitude":"123","longitude":"123","time":"180407222541","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407222535","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407222535","latitude":"123","longitude":"123","time":"180407222535","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407220028","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407220028","latitude":"123","longitude":"123","time":"180407220028","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407220008","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407220008","latitude":"123","longitude":"123","time":"180407220008","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407220004","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407220004","latitude":"123","longitude":"123","time":"180407220004","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407214622","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407214622","latitude":"123","longitude":"123","time":"180407214622","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407214033","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407214033","latitude":"123","longitude":"123","time":"180407214033","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407214015","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407214015","latitude":"123","longitude":"123","time":"180407214015","mapLng":null,"mapLat":null,"position":null,"region":null}],"last":false,"totalElements":54,"totalPages":6,"sort":null,"first":true,"numberOfElements":10,"size":10,"number":0}
     * filePre : http://180.101.253.139:30003/file/
     */

    private int state;
    private Object msg;
    private Object result;
    private ObjBean obj;
    private String filePre;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public String getFilePre() {
        return filePre;
    }

    public void setFilePre(String filePre) {
        this.filePre = filePre;
    }

    public static class ObjBean {
        /**
         * content : [{"id":"353200001789_180407230232","mobile":"353200001789","alertCode":"001","alertEvent":"震动","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407230232","latitude":"123","longitude":"123","time":"180407230232","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407223708","mobile":"353200001789","alertCode":"001","alertEvent":"震动","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407223708","latitude":"123","longitude":"123","time":"180407223708","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407222541","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407222541","latitude":"123","longitude":"123","time":"180407222541","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407222535","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407222535","latitude":"123","longitude":"123","time":"180407222535","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407220028","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407220028","latitude":"123","longitude":"123","time":"180407220028","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407220008","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407220008","latitude":"123","longitude":"123","time":"180407220008","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407220004","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407220004","latitude":"123","longitude":"123","time":"180407220004","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407214622","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407214622","latitude":"123","longitude":"123","time":"180407214622","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407214033","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407214033","latitude":"123","longitude":"123","time":"180407214033","mapLng":null,"mapLat":null,"position":null,"region":null},{"id":"353200001789_180407214015","mobile":"353200001789","alertCode":"001","alertEvent":"震动报警","alertEventDetail":null,"alertStartTimes":null,"alertLastTime":"180407214015","latitude":"123","longitude":"123","time":"180407214015","mapLng":null,"mapLat":null,"position":null,"region":null}]
         * last : false
         * totalElements : 54
         * totalPages : 6
         * sort : null
         * first : true
         * numberOfElements : 10
         * size : 10
         * number : 0
         */

        private boolean last;
        private int totalElements;
        private int totalPages;
        private Object sort;
        private boolean first;
        private int numberOfElements;
        private int size;
        private int number;
        private List<ContentBean> content;

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean {
            /**
             * id : 353200001789_180407230232
             * mobile : 353200001789
             * alertCode : 001
             * alertEvent : 震动
             * alertEventDetail : null
             * alertStartTimes : null
             * alertLastTime : 180407230232
             * latitude : 123
             * longitude : 123
             * time : 180407230232
             * mapLng : null
             * mapLat : null
             * position : null
             * region : null
             */

            private String id;
            private String mobile;
            private String alertCode;
            private String alertEvent;
            private Object alertEventDetail;
            private Object alertStartTimes;
            private String alertLastTime;
            private String latitude;
            private String longitude;
            private String time;
            private Object mapLng;
            private Object mapLat;
            private Object position;
            private Object region;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getAlertCode() {
                return alertCode;
            }

            public void setAlertCode(String alertCode) {
                this.alertCode = alertCode;
            }

            public String getAlertEvent() {
                return alertEvent;
            }

            public void setAlertEvent(String alertEvent) {
                this.alertEvent = alertEvent;
            }

            public Object getAlertEventDetail() {
                return alertEventDetail;
            }

            public void setAlertEventDetail(Object alertEventDetail) {
                this.alertEventDetail = alertEventDetail;
            }

            public Object getAlertStartTimes() {
                return alertStartTimes;
            }

            public void setAlertStartTimes(Object alertStartTimes) {
                this.alertStartTimes = alertStartTimes;
            }

            public String getAlertLastTime() {
                return alertLastTime;
            }

            public void setAlertLastTime(String alertLastTime) {
                this.alertLastTime = alertLastTime;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public Object getMapLng() {
                return mapLng;
            }

            public void setMapLng(Object mapLng) {
                this.mapLng = mapLng;
            }

            public Object getMapLat() {
                return mapLat;
            }

            public void setMapLat(Object mapLat) {
                this.mapLat = mapLat;
            }

            public Object getPosition() {
                return position;
            }

            public void setPosition(Object position) {
                this.position = position;
            }

            public Object getRegion() {
                return region;
            }

            public void setRegion(Object region) {
                this.region = region;
            }
        }
    }
}
