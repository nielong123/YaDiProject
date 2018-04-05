package gaode.trajectory.bean;

import java.util.List;

/**
 * Created by MrKong on 18/4/4.
 */

public class VehicleInfosBean
{

    /**
     * state : 0
     * msg : null
     * result : null
     * obj : {"content":[{"id":21201,"createDate":"2018-04-04 05:17:41","modifyDate":"2018-04-04
     * 05:17:45","createUserId":null,"modifyUserId":null,"carNum":"0000021201",
     * "plateNum":"粤B66666","carName":"X-新战警60C","frameNum":"111","engineNum":"",
     * "carModel":"EQ5070XXYTBEV3","carType":"X-新战警60C","carUseIn":1,"submit":false,
     * "dataSubmit":false,"owner":"","brand":null,"useProp":null,"model":"","registDate":"",
     * "issueDate":"","registerCerti":"","carBuyDate":"","drivingLicense":null,"installDate":"",
     * "pcarName":null,"deleteState":false,"department":{"id":-1,"createDate":"2017-11-15
     * 14:19:46","modifyDate":"2017-11-15 14:19:52","createUserId":null,"modifyUserId":null,
     * "deptName":"未绑定","shortName":null,"treeIcon":null,"sortCode":0,"deleteState":false,
     * "description":"未绑定","pid":null,"type":0,"phone":null,"person":null,"area":null,
     * "children":null,"totalCar":null},"manufacturer":null,"img":"img/3636fa1e_400x240_X-新战警60C
     * .png","address":"","mainDeviceNo":"013655558888","deviceNo":null,"collect":false,
     * "area":{"id":790,"createDate":null,"modifyDate":null,"createUserId":null,
     * "modifyUserId":null,"name":"东莞市","sortCode":790,"pid":19,"deleteState":false,
     * "areaRegionId":null,"children":null,"carNum":null,"todayMileage":null,
     * "yestodayMileage":null},"cloudMap":null}],"last":true,"totalElements":1,"totalPages":1,
     * "sort":null,"first":true,"numberOfElements":1,"size":1,"number":0}
     * filePre : http://180.101.253.139:30003/file/
     */

    private int state;
    private Object msg;
    private Object result;
    private ObjBean obj;
    private String filePre;

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public Object getMsg()
    {
        return msg;
    }

    public void setMsg(Object msg)
    {
        this.msg = msg;
    }

    public Object getResult()
    {
        return result;
    }

    public void setResult(Object result)
    {
        this.result = result;
    }

    public ObjBean getObj()
    {
        return obj;
    }

    public void setObj(ObjBean obj)
    {
        this.obj = obj;
    }

    public String getFilePre()
    {
        return filePre;
    }

    public void setFilePre(String filePre)
    {
        this.filePre = filePre;
    }

