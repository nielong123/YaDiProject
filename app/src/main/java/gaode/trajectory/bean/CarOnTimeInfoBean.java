package gaode.trajectory.bean;

import java.util.List;

/**
 * Created by nielong123 on 2018/4/5.
 */

public class CarOnTimeInfoBean {

    /**
     * state : 0
     * msg : null
     * result : null
     * obj : {"code":0,"error":"","msg":"成功","detail":[{"devNo":"013511112222","latLng":{"lat":"22.672105","lng":"114.034669"},"mapLatLng":{"lat":"22.669338","lng":"114.039728","baiduLat":"22.675187","baiduLng":"114.046277"},"poi":"广东省;深圳市;宝安区|优鼎金属有限公司","gpsStamp":"180406164820","direction":"0","speed":0,"status":{"accStatus":"1","isLocation":"1","sourthOrNorthLatitude":"0","eastOrWestLongtitude":"0","vehicleElectricStatus":"0","vehicleOilStatus":"0","vehicleDoorStatus":"0","mileage":38908748,"emergencyAlert":"0","overSpeed":"0","parkingTimeout":"0","powerUnderVoltage":"0","mainPowerOff":"0","vehicleStatus":"停车"}}],"retain":"1"}
     * filePre : http://180.101.253.139:30003/file/
     */

    private String state;
    private String msg;
    private String result;
    private ObjBean obj;
    private String filePre;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
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
         * code : 0
         * error :
         * msg : 成功
         * detail : [{"devNo":"013511112222","latLng":{"lat":"22.672105","lng":"114.034669"},"mapLatLng":{"lat":"22.669338","lng":"114.039728","baiduLat":"22.675187","baiduLng":"114.046277"},"poi":"广东省;深圳市;宝安区|优鼎金属有限公司","gpsStamp":"180406164820","direction":"0","speed":0,"status":{"accStatus":"1","isLocation":"1","sourthOrNorthLatitude":"0","eastOrWestLongtitude":"0","vehicleElectricStatus":"0","vehicleOilStatus":"0","vehicleDoorStatus":"0","mileage":38908748,"emergencyAlert":"0","overSpeed":"0","parkingTimeout":"0","powerUnderVoltage":"0","mainPowerOff":"0","vehicleStatus":"停车"}}]
         * retain : 1
         */

        private String code;
        private String error;
        private String msg;
        private String retain;
        private List<DetailBean> detail;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getRetain() {
            return retain;
        }

        public void setRetain(String retain) {
            this.retain = retain;
        }

        public List<DetailBean> getDetail() {
            return detail;
        }

