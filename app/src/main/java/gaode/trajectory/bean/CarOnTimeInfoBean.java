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
     * obj : [{"id":34365,"createDate":"2018-04-04 10:10:54","modifyDate":"2018-04-04 10:10:57","createUserId":null,"modifyUserId":null,"devNO":"013511112222","devType":0,"devModel":null,"devStatus":null,"sim":"1231231232131","svrNo":"1231232133312","snNo":null,"protocolType":null,"version":null,"proDate":null,"svrPhone":null,"manufacturer":null,"inDate":"2018-04-04 10:11:04","deleteState":false,"car":{"id":21202,"createDate":"2018-04-04 10:12:41","modifyDate":"2018-04-04 10:12:44","createUserId":null,"modifyUserId":null,"carNum":null,"plateNum":"粤B77777","carName":"X-新战警60C","frameNum":null,"engineNum":"TM4015BJ2015NS1021","carModel":"EQ5070XXYTBEV3","carType":"X-新战警60C","carUseIn":1,"submit":null,"dataSubmit":null,"owner":null,"brand":null,"useProp":null,"model":null,"registDate":null,"issueDate":null,"registerCerti":null,"carBuyDate":null,"drivingLicense":null,"installDate":null,"pcarName":null,"deleteState":false,"department":{"id":157,"createDate":"2018-01-23 15:33:49","modifyDate":"2018-01-23 15:33:49","createUserId":null,"modifyUserId":null,"deptName":"深莞惠","shortName":null,"treeIcon":null,"sortCode":0,"deleteState":false,"description":"","pid":141,"type":1,"phone":"","person":"","area":null,"children":null,"totalCar":null},"manufacturer":null,"img":"e27e7859_400x240_X-新战警60C.png","address":null,"mainDeviceNo":null,"deviceNo":null,"collect":false,"area":{"id":790,"createDate":null,"modifyDate":null,"createUserId":null,"modifyUserId":null,"name":"东莞市","sortCode":790,"pid":19,"deleteState":false,"areaRegionId":null,"children":null,"carNum":null,"todayMileage":null,"yestodayMileage":null},"cloudMap":{"id":18,"createDate":"2017-09-15 22:58:53","modifyDate":"2017-09-15 22:58:53","createUserId":null,"modifyUserId":null,"name":"广源站","cloudType":null,"mapType":null,"json":null,"department":null,"area":null,"deleteState":true,"sortCode":0}},"deviceInitial":null,"devState":{"currentState":null,"comStatus":null,"vehicleStatus":null,"online":null,"latLng":{"lat":"22.672635","lng":"114.034525","baiduLat":null,"baiduLng":null},"mapLatLng":{"lat":"22.669868","lng":"114.039584","baiduLat":"22.675719","baiduLng":"114.046132"},"gpsStamp":"180405005046","poi":"广东省;深圳市;宝安区|深圳市蒙瑞电子有限公司","devNo":"013511112222","direction":"0","speed":"0.0","status":{"accStatus":"1","isLocation":"1","sourthOrNorthLatitude":"0","eastOrWestLongtitude":"0","vehicleElectricStatus":"0","vehicleOilStatus":"0","vehicleDoorStatus":"0","mileage":null,"emergencyAlert":"0","overSpeed":"0","parkingTimeout":"0","powerUnderVoltage":"0","mainPowerOff":"0","vehicleStatus":null,"comStatus":null}},"deviceState":null,"devStateList":null,"deviceMileage":null,"electricCar":true}]
     * filePre : http://180.101.253.139:30003/file/
     */

    private int state;
    private String msg;
    private String result;
    private String filePre;
    private List<ObjBean> obj;

    public int getState() {
        return state;
    }

    public void setState(int state) {
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

    public String getFilePre() {
        return filePre;
    }

    public void setFilePre(String filePre) {
        this.filePre = filePre;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * id : 34365
         * createDate : 2018-04-04 10:10:54
         * modifyDate : 2018-04-04 10:10:57
         * createUserId : null
         * modifyUserId : null
         * devNO : 013511112222
         * devType : 0
         * devModel : null
         * devStatus : null
         * sim : 1231231232131
         * svrNo : 1231232133312
         * snNo : null
         * protocolType : null
         * version : null
         * proDate : null
         * svrPhone : null
         * manufacturer : null
         * inDate : 2018-04-04 10:11:04
         * deleteState : false
         * car : {"id":21202,"createDate":"2018-04-04 10:12:41","modifyDate":"2018-04-04 10:12:44","createUserId":null,"modifyUserId":null,"carNum":null,"plateNum":"粤B77777","carName":"X-新战警60C","frameNum":null,"engineNum":"TM4015BJ2015NS1021","carModel":"EQ5070XXYTBEV3","carType":"X-新战警60C","carUseIn":1,"submit":null,"dataSubmit":null,"owner":null,"brand":null,"useProp":null,"model":null,"registDate":null,"issueDate":null,"registerCerti":null,"carBuyDate":null,"drivingLicense":null,"installDate":null,"pcarName":null,"deleteState":false,"department":{"id":157,"createDate":"2018-01-23 15:33:49","modifyDate":"2018-01-23 15:33:49","createUserId":null,"modifyUserId":null,"deptName":"深莞惠","shortName":null,"treeIcon":null,"sortCode":0,"deleteState":false,"description":"","pid":141,"type":1,"phone":"","person":"","area":null,"children":null,"totalCar":null},"manufacturer":null,"img":"e27e7859_400x240_X-新战警60C.png","address":null,"mainDeviceNo":null,"deviceNo":null,"collect":false,"area":{"id":790,"createDate":null,"modifyDate":null,"createUserId":null,"modifyUserId":null,"name":"东莞市","sortCode":790,"pid":19,"deleteState":false,"areaRegionId":null,"children":null,"carNum":null,"todayMileage":null,"yestodayMileage":null},"cloudMap":{"id":18,"createDate":"2017-09-15 22:58:53","modifyDate":"2017-09-15 22:58:53","createUserId":null,"modifyUserId":null,"name":"广源站","cloudType":null,"mapType":null,"json":null,"department":null,"area":null,"deleteState":true,"sortCode":0}}
         * deviceInitial : null
         * devState : {"currentState":null,"comStatus":null,"vehicleStatus":null,"online":null,"latLng":{"lat":"22.672635","lng":"114.034525","baiduLat":null,"baiduLng":null},"mapLatLng":{"lat":"22.669868","lng":"114.039584","baiduLat":"22.675719","baiduLng":"114.046132"},"gpsStamp":"180405005046","poi":"广东省;深圳市;宝安区|深圳市蒙瑞电子有限公司","devNo":"013511112222","direction":"0","speed":"0.0","status":{"accStatus":"1","isLocation":"1","sourthOrNorthLatitude":"0","eastOrWestLongtitude":"0","vehicleElectricStatus":"0","vehicleOilStatus":"0","vehicleDoorStatus":"0","mileage":null,"emergencyAlert":"0","overSpeed":"0","parkingTimeout":"0","powerUnderVoltage":"0","mainPowerOff":"0","vehicleStatus":null,"comStatus":null}}
         * deviceState : null
         * devStateList : null
         * deviceMileage : null
         * electricCar : true
         */

        private int id;
        private String createDate;
        private String modifyDate;
        private String createUserId;
        private String modifyUserId;
        private String devNO;
        private int devType;
        private String devModel;
        private String devStatus;
        private String sim;
        private String svrNo;
        private String snNo;
        private String protocolType;
        private String version;
        private String proDate;
        private String svrPhone;
        private String manufacturer;
        private String inDate;
        private boolean deleteState;
        private CarBean car;
        private String deviceInitial;
        private DevStateBean devState;
        private String deviceState;
        private String devStateList;
        private String deviceMileage;
        private boolean electricCar;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(String modifyDate) {
            this.modifyDate = modifyDate;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }

        public String getModifyUserId() {
            return modifyUserId;
        }

        public void setModifyUserId(String modifyUserId) {
            this.modifyUserId = modifyUserId;
        }

        public String getDevNO() {
            return devNO;
        }

        public void setDevNO(String devNO) {
            this.devNO = devNO;
        }

        public int getDevType() {
            return devType;
        }

        public void setDevType(int devType) {
            this.devType = devType;
        }

        public String getDevModel() {
            return devModel;
        }

        public void setDevModel(String devModel) {
            this.devModel = devModel;
        }

        public String getDevStatus() {
            return devStatus;
        }

        public void setDevStatus(String devStatus) {
            this.devStatus = devStatus;
        }

        public String getSim() {
            return sim;
        }

        public void setSim(String sim) {
            this.sim = sim;
        }

        public String getSvrNo() {
            return svrNo;
        }

        public void setSvrNo(String svrNo) {
            this.svrNo = svrNo;
        }

        public String getSnNo() {
            return snNo;
        }

        public void setSnNo(String snNo) {
            this.snNo = snNo;
        }

        public String getProtocolType() {
            return protocolType;
        }

        public void setProtocolType(String protocolType) {
            this.protocolType = protocolType;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getProDate() {
            return proDate;
        }

        public void setProDate(String proDate) {
            this.proDate = proDate;
        }

        public String getSvrPhone() {
            return svrPhone;
        }

        public void setSvrPhone(String svrPhone) {
            this.svrPhone = svrPhone;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getInDate() {
            return inDate;
        }

        public void setInDate(String inDate) {
            this.inDate = inDate;
        }

        public boolean isDeleteState() {
            return deleteState;
        }

        public void setDeleteState(boolean deleteState) {
            this.deleteState = deleteState;
        }

        public CarBean getCar() {
            return car;
        }

        public void setCar(CarBean car) {
            this.car = car;
        }

        public String getDeviceInitial() {
            return deviceInitial;
        }

        public void setDeviceInitial(String deviceInitial) {
            this.deviceInitial = deviceInitial;
        }

        public DevStateBean getDevState() {
            return devState;
        }

        public void setDevState(DevStateBean devState) {
            this.devState = devState;
        }

        public String getDeviceState() {
            return deviceState;
        }

        public void setDeviceState(String deviceState) {
            this.deviceState = deviceState;
        }

        public String getDevStateList() {
            return devStateList;
        }

        public void setDevStateList(String devStateList) {
            this.devStateList = devStateList;
        }

        public String getDeviceMileage() {
            return deviceMileage;
        }

        public void setDeviceMileage(String deviceMileage) {
            this.deviceMileage = deviceMileage;
        }

        public boolean isElectricCar() {
            return electricCar;
        }

        public void setElectricCar(boolean electricCar) {
            this.electricCar = electricCar;
        }

        public static class CarBean {
            /**
             * id : 21202
             * createDate : 2018-04-04 10:12:41
             * modifyDate : 2018-04-04 10:12:44
             * createUserId : null
             * modifyUserId : null
             * carNum : null
             * plateNum : 粤B77777
             * carName : X-新战警60C
             * frameNum : null
             * engineNum : TM4015BJ2015NS1021
             * carModel : EQ5070XXYTBEV3
             * carType : X-新战警60C
             * carUseIn : 1
             * submit : null
             * dataSubmit : null
             * owner : null
             * brand : null
             * useProp : null
             * model : null
             * registDate : null
             * issueDate : null
             * registerCerti : null
             * carBuyDate : null
             * drivingLicense : null
             * installDate : null
             * pcarName : null
             * deleteState : false
             * department : {"id":157,"createDate":"2018-01-23 15:33:49","modifyDate":"2018-01-23 15:33:49","createUserId":null,"modifyUserId":null,"deptName":"深莞惠","shortName":null,"treeIcon":null,"sortCode":0,"deleteState":false,"description":"","pid":141,"type":1,"phone":"","person":"","area":null,"children":null,"totalCar":null}
             * manufacturer : null
             * img : e27e7859_400x240_X-新战警60C.png
             * address : null
             * mainDeviceNo : null
             * deviceNo : null
             * collect : false
             * area : {"id":790,"createDate":null,"modifyDate":null,"createUserId":null,"modifyUserId":null,"name":"东莞市","sortCode":790,"pid":19,"deleteState":false,"areaRegionId":null,"children":null,"carNum":null,"todayMileage":null,"yestodayMileage":null}
             * cloudMap : {"id":18,"createDate":"2017-09-15 22:58:53","modifyDate":"2017-09-15 22:58:53","createUserId":null,"modifyUserId":null,"name":"广源站","cloudType":null,"mapType":null,"json":null,"department":null,"area":null,"deleteState":true,"sortCode":0}
             */

            private int id;
            private String createDate;
            private String modifyDate;
            private String createUserId;
            private String modifyUserId;
            private String carNum;
            private String plateNum;
            private String carName;
            private String frameNum;
            private String engineNum;
            private String carModel;
            private String carType;
            private int carUseIn;
            private String submit;
            private String dataSubmit;
            private String owner;
            private String brand;
            private String useProp;
            private String model;
            private String registDate;
            private String issueDate;
            private String registerCerti;
            private String carBuyDate;
            private String drivingLicense;
            private String installDate;
            private String pcarName;
            private boolean deleteState;
            private DepartmentBean department;
            private String manufacturer;
            private String img;
            private String address;
            private String mainDeviceNo;
            private String deviceNo;
            private boolean collect;
            private AreaBean area;
            private CloudMapBean cloudMap;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getModifyDate() {
                return modifyDate;
            }

            public void setModifyDate(String modifyDate) {
                this.modifyDate = modifyDate;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getModifyUserId() {
                return modifyUserId;
            }

            public void setModifyUserId(String modifyUserId) {
                this.modifyUserId = modifyUserId;
            }

            public String getCarNum() {
                return carNum;
            }

            public void setCarNum(String carNum) {
                this.carNum = carNum;
            }

            public String getPlateNum() {
                return plateNum;
            }

            public void setPlateNum(String plateNum) {
                this.plateNum = plateNum;
            }

            public String getCarName() {
                return carName;
            }

            public void setCarName(String carName) {
                this.carName = carName;
            }

            public String getFrameNum() {
                return frameNum;
            }

            public void setFrameNum(String frameNum) {
                this.frameNum = frameNum;
            }

            public String getEngineNum() {
                return engineNum;
            }

            public void setEngineNum(String engineNum) {
                this.engineNum = engineNum;
            }

            public String getCarModel() {
                return carModel;
            }

            public void setCarModel(String carModel) {
                this.carModel = carModel;
            }

            public String getCarType() {
                return carType;
            }

            public void setCarType(String carType) {
                this.carType = carType;
            }

            public int getCarUseIn() {
                return carUseIn;
            }

            public void setCarUseIn(int carUseIn) {
                this.carUseIn = carUseIn;
            }

            public String getSubmit() {
                return submit;
            }

            public void setSubmit(String submit) {
                this.submit = submit;
            }

            public String getDataSubmit() {
                return dataSubmit;
            }

            public void setDataSubmit(String dataSubmit) {
                this.dataSubmit = dataSubmit;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public String getUseProp() {
                return useProp;
            }

            public void setUseProp(String useProp) {
                this.useProp = useProp;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public String getRegistDate() {
                return registDate;
            }

            public void setRegistDate(String registDate) {
                this.registDate = registDate;
            }

            public String getIssueDate() {
                return issueDate;
            }

            public void setIssueDate(String issueDate) {
                this.issueDate = issueDate;
            }

            public String getRegisterCerti() {
                return registerCerti;
            }

            public void setRegisterCerti(String registerCerti) {
                this.registerCerti = registerCerti;
            }

            public String getCarBuyDate() {
                return carBuyDate;
            }

            public void setCarBuyDate(String carBuyDate) {
                this.carBuyDate = carBuyDate;
            }

            public String getDrivingLicense() {
                return drivingLicense;
            }

            public void setDrivingLicense(String drivingLicense) {
                this.drivingLicense = drivingLicense;
            }

            public String getInstallDate() {
                return installDate;
            }

            public void setInstallDate(String installDate) {
                this.installDate = installDate;
            }

            public String getPcarName() {
                return pcarName;
            }

            public void setPcarName(String pcarName) {
                this.pcarName = pcarName;
            }

            public boolean isDeleteState() {
                return deleteState;
            }

            public void setDeleteState(boolean deleteState) {
                this.deleteState = deleteState;
            }

            public DepartmentBean getDepartment() {
                return department;
            }

            public void setDepartment(DepartmentBean department) {
                this.department = department;
            }

            public String getManufacturer() {
                return manufacturer;
            }

            public void setManufacturer(String manufacturer) {
                this.manufacturer = manufacturer;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getMainDeviceNo() {
                return mainDeviceNo;
            }

            public void setMainDeviceNo(String mainDeviceNo) {
                this.mainDeviceNo = mainDeviceNo;
            }

            public String getDeviceNo() {
                return deviceNo;
            }

            public void setDeviceNo(String deviceNo) {
                this.deviceNo = deviceNo;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public AreaBean getArea() {
                return area;
            }

            public void setArea(AreaBean area) {
                this.area = area;
            }

            public CloudMapBean getCloudMap() {
                return cloudMap;
            }

            public void setCloudMap(CloudMapBean cloudMap) {
                this.cloudMap = cloudMap;
            }

            public static class DepartmentBean {
                /**
                 * id : 157
                 * createDate : 2018-01-23 15:33:49
                 * modifyDate : 2018-01-23 15:33:49
                 * createUserId : null
                 * modifyUserId : null
                 * deptName : 深莞惠
                 * shortName : null
                 * treeIcon : null
                 * sortCode : 0
                 * deleteState : false
                 * description :
                 * pid : 141
                 * type : 1
                 * phone :
                 * person :
                 * area : null
                 * children : null
                 * totalCar : null
                 */

                private int id;
                private String createDate;
                private String modifyDate;
                private String createUserId;
                private String modifyUserId;
                private String deptName;
                private String shortName;
                private String treeIcon;
                private int sortCode;
                private boolean deleteState;
                private String description;
                private int pid;
                private int type;
                private String phone;
                private String person;
                private String area;
                private String children;
                private String totalCar;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getModifyDate() {
                    return modifyDate;
                }

                public void setModifyDate(String modifyDate) {
                    this.modifyDate = modifyDate;
                }

                public String getCreateUserId() {
                    return createUserId;
                }

                public void setCreateUserId(String createUserId) {
                    this.createUserId = createUserId;
                }

                public String getModifyUserId() {
                    return modifyUserId;
                }

                public void setModifyUserId(String modifyUserId) {
                    this.modifyUserId = modifyUserId;
                }

                public String getDeptName() {
                    return deptName;
                }

                public void setDeptName(String deptName) {
                    this.deptName = deptName;
                }

                public String getShortName() {
                    return shortName;
                }

                public void setShortName(String shortName) {
                    this.shortName = shortName;
                }

                public String getTreeIcon() {
                    return treeIcon;
                }

                public void setTreeIcon(String treeIcon) {
                    this.treeIcon = treeIcon;
                }

                public int getSortCode() {
                    return sortCode;
                }

                public void setSortCode(int sortCode) {
                    this.sortCode = sortCode;
                }

                public boolean isDeleteState() {
                    return deleteState;
                }

                public void setDeleteState(boolean deleteState) {
                    this.deleteState = deleteState;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getPerson() {
                    return person;
                }

                public void setPerson(String person) {
                    this.person = person;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public String getChildren() {
                    return children;
                }

                public void setChildren(String children) {
                    this.children = children;
                }

                public String getTotalCar() {
                    return totalCar;
                }

                public void setTotalCar(String totalCar) {
                    this.totalCar = totalCar;
                }
            }

            public static class AreaBean {
                /**
                 * id : 790
                 * createDate : null
                 * modifyDate : null
                 * createUserId : null
                 * modifyUserId : null
                 * name : 东莞市
                 * sortCode : 790
                 * pid : 19
                 * deleteState : false
                 * areaRegionId : null
                 * children : null
                 * carNum : null
                 * todayMileage : null
                 * yestodayMileage : null
                 */

                private int id;
                private String createDate;
                private String modifyDate;
                private String createUserId;
                private String modifyUserId;
                private String name;
                private int sortCode;
                private int pid;
                private boolean deleteState;
                private String areaRegionId;
                private String children;
                private String carNum;
                private String todayMileage;
                private String yestodayMileage;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getModifyDate() {
                    return modifyDate;
                }

                public void setModifyDate(String modifyDate) {
                    this.modifyDate = modifyDate;
                }

                public String getCreateUserId() {
                    return createUserId;
                }

                public void setCreateUserId(String createUserId) {
                    this.createUserId = createUserId;
                }

                public String getModifyUserId() {
                    return modifyUserId;
                }

                public void setModifyUserId(String modifyUserId) {
                    this.modifyUserId = modifyUserId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSortCode() {
                    return sortCode;
                }

                public void setSortCode(int sortCode) {
                    this.sortCode = sortCode;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public boolean isDeleteState() {
                    return deleteState;
                }

                public void setDeleteState(boolean deleteState) {
                    this.deleteState = deleteState;
                }

                public String getAreaRegionId() {
                    return areaRegionId;
                }

                public void setAreaRegionId(String areaRegionId) {
                    this.areaRegionId = areaRegionId;
                }

                public String getChildren() {
                    return children;
                }

                public void setChildren(String children) {
                    this.children = children;
                }

                public String getCarNum() {
                    return carNum;
                }

                public void setCarNum(String carNum) {
                    this.carNum = carNum;
                }

                public String getTodayMileage() {
                    return todayMileage;
                }

                public void setTodayMileage(String todayMileage) {
                    this.todayMileage = todayMileage;
                }

                public String getYestodayMileage() {
                    return yestodayMileage;
                }

                public void setYestodayMileage(String yestodayMileage) {
                    this.yestodayMileage = yestodayMileage;
                }
            }

            public static class CloudMapBean {
                /**
                 * id : 18
                 * createDate : 2017-09-15 22:58:53
                 * modifyDate : 2017-09-15 22:58:53
                 * createUserId : null
                 * modifyUserId : null
                 * name : 广源站
                 * cloudType : null
                 * mapType : null
                 * json : null
                 * department : null
                 * area : null
                 * deleteState : true
                 * sortCode : 0
                 */

                private int id;
                private String createDate;
                private String modifyDate;
                private String createUserId;
                private String modifyUserId;
                private String name;
                private String cloudType;
                private String mapType;
                private String json;
                private String department;
                private String area;
                private boolean deleteState;
                private int sortCode;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public String getModifyDate() {
                    return modifyDate;
                }

                public void setModifyDate(String modifyDate) {
                    this.modifyDate = modifyDate;
                }

                public String getCreateUserId() {
                    return createUserId;
                }

                public void setCreateUserId(String createUserId) {
                    this.createUserId = createUserId;
                }

                public String getModifyUserId() {
                    return modifyUserId;
                }

                public void setModifyUserId(String modifyUserId) {
                    this.modifyUserId = modifyUserId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCloudType() {
                    return cloudType;
                }

                public void setCloudType(String cloudType) {
                    this.cloudType = cloudType;
                }

                public String getMapType() {
                    return mapType;
                }

                public void setMapType(String mapType) {
                    this.mapType = mapType;
                }

                public String getJson() {
                    return json;
                }

                public void setJson(String json) {
                    this.json = json;
                }

                public String getDepartment() {
                    return department;
                }

                public void setDepartment(String department) {
                    this.department = department;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public boolean isDeleteState() {
                    return deleteState;
                }

                public void setDeleteState(boolean deleteState) {
                    this.deleteState = deleteState;
                }

                public int getSortCode() {
                    return sortCode;
                }

                public void setSortCode(int sortCode) {
                    this.sortCode = sortCode;
                }
            }
        }

        public static class DevStateBean {
            /**
             * currentState : null
             * comStatus : null
             * vehicleStatus : null
             * online : null
             * latLng : {"lat":"22.672635","lng":"114.034525","baiduLat":null,"baiduLng":null}
             * mapLatLng : {"lat":"22.669868","lng":"114.039584","baiduLat":"22.675719","baiduLng":"114.046132"}
             * gpsStamp : 180405005046
             * poi : 广东省;深圳市;宝安区|深圳市蒙瑞电子有限公司
             * devNo : 013511112222
             * direction : 0
             * speed : 0.0
             * status : {"accStatus":"1","isLocation":"1","sourthOrNorthLatitude":"0","eastOrWestLongtitude":"0","vehicleElectricStatus":"0","vehicleOilStatus":"0","vehicleDoorStatus":"0","mileage":null,"emergencyAlert":"0","overSpeed":"0","parkingTimeout":"0","powerUnderVoltage":"0","mainPowerOff":"0","vehicleStatus":null,"comStatus":null}
             */

            private String currentState;
            private String comStatus;
            private String vehicleStatus;
            private String online;
            private LatLngBean latLng;
            private MapLatLngBean mapLatLng;
            private String gpsStamp;
            private String poi;
            private String devNo;
            private String direction;
            private String speed;
            private StatusBean status;

            public String getCurrentState() {
                return currentState;
            }

            public void setCurrentState(String currentState) {
                this.currentState = currentState;
            }

            public String getComStatus() {
                return comStatus;
            }

            public void setComStatus(String comStatus) {
                this.comStatus = comStatus;
            }

            public String getVehicleStatus() {
                return vehicleStatus;
            }

            public void setVehicleStatus(String vehicleStatus) {
                this.vehicleStatus = vehicleStatus;
            }

            public String getOnline() {
                return online;
            }

            public void setOnline(String online) {
                this.online = online;
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

            public String getGpsStamp() {
                return gpsStamp;
            }

            public void setGpsStamp(String gpsStamp) {
                this.gpsStamp = gpsStamp;
            }

            public String getPoi() {
                return poi;
            }

            public void setPoi(String poi) {
                this.poi = poi;
            }

            public String getDevNo() {
                return devNo;
            }

            public void setDevNo(String devNo) {
                this.devNo = devNo;
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
                 * lat : 22.672635
                 * lng : 114.034525
                 * baiduLat : null
                 * baiduLng : null
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

            public static class MapLatLngBean {
                /**
                 * lat : 22.669868
                 * lng : 114.039584
                 * baiduLat : 22.675719
                 * baiduLng : 114.046132
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
                 * mileage : null
                 * emergencyAlert : 0
                 * overSpeed : 0
                 * parkingTimeout : 0
                 * powerUnderVoltage : 0
                 * mainPowerOff : 0
                 * vehicleStatus : null
                 * comStatus : null
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
                private String comStatus;

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

                public String getComStatus() {
                    return comStatus;
                }

                public void setComStatus(String comStatus) {
                    this.comStatus = comStatus;
                }
            }
        }
    }
}