    public static class ObjBean
    {
        /**
         * content : [{"id":21201,"createDate":"2018-04-04 05:17:41","modifyDate":"2018-04-04
         * 05:17:45","createUserId":null,"modifyUserId":null,"carNum":"0000021201",
         * "plateNum":"粤B66666","carName":"X-新战警60C","frameNum":"111","engineNum":"",
         * "carModel":"EQ5070XXYTBEV3","carType":"X-新战警60C","carUseIn":1,"submit":false,
         * "dataSubmit":false,"owner":"","brand":null,"useProp":null,"model":"","registDate":"",
         * "issueDate":"","registerCerti":"","carBuyDate":"","drivingLicense":null,
         * "installDate":"","pcarName":null,"deleteState":false,"department":{"id":-1,
         * "createDate":"2017-11-15 14:19:46","modifyDate":"2017-11-15 14:19:52",
         * "createUserId":null,"modifyUserId":null,"deptName":"未绑定","shortName":null,
         * "treeIcon":null,"sortCode":0,"deleteState":false,"description":"未绑定","pid":null,
         * "type":0,"phone":null,"person":null,"area":null,"children":null,"totalCar":null},
         * "manufacturer":null,"img":"img/3636fa1e_400x240_X-新战警60C.png","address":"",
         * "mainDeviceNo":"013655558888","deviceNo":null,"collect":false,"area":{"id":790,
         * "createDate":null,"modifyDate":null,"createUserId":null,"modifyUserId":null,
         * "name":"东莞市","sortCode":790,"pid":19,"deleteState":false,"areaRegionId":null,
         * "children":null,"carNum":null,"todayMileage":null,"yestodayMileage":null},
         * "cloudMap":null}]
         * last : true
         * totalElements : 1
         * totalPages : 1
         * sort : null
         * first : true
         * numberOfElements : 1
         * size : 1
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

        public boolean isLast()
        {
            return last;
        }

        public void setLast(boolean last)
        {
            this.last = last;
        }

        public int getTotalElements()
        {
            return totalElements;
        }

        public void setTotalElements(int totalElements)
        {
            this.totalElements = totalElements;
        }

        public int getTotalPages()
        {
            return totalPages;
        }

        public void setTotalPages(int totalPages)
        {
            this.totalPages = totalPages;
        }

        public Object getSort()
        {
            return sort;
        }

        public void setSort(Object sort)
        {
            this.sort = sort;
        }

        public boolean isFirst()
        {
            return first;
        }

        public void setFirst(boolean first)
        {
            this.first = first;
        }

        public int getNumberOfElements()
        {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements)
        {
            this.numberOfElements = numberOfElements;
        }

        public int getSize()
        {
            return size;
        }

        public void setSize(int size)
        {
            this.size = size;
        }

        public int getNumber()
        {
            return number;
        }

        public void setNumber(int number)
        {
            this.number = number;
        }

        public List<ContentBean> getContent()
        {
            return content;
        }

        public void setContent(List<ContentBean> content)
        {
            this.content = content;
        }

        public static class ContentBean
        {
            /**
             * id : 21201
             * createDate : 2018-04-04 05:17:41
             * modifyDate : 2018-04-04 05:17:45
             * createUserId : null
             * modifyUserId : null
             * carNum : 0000021201
             * plateNum : 粤B66666
             * carName : X-新战警60C
             * frameNum : 111
             * engineNum :
             * carModel : EQ5070XXYTBEV3
             * carType : X-新战警60C
             * carUseIn : 1
             * submit : false
             * dataSubmit : false
             * owner :
             * brand : null
             * useProp : null
             * model :
             * registDate :
             * issueDate :
             * registerCerti :
             * carBuyDate :
             * drivingLicense : null
             * installDate :
             * pcarName : null
             * deleteState : false
             * department : {"id":-1,"createDate":"2017-11-15 14:19:46","modifyDate":"2017-11-15
             * 14:19:52","createUserId":null,"modifyUserId":null,"deptName":"未绑定",
             * "shortName":null,"treeIcon":null,"sortCode":0,"deleteState":false,
             * "description":"未绑定","pid":null,"type":0,"phone":null,"person":null,"area":null,
             * "children":null,"totalCar":null}
             * manufacturer : null
             * img : img/3636fa1e_400x240_X-新战警60C.png
             * address :
             * mainDeviceNo : 013655558888
             * deviceNo : null
             * collect : false
             * area : {"id":790,"createDate":null,"modifyDate":null,"createUserId":null,
             * "modifyUserId":null,"name":"东莞市","sortCode":790,"pid":19,"deleteState":false,
             * "areaRegionId":null,"children":null,"carNum":null,"todayMileage":null,
             * "yestodayMileage":null}
             * cloudMap : null
             */

            private int id;
            private String createDate;
            private String modifyDate;
            private Object createUserId;
            private Object modifyUserId;
            private String carNum;
            private String plateNum;
            private String carName;
            private String frameNum;
            private String engineNum;
            private String carModel;
            private String carType;
            private int carUseIn;
            private boolean submit;
            private boolean dataSubmit;
            private String owner;
            private Object brand;
            private Object useProp;
            private String model;
            private String registDate;
            private String issueDate;
            private String registerCerti;
            private String carBuyDate;
            private Object drivingLicense;
            private String installDate;
            private Object pcarName;
            private boolean deleteState;
            private DepartmentBean department;
            private Object manufacturer;
            private String img;
            private String address;
            private String mainDeviceNo;
            private Object deviceNo;
            private boolean collect;
            private AreaBean area;
            private Object cloudMap;

