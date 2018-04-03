package gaode.trajectory.bean;

import java.util.List;

/**
 * Created by nielong123 on 2018/4/3.
 */

public class AlarmDetailBean {

    /**
     * state : 0
     * msg : null
     * result : null
     * obj : {"content":[{"id":"5a96d013e4b089828c741afd","mobile":"015702707901","alertCode":"4","alertEvent":"超速","alertStartTimes":"180228235930","alertLastTime":"0","latitude":"22.686966","longitude":"114.006048","time":"180301000008","mapLng":"114.011037","mapLat":"22.684110","position":"深圳市仙松实业有限公司","region":"广东省;深圳市;宝安区"},{"id":"5a96cff2e4b089828c741aed","mobile":"015702700090","alertCode":"4","alertEvent":"超速","alertStartTimes":"180228235858","alertLastTime":"1","latitude":"22.958634","longitude":"114.0698","time":"180301000054","mapLng":"114.074934","mapLat":"22.956031","position":"朗州村","region":"广东省;东莞市;东莞市"},{"id":"5a96d0a0e4b0d27e9f7ac576","mobile":"015702700568","alertCode":"4","alertEvent":"超速","alertStartTimes":"180228235940","alertLastTime":"1","latitude":"23.137284","longitude":"113.544112","time":"180301000058","mapLng":"113.549299","mapLat":"23.134512","position":"广州兴攀金属加工公司","region":"广东省;广州市;黄埔区"},{"id":"5a96d0fce4b0d27e9f7ac5d1","mobile":"015702709737","alertCode":"4","alertEvent":"超速","alertStartTimes":"180301000111","alertLastTime":"0","latitude":"22.586566","longitude":"113.9864","time":"180301000111","mapLng":"113.991330","mapLat":"22.583634","position":"大学城出口","region":"广东省;深圳市;南山区"},{"id":"5a96b802e4b0d27e9f7aa83a","mobile":"015702707384","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228221438","alertLastTime":"106","latitude":"37.139352","longitude":"114.679184","time":"180301000127","mapLng":"114.684940","mapLat":"37.139780","position":"加油站","region":"河北省;邢台市;任县"},{"id":"5a96aaf4e4b089828c73f72c","mobile":"015702700969","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228212107","alertLastTime":"160","latitude":"23.182416","longitude":"114.112136","time":"180301000130","mapLng":"114.117291","mapLat":"23.179950","position":"TCL柳良希望小学","region":"广东省;惠州市;博罗县"},{"id":"5a96cac5e4b089828c74172c","mobile":"015702700788","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228233653","alertLastTime":"24","latitude":"22.72495","longitude":"113.891616","time":"180301000134","mapLng":"113.896508","mapLat":"22.721941","position":"UNIEAC","region":"广东省;深圳市;宝安区"},{"id":"5a96d0e9e4b0d27e9f7ac5bf","mobile":"015702711378","alertCode":"4","alertEvent":"超速","alertStartTimes":"180301000053","alertLastTime":"1","latitude":"22.6439","longitude":"114.151072","time":"180301000204","mapLng":"114.156120","mapLat":"22.641197","position":"丹平快速出口","region":"广东省;深圳市;龙岗区"},{"id":"5a96d0dfe4b089828c741b74","mobile":"015702700090","alertCode":"4","alertEvent":"超速","alertStartTimes":"180301000254","alertLastTime":"0","latitude":"22.9555","longitude":"114.0438","time":"180301000304","mapLng":"114.048902","mapLat":"22.952852","position":"东莞东收费站","region":"广东省;东莞市;东莞市"},{"id":"5a96a7fce4b089828c73f361","mobile":"015702700891","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228210827","alertLastTime":"174","latitude":"22.957582","longitude":"113.912328","time":"180301000323","mapLng":"113.917215","mapLat":"22.954652","position":"东莞大朗盈纺制衣厂","region":"广东省;东莞市;东莞市"},{"id":"5a96bb2de4b0d27e9f7aabec","mobile":"015702705655","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228222809","alertLastTime":"95","latitude":"34.408368","longitude":"109.02948","time":"180301000329","mapLng":"109.034431","mapLat":"34.407053","position":"上乾村","region":"陕西省;西安市;灞桥区"},{"id":"5a96a21ce4b089828c73ebd2","mobile":"015702701827","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228204323","alertLastTime":"200","latitude":"22.643882","longitude":"114.2","time":"180301000358","mapLng":"114.204914","mapLat":"22.641085","position":"华丽金泉五金制品厂","region":"广东省;深圳市;龙岗区"},{"id":"5a96a344e4b0d27e9f7a8712","mobile":"015702706829","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228204608","alertLastTime":"197","latitude":"22.465166","longitude":"113.53844","time":"180301000358","mapLng":"113.543617","mapLat":"22.462226","position":"入口","region":"广东省;中山市;中山市"},{"id":"5a96d095e4b0d27e9f7ac55c","mobile":"015702709611","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228235928","alertLastTime":"4","latitude":"22.733","longitude":"113.903296","time":"180301000408","mapLng":"113.908177","mapLat":"22.729987","position":"田寮村(公明)","region":"广东省;深圳市;宝安区"},{"id":"5a96ac2be4b0d27e9f7a95cb","mobile":"015702713480","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228212406","alertLastTime":"160","latitude":"31.755016","longitude":"117.331848","time":"180301000451","mapLng":"117.337448","mapLat":"31.753109","position":"大陈村","region":"安徽省;合肥市;包河区"}],"last":false,"totalElements":140810,"totalPages":9388,"sort":null,"first":true,"numberOfElements":15,"size":15,"number":0}
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
         * content : [{"id":"5a96d013e4b089828c741afd","mobile":"015702707901","alertCode":"4","alertEvent":"超速","alertStartTimes":"180228235930","alertLastTime":"0","latitude":"22.686966","longitude":"114.006048","time":"180301000008","mapLng":"114.011037","mapLat":"22.684110","position":"深圳市仙松实业有限公司","region":"广东省;深圳市;宝安区"},{"id":"5a96cff2e4b089828c741aed","mobile":"015702700090","alertCode":"4","alertEvent":"超速","alertStartTimes":"180228235858","alertLastTime":"1","latitude":"22.958634","longitude":"114.0698","time":"180301000054","mapLng":"114.074934","mapLat":"22.956031","position":"朗州村","region":"广东省;东莞市;东莞市"},{"id":"5a96d0a0e4b0d27e9f7ac576","mobile":"015702700568","alertCode":"4","alertEvent":"超速","alertStartTimes":"180228235940","alertLastTime":"1","latitude":"23.137284","longitude":"113.544112","time":"180301000058","mapLng":"113.549299","mapLat":"23.134512","position":"广州兴攀金属加工公司","region":"广东省;广州市;黄埔区"},{"id":"5a96d0fce4b0d27e9f7ac5d1","mobile":"015702709737","alertCode":"4","alertEvent":"超速","alertStartTimes":"180301000111","alertLastTime":"0","latitude":"22.586566","longitude":"113.9864","time":"180301000111","mapLng":"113.991330","mapLat":"22.583634","position":"大学城出口","region":"广东省;深圳市;南山区"},{"id":"5a96b802e4b0d27e9f7aa83a","mobile":"015702707384","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228221438","alertLastTime":"106","latitude":"37.139352","longitude":"114.679184","time":"180301000127","mapLng":"114.684940","mapLat":"37.139780","position":"加油站","region":"河北省;邢台市;任县"},{"id":"5a96aaf4e4b089828c73f72c","mobile":"015702700969","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228212107","alertLastTime":"160","latitude":"23.182416","longitude":"114.112136","time":"180301000130","mapLng":"114.117291","mapLat":"23.179950","position":"TCL柳良希望小学","region":"广东省;惠州市;博罗县"},{"id":"5a96cac5e4b089828c74172c","mobile":"015702700788","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228233653","alertLastTime":"24","latitude":"22.72495","longitude":"113.891616","time":"180301000134","mapLng":"113.896508","mapLat":"22.721941","position":"UNIEAC","region":"广东省;深圳市;宝安区"},{"id":"5a96d0e9e4b0d27e9f7ac5bf","mobile":"015702711378","alertCode":"4","alertEvent":"超速","alertStartTimes":"180301000053","alertLastTime":"1","latitude":"22.6439","longitude":"114.151072","time":"180301000204","mapLng":"114.156120","mapLat":"22.641197","position":"丹平快速出口","region":"广东省;深圳市;龙岗区"},{"id":"5a96d0dfe4b089828c741b74","mobile":"015702700090","alertCode":"4","alertEvent":"超速","alertStartTimes":"180301000254","alertLastTime":"0","latitude":"22.9555","longitude":"114.0438","time":"180301000304","mapLng":"114.048902","mapLat":"22.952852","position":"东莞东收费站","region":"广东省;东莞市;东莞市"},{"id":"5a96a7fce4b089828c73f361","mobile":"015702700891","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228210827","alertLastTime":"174","latitude":"22.957582","longitude":"113.912328","time":"180301000323","mapLng":"113.917215","mapLat":"22.954652","position":"东莞大朗盈纺制衣厂","region":"广东省;东莞市;东莞市"},{"id":"5a96bb2de4b0d27e9f7aabec","mobile":"015702705655","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228222809","alertLastTime":"95","latitude":"34.408368","longitude":"109.02948","time":"180301000329","mapLng":"109.034431","mapLat":"34.407053","position":"上乾村","region":"陕西省;西安市;灞桥区"},{"id":"5a96a21ce4b089828c73ebd2","mobile":"015702701827","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228204323","alertLastTime":"200","latitude":"22.643882","longitude":"114.2","time":"180301000358","mapLng":"114.204914","mapLat":"22.641085","position":"华丽金泉五金制品厂","region":"广东省;深圳市;龙岗区"},{"id":"5a96a344e4b0d27e9f7a8712","mobile":"015702706829","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228204608","alertLastTime":"197","latitude":"22.465166","longitude":"113.53844","time":"180301000358","mapLng":"113.543617","mapLat":"22.462226","position":"入口","region":"广东省;中山市;中山市"},{"id":"5a96d095e4b0d27e9f7ac55c","mobile":"015702709611","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228235928","alertLastTime":"4","latitude":"22.733","longitude":"113.903296","time":"180301000408","mapLng":"113.908177","mapLat":"22.729987","position":"田寮村(公明)","region":"广东省;深圳市;宝安区"},{"id":"5a96ac2be4b0d27e9f7a95cb","mobile":"015702713480","alertCode":"2","alertEvent":"断电","alertStartTimes":"180228212406","alertLastTime":"160","latitude":"31.755016","longitude":"117.331848","time":"180301000451","mapLng":"117.337448","mapLat":"31.753109","position":"大陈村","region":"安徽省;合肥市;包河区"}]
         * last : false
         * totalElements : 140810
         * totalPages : 9388
         * sort : null
         * first : true
         * numberOfElements : 15
         * size : 15
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
             * id : 5a96d013e4b089828c741afd
             * mobile : 015702707901
             * alertCode : 4
             * alertEvent : 超速
             * alertStartTimes : 180228235930
             * alertLastTime : 0
             * latitude : 22.686966
             * longitude : 114.006048
             * time : 180301000008
             * mapLng : 114.011037
             * mapLat : 22.684110
             * position : 深圳市仙松实业有限公司
             * region : 广东省;深圳市;宝安区
             */

            private String id;
            private String mobile;
            private String alertCode;
            private String alertEvent;
            private String alertStartTimes;
            private String alertLastTime;
            private String latitude;
            private String longitude;
            private String time;
            private String mapLng;
            private String mapLat;
            private String position;
            private String region;

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

            public String getAlertStartTimes() {
                return alertStartTimes;
            }

            public void setAlertStartTimes(String alertStartTimes) {
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

            public String getMapLng() {
                return mapLng;
            }

            public void setMapLng(String mapLng) {
                this.mapLng = mapLng;
            }

            public String getMapLat() {
                return mapLat;
            }

            public void setMapLat(String mapLat) {
                this.mapLat = mapLat;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }
        }
    }
}