        public void setDetail(List<DetailBean> detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * devNo : 013511112222
             * latLng : {"lat":"22.672105","lng":"114.034669"}
             * mapLatLng : {"lat":"22.669338","lng":"114.039728","baiduLat":"22.675187","baiduLng":"114.046277"}
             * poi : 广东省;深圳市;宝安区|优鼎金属有限公司
             * gpsStamp : 180406164820
             * direction : 0
             * speed : 0
             * status : {"accStatus":"1","isLocation":"1","sourthOrNorthLatitude":"0","eastOrWestLongtitude":"0","vehicleElectricStatus":"0","vehicleOilStatus":"0","vehicleDoorStatus":"0","mileage":38908748,"emergencyAlert":"0","overSpeed":"0","parkingTimeout":"0","powerUnderVoltage":"0","mainPowerOff":"0","vehicleStatus":"停车"}
             */

            private String devNo;
            private LatLngBean latLng;
            private MapLatLngBean mapLatLng;
            private String poi;
            private String gpsStamp;
            private String direction;
            private String speed;
            private StatusBean status;

            public String getDevNo() {
                return devNo;
            }

            public void setDevNo(String devNo) {
                this.devNo = devNo;
            }

            public LatLngBean getLatLng() {
                return latLng;
            }

            public void setLatLng(LatLngBean latLng) {
                this.latLng = latLng;
            }

            public MapLatLngBean getMapLatLng() {
                return mapLatLng;
            }

            public void setMapLatLng(MapLatLngBean mapLatLng) {
                this.mapLatLng = mapLatLng;
            }

            public String getPoi() {
                return poi;
            }

            public void setPoi(String poi) {
                this.poi = poi;
            }

            public String getGpsStamp() {
                return gpsStamp;
            }

            public void setGpsStamp(String gpsStamp) {
                this.gpsStamp = gpsStamp;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getSpeed() {
                return speed;
            }

            public void setSpeed(String speed) {
                this.speed = speed;
            }

            public StatusBean getStatus() {
                return status;
            }

            public void setStatus(StatusBean status) {
                this.status = status;
            }

            public static class LatLngBean {
                /**
                 * lat : 22.672105
                 * lng : 114.034669
                 */

                private String lat;
                private String lng;

                public String getLat() {
                    return lat;
                }

                public void setLat(String lat) {
                    this.lat = lat;
                }

                public String getLng() {
                    return lng;
                }

                public void setLng(String lng) {
                    this.lng = lng;
                }
            }

            public static class MapLatLngBean {
                /**
                 * lat : 22.669338
                 * lng : 114.039728
                 * baiduLat : 22.675187
                 * baiduLng : 114.046277
                 */

                private String lat;
                private String lng;
                private String baiduLat;
                private String baiduLng;

                public String getLat() {
                    return lat;
                }

                public void setLat(String lat) {
                    this.lat = lat;
                }

                public String getLng() {
                    return lng;
                }

                public void setLng(String lng) {
                    this.lng = lng;
                }

                public String getBaiduLat() {
                    return baiduLat;
                }

                public void setBaiduLat(String baiduLat) {
                    this.baiduLat = baiduLat;
                }

                public String getBaiduLng() {
                    return baiduLng;
                }

                public void setBaiduLng(String baiduLng) {
                    this.baiduLng = baiduLng;
                }
            }

            public static class StatusBean {
                /**
                 * accStatus : 1
                 * isLocation : 1
                 * sourthOrNorthLatitude : 0
                 * eastOrWestLongtitude : 0
                 * vehicleElectricStatus : 0
                 * vehicleOilStatus : 0
                 * vehicleDoorStatus : 0
                 * mileage : 38908748
                 * emergencyAlert : 0
                 * overSpeed : 0
                 * parkingTimeout : 0
                 * powerUnderVoltage : 0
                 * mainPowerOff : 0
                 * vehicleStatus : 停车
                 */

                private String accStatus;
                private String isLocation;
                private String sourthOrNorthLatitude;
                private String eastOrWestLongtitude;
                private String vehicleElectricStatus;
                private String vehicleOilStatus;
                private String vehicleDoorStatus;
                private String mileage;
                private String emergencyAlert;
                private String overSpeed;
                private String parkingTimeout;
                private String powerUnderVoltage;
                private String mainPowerOff;
                private String vehicleStatus;

                public String getAccStatus() {
                    return accStatus;
                }

                public void setAccStatus(String accStatus) {
                    this.accStatus = accStatus;
                }

                public String getIsLocation() {
                    return isLocation;
                }

                public void setIsLocation(String isLocation) {
                    this.isLocation = isLocation;
                }

                public String getSourthOrNorthLatitude() {
                    return sourthOrNorthLatitude;
                }

                public void setSourthOrNorthLatitude(String sourthOrNorthLatitude) {
                    this.sourthOrNorthLatitude = sourthOrNorthLatitude;
                }

                public String getEastOrWestLongtitude() {
                    return eastOrWestLongtitude;
                }

                public void setEastOrWestLongtitude(String eastOrWestLongtitude) {
                    this.eastOrWestLongtitude = eastOrWestLongtitude;
                }

                public String getVehicleElectricStatus() {
                    return vehicleElectricStatus;
                }

                public void setVehicleElectricStatus(String vehicleElectricStatus) {
                    this.vehicleElectricStatus = vehicleElectricStatus;
                }

                public String getVehicleOilStatus() {
                    return vehicleOilStatus;
                }

                public void setVehicleOilStatus(String vehicleOilStatus) {
                    this.vehicleOilStatus = vehicleOilStatus;
                }

                public String getVehicleDoorStatus() {
                    return vehicleDoorStatus;
                }

                public void setVehicleDoorStatus(String vehicleDoorStatus) {
                    this.vehicleDoorStatus = vehicleDoorStatus;
                }

                public String getMileage() {
                    return mileage;
                }

                public void setMileage(String mileage) {
                    this.mileage = mileage;
                }

                public String getEmergencyAlert() {
                    return emergencyAlert;
                }

                public void setEmergencyAlert(String emergencyAlert) {
                    this.emergencyAlert = emergencyAlert;
                }

                public String getOverSpeed() {
                    return overSpeed;
                }

                public void setOverSpeed(String overSpeed) {
                    this.overSpeed = overSpeed;
                }

                public String getParkingTimeout() {
                    return parkingTimeout;
                }

                public void setParkingTimeout(String parkingTimeout) {
                    this.parkingTimeout = parkingTimeout;
                }

                public String getPowerUnderVoltage() {
                    return powerUnderVoltage;
                }

                public void setPowerUnderVoltage(String powerUnderVoltage) {
                    this.powerUnderVoltage = powerUnderVoltage;
                }

                public String getMainPowerOff() {
                    return mainPowerOff;
                }

                public void setMainPowerOff(String mainPowerOff) {
                    this.mainPowerOff = mainPowerOff;
                }

                public String getVehicleStatus() {
                    return vehicleStatus;
                }

                public void setVehicleStatus(String vehicleStatus) {
                    this.vehicleStatus = vehicleStatus;
                }
            }
        }
    }
}