            public int getId()
            {
                return id;
            }

            public void setId(int id)
            {
                this.id = id;
            }

            public String getCreateDate()
            {
                return createDate;
            }

            public void setCreateDate(String createDate)
            {
                this.createDate = createDate;
            }

            public String getModifyDate()
            {
                return modifyDate;
            }

            public void setModifyDate(String modifyDate)
            {
                this.modifyDate = modifyDate;
            }

            public Object getCreateUserId()
            {
                return createUserId;
            }

            public void setCreateUserId(Object createUserId)
            {
                this.createUserId = createUserId;
            }

            public Object getModifyUserId()
            {
                return modifyUserId;
            }

            public void setModifyUserId(Object modifyUserId)
            {
                this.modifyUserId = modifyUserId;
            }

            public String getCarNum()
            {
                return carNum;
            }

            public void setCarNum(String carNum)
            {
                this.carNum = carNum;
            }

            public String getPlateNum()
            {
                return plateNum;
            }

            public void setPlateNum(String plateNum)
            {
                this.plateNum = plateNum;
            }

            public String getCarName()
            {
                return carName;
            }

            public void setCarName(String carName)
            {
                this.carName = carName;
            }

            public String getFrameNum()
            {
                return frameNum;
            }

            public void setFrameNum(String frameNum)
            {
                this.frameNum = frameNum;
            }

            public String getEngineNum()
            {
                return engineNum;
            }

            public void setEngineNum(String engineNum)
            {
                this.engineNum = engineNum;
            }

            public String getCarModel()
            {
                return carModel;
            }

            public void setCarModel(String carModel)
            {
                this.carModel = carModel;
            }

            public String getCarType()
            {
                return carType;
            }

            public void setCarType(String carType)
            {
                this.carType = carType;
            }

            public int getCarUseIn()
            {
                return carUseIn;
            }

            public void setCarUseIn(int carUseIn)
            {
                this.carUseIn = carUseIn;
            }

            public boolean isSubmit()
            {
                return submit;
            }

            public void setSubmit(boolean submit)
            {
                this.submit = submit;
            }

            public boolean isDataSubmit()
            {
                return dataSubmit;
            }

            public void setDataSubmit(boolean dataSubmit)
            {
                this.dataSubmit = dataSubmit;
            }

            public String getOwner()
            {
                return owner;
            }

            public void setOwner(String owner)
            {
                this.owner = owner;
            }

            public Object getBrand()
            {
                return brand;
            }

            public void setBrand(Object brand)
            {
                this.brand = brand;
            }

            public Object getUseProp()
            {
                return useProp;
            }

            public void setUseProp(Object useProp)
            {
                this.useProp = useProp;
            }

            public String getModel()
            {
                return model;
            }

            public void setModel(String model)
            {
                this.model = model;
            }

            public String getRegistDate()
            {
                return registDate;
            }

            public void setRegistDate(String registDate)
            {
                this.registDate = registDate;
            }

            public String getIssueDate()
            {
                return issueDate;
            }

            public void setIssueDate(String issueDate)
            {
                this.issueDate = issueDate;
            }

            public String getRegisterCerti()
            {
                return registerCerti;
            }

            public void setRegisterCerti(String registerCerti)
            {
                this.registerCerti = registerCerti;
            }

            public String getCarBuyDate()
            {
                return carBuyDate;
            }

            public void setCarBuyDate(String carBuyDate)
            {
                this.carBuyDate = carBuyDate;
            }

            public Object getDrivingLicense()
            {
                return drivingLicense;
            }

            public void setDrivingLicense(Object drivingLicense)
            {
                this.drivingLicense = drivingLicense;
            }

            public String getInstallDate()
            {
                return installDate;
            }

            public void setInstallDate(String installDate)
            {
                this.installDate = installDate;
            }

            public Object getPcarName()
            {
                return pcarName;
            }

            public void setPcarName(Object pcarName)
            {
                this.pcarName = pcarName;
            }

            public boolean isDeleteState()
            {
                return deleteState;
            }

            public void setDeleteState(boolean deleteState)
            {
                this.deleteState = deleteState;
            }

            public DepartmentBean getDepartment()
            {
                return department;
            }

            public void setDepartment(DepartmentBean department)
            {
                this.department = department;
            }

            public Object getManufacturer()
            {
                return manufacturer;
            }

            public void setManufacturer(Object manufacturer)
            {
                this.manufacturer = manufacturer;
            }

            public String getImg()
            {
                return img;
            }

            public void setImg(String img)
            {
                this.img = img;
            }

            public String getAddress()
            {
                return address;
            }

            public void setAddress(String address)
            {
                this.address = address;
            }

            public String getMainDeviceNo()
            {
                return mainDeviceNo;
            }

            public void setMainDeviceNo(String mainDeviceNo)
            {
                this.mainDeviceNo = mainDeviceNo;
            }

            public Object getDeviceNo()
            {
                return deviceNo;
            }

            public void setDeviceNo(Object deviceNo)
            {
                this.deviceNo = deviceNo;
            }

            public boolean isCollect()
            {
                return collect;
            }

            public void setCollect(boolean collect)
            {
                this.collect = collect;
            }

            public AreaBean getArea()
            {
                return area;
            }

            public void setArea(AreaBean area)
            {
                this.area = area;
            }

            public Object getCloudMap()
            {
                return cloudMap;
            }

            public void setCloudMap(Object cloudMap)
            {
                this.cloudMap = cloudMap;
            }

            public static class DepartmentBean
            {
                /**
                 * id : -1
                 * createDate : 2017-11-15 14:19:46
                 * modifyDate : 2017-11-15 14:19:52
                 * createUserId : null
                 * modifyUserId : null
                 * deptName : 未绑定
                 * shortName : null
                 * treeIcon : null
                 * sortCode : 0
                 * deleteState : false
                 * description : 未绑定
                 * pid : null
                 * type : 0
                 * phone : null
                 * person : null
                 * area : null
                 * children : null
                 * totalCar : null
                 */

                private int id;
                private String createDate;
                private String modifyDate;
                private Object createUserId;
                private Object modifyUserId;
                private String deptName;
                private Object shortName;
                private Object treeIcon;
                private int sortCode;
                private boolean deleteState;
                private String description;
                private Object pid;
                private int type;
                private Object phone;
                private Object person;
                private Object area;
                private Object children;
                private Object totalCar;

                public int getId()
                {
                    return id;
                }

                public void setId(int id)
                {
                    this.id = id;
                }

                public String getCreateDate()
                {
                    return createDate;
                }

                public void setCreateDate(String createDate)
                {
                    this.createDate = createDate;
                }

                public String getModifyDate()
                {
                    return modifyDate;
                }

                public void setModifyDate(String modifyDate)
                {
                    this.modifyDate = modifyDate;
                }

                public Object getCreateUserId()
                {
                    return createUserId;
                }

                public void setCreateUserId(Object createUserId)
                {
                    this.createUserId = createUserId;
                }

                public Object getModifyUserId()
                {
                    return modifyUserId;
                }

                public void setModifyUserId(Object modifyUserId)
                {
                    this.modifyUserId = modifyUserId;
                }

                public String getDeptName()
                {
                    return deptName;
                }

                public void setDeptName(String deptName)
                {
                    this.deptName = deptName;
                }

                public Object getShortName()
                {
                    return shortName;
                }

                public void setShortName(Object shortName)
                {
                    this.shortName = shortName;
                }

                public Object getTreeIcon()
                {
                    return treeIcon;
                }

                public void setTreeIcon(Object treeIcon)
                {
                    this.treeIcon = treeIcon;
                }

                public int getSortCode()
                {
                    return sortCode;
                }

                public void setSortCode(int sortCode)
                {
                    this.sortCode = sortCode;
                }

                public boolean isDeleteState()
                {
                    return deleteState;
                }

                public void setDeleteState(boolean deleteState)
                {
                    this.deleteState = deleteState;
                }

                public String getDescription()
                {
                    return description;
                }

                public void setDescription(String description)
                {
                    this.description = description;
                }

                public Object getPid()
                {
                    return pid;
                }

                public void setPid(Object pid)
                {
                    this.pid = pid;
                }

                public int getType()
                {
                    return type;
                }

                public void setType(int type)
                {
                    this.type = type;
                }

                public Object getPhone()
                {
                    return phone;
                }

                public void setPhone(Object phone)
                {
                    this.phone = phone;
                }

                public Object getPerson()
                {
                    return person;
                }

                public void setPerson(Object person)
                {
                    this.person = person;
                }

                public Object getArea()
                {
                    return area;
                }

                public void setArea(Object area)
                {
                    this.area = area;
                }

                public Object getChildren()
                {
                    return children;
                }

                public void setChildren(Object children)
                {
                    this.children = children;
                }

                public Object getTotalCar()
                {
                    return totalCar;
                }

                public void setTotalCar(Object totalCar)
                {
                    this.totalCar = totalCar;
                }
            }

            public static class AreaBean
            {
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
                private Object createDate;
                private Object modifyDate;
                private Object createUserId;
                private Object modifyUserId;
                private String name;
                private int sortCode;
                private int pid;
                private boolean deleteState;
                private Object areaRegionId;
                private Object children;
                private Object carNum;
                private Object todayMileage;
                private Object yestodayMileage;

                public int getId()
                {
                    return id;
                }

                public void setId(int id)
                {
                    this.id = id;
                }

                public Object getCreateDate()
                {
                    return createDate;
                }

                public void setCreateDate(Object createDate)
                {
                    this.createDate = createDate;
                }

                public Object getModifyDate()
                {
                    return modifyDate;
                }

                public void setModifyDate(Object modifyDate)
                {
                    this.modifyDate = modifyDate;
                }

                public Object getCreateUserId()
                {
                    return createUserId;
                }

                public void setCreateUserId(Object createUserId)
                {
                    this.createUserId = createUserId;
                }

                public Object getModifyUserId()
                {
                    return modifyUserId;
                }

                public void setModifyUserId(Object modifyUserId)
                {
                    this.modifyUserId = modifyUserId;
                }

                public String getName()
                {
                    return name;
                }

                public void setName(String name)
                {
                    this.name = name;
                }

                public int getSortCode()
                {
                    return sortCode;
                }

                public void setSortCode(int sortCode)
                {
                    this.sortCode = sortCode;
                }

                public int getPid()
                {
                    return pid;
                }

                public void setPid(int pid)
                {
                    this.pid = pid;
                }

                public boolean isDeleteState()
                {
                    return deleteState;
                }

                public void setDeleteState(boolean deleteState)
                {
                    this.deleteState = deleteState;
                }

                public Object getAreaRegionId()
                {
                    return areaRegionId;
                }

                public void setAreaRegionId(Object areaRegionId)
                {
                    this.areaRegionId = areaRegionId;
                }

                public Object getChildren()
                {
                    return children;
                }

                public void setChildren(Object children)
                {
                    this.children = children;
                }

                public Object getCarNum()
                {
                    return carNum;
                }

                public void setCarNum(Object carNum)
                {
                    this.carNum = carNum;
                }

                public Object getTodayMileage()
                {
                    return todayMileage;
                }

                public void setTodayMileage(Object todayMileage)
                {
                    this.todayMileage = todayMileage;
                }

                public Object getYestodayMileage()
                {
                    return yestodayMileage;
                }

                public void setYestodayMileage(Object yestodayMileage)
                {
                    this.yestodayMileage = yestodayMileage;
                }
            }
        }
    }
}
