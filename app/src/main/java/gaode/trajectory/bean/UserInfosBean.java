package gaode.trajectory.bean;

import java.util.List;

/**
 * Created by MrKong on 18/4/4.
 */

public class UserInfosBean
{

    /**
     * state : 0
     * msg : null
     * result : null
     * obj : {"content":[{"id":120,"createDate":"2017-10-20 10:26:02","modifyDate":"2017-10-20
     * 10:26:02","createUserId":1,"modifyUserId":50,"loginName":"xwylcar","userName":"新沃车管对接账号",
     * "deptId":null,"type":2,"sortCode":0,"deleteState":false,"description":"新沃车管对接账号",
     * "createUserName":"admin1","roleIds":null,"depRoleIds":null,"dogId":null,
     * "superUser":false},{"id":135,"createDate":"2017-10-20 18:34:33","modifyDate":"2017-10-20
     * 18:34:33","createUserId":1,"modifyUserId":null,"loginName":"liuyang","userName":"刘洋",
     * "deptId":null,"type":1,"sortCode":0,"deleteState":false,"description":"安装录入（深圳迅创）",
     * "createUserName":"admin1","roleIds":null,"depRoleIds":null,"dogId":null,
     * "superUser":false},{"id":136,"createDate":"2017-10-20 18:36:23","modifyDate":"2017-10-20
     * 18:36:23","createUserId":1,"modifyUserId":null,"loginName":"shigongcheng",
     * "userName":"石功成","deptId":null,"type":1,"sortCode":0,"deleteState":false,
     * "description":"安装录入（深圳迅创）","createUserName":"admin1","roleIds":null,"depRoleIds":null,
     * "dogId":null,"superUser":false},{"id":137,"createDate":"2017-10-20 18:48:41",
     * "modifyDate":"2017-10-20 18:48:41","createUserId":1,"modifyUserId":1,"loginName":"test",
     * "userName":"测试迅创","deptId":null,"type":0,"sortCode":0,"deleteState":false,
     * "description":"测试专用（深圳迅创）","createUserName":"admin1","roleIds":null,"depRoleIds":null,
     * "dogId":null,"superUser":true},{"id":143,"createDate":"2017-10-28 12:04:57",
     * "modifyDate":"2017-10-28 12:04:57","createUserId":1,"modifyUserId":null,
     * "loginName":"Larry","userName":"赵乐","deptId":null,"type":1,"sortCode":0,
     * "deleteState":false,"description":"新沃查看","createUserName":"admin1","roleIds":null,
     * "depRoleIds":null,"dogId":null,"superUser":false},{"id":153,"createDate":"2017-11-06
     * 10:07:53","modifyDate":"2017-11-06 10:07:53","createUserId":1,"modifyUserId":null,
     * "loginName":"szxc2017","userName":"查看用户","deptId":null,"type":1,"sortCode":0,
     * "deleteState":false,"description":"迅创查看权限","createUserName":"admin1","roleIds":null,
     * "depRoleIds":null,"dogId":null,"superUser":false},{"id":154,"createDate":"2017-11-07
     * 10:49:11","modifyDate":"2017-11-07 10:49:11","createUserId":1,"modifyUserId":null,
     * "loginName":"dinglei","userName":"丁磊","deptId":null,"type":1,"sortCode":0,
     * "deleteState":false,"description":"安装录入（深圳迅创）","createUserName":"admin1","roleIds":null,
     * "depRoleIds":null,"dogId":null,"superUser":false},{"id":162,"createDate":"2017-11-22
     * 18:07:21","modifyDate":"2017-11-22 18:07:21","createUserId":1,"modifyUserId":null,
     * "loginName":"huhao","userName":"胡浩","deptId":null,"type":1,"sortCode":0,
     * "deleteState":false,"description":"查看权限","createUserName":"admin1","roleIds":null,
     * "depRoleIds":null,"dogId":null,"superUser":false},{"id":177,"createDate":"2017-12-14
     * 14:13:41","modifyDate":"2017-12-14 14:13:41","createUserId":1,"modifyUserId":1,
     * "loginName":"yincj","userName":"殷纯镜","deptId":null,"type":0,"sortCode":0,
     * "deleteState":false,"description":"管理（深圳迅创）","createUserName":"admin1","roleIds":null,
     * "depRoleIds":null,"dogId":null,"superUser":true},{"id":178,"createDate":"2017-12-14
     * 14:17:40","modifyDate":"2017-12-14 14:17:40","createUserId":1,"modifyUserId":1,
     * "loginName":"fucheng","userName":"付诚","deptId":null,"type":0,"sortCode":0,
     * "deleteState":false,"description":"管理（深圳迅创）","createUserName":"admin1","roleIds":null,
     * "depRoleIds":null,"dogId":null,"superUser":true}],"last":false,"totalElements":19,
     * "totalPages":2,"sort":[{"direction":"DESC","property":"sortCode","ignoreCase":false,
     * "nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":10,"size":10,
     * "number":0}
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
         * content : [{"id":120,"createDate":"2017-10-20 10:26:02","modifyDate":"2017-10-20
         * 10:26:02","createUserId":1,"modifyUserId":50,"loginName":"xwylcar",
         * "userName":"新沃车管对接账号","deptId":null,"type":2,"sortCode":0,"deleteState":false,
         * "description":"新沃车管对接账号","createUserName":"admin1","roleIds":null,"depRoleIds":null,
         * "dogId":null,"superUser":false},{"id":135,"createDate":"2017-10-20 18:34:33",
         * "modifyDate":"2017-10-20 18:34:33","createUserId":1,"modifyUserId":null,
         * "loginName":"liuyang","userName":"刘洋","deptId":null,"type":1,"sortCode":0,
         * "deleteState":false,"description":"安装录入（深圳迅创）","createUserName":"admin1",
         * "roleIds":null,"depRoleIds":null,"dogId":null,"superUser":false},{"id":136,
         * "createDate":"2017-10-20 18:36:23","modifyDate":"2017-10-20 18:36:23",
         * "createUserId":1,"modifyUserId":null,"loginName":"shigongcheng","userName":"石功成",
         * "deptId":null,"type":1,"sortCode":0,"deleteState":false,"description":"安装录入（深圳迅创）",
         * "createUserName":"admin1","roleIds":null,"depRoleIds":null,"dogId":null,
         * "superUser":false},{"id":137,"createDate":"2017-10-20 18:48:41",
         * "modifyDate":"2017-10-20 18:48:41","createUserId":1,"modifyUserId":1,
         * "loginName":"test","userName":"测试迅创","deptId":null,"type":0,"sortCode":0,
         * "deleteState":false,"description":"测试专用（深圳迅创）","createUserName":"admin1",
         * "roleIds":null,"depRoleIds":null,"dogId":null,"superUser":true},{"id":143,
         * "createDate":"2017-10-28 12:04:57","modifyDate":"2017-10-28 12:04:57",
         * "createUserId":1,"modifyUserId":null,"loginName":"Larry","userName":"赵乐",
         * "deptId":null,"type":1,"sortCode":0,"deleteState":false,"description":"新沃查看",
         * "createUserName":"admin1","roleIds":null,"depRoleIds":null,"dogId":null,
         * "superUser":false},{"id":153,"createDate":"2017-11-06 10:07:53",
         * "modifyDate":"2017-11-06 10:07:53","createUserId":1,"modifyUserId":null,
         * "loginName":"szxc2017","userName":"查看用户","deptId":null,"type":1,"sortCode":0,
         * "deleteState":false,"description":"迅创查看权限","createUserName":"admin1","roleIds":null,
         * "depRoleIds":null,"dogId":null,"superUser":false},{"id":154,"createDate":"2017-11-07
         * 10:49:11","modifyDate":"2017-11-07 10:49:11","createUserId":1,"modifyUserId":null,
         * "loginName":"dinglei","userName":"丁磊","deptId":null,"type":1,"sortCode":0,
         * "deleteState":false,"description":"安装录入（深圳迅创）","createUserName":"admin1",
         * "roleIds":null,"depRoleIds":null,"dogId":null,"superUser":false},{"id":162,
         * "createDate":"2017-11-22 18:07:21","modifyDate":"2017-11-22 18:07:21",
         * "createUserId":1,"modifyUserId":null,"loginName":"huhao","userName":"胡浩",
         * "deptId":null,"type":1,"sortCode":0,"deleteState":false,"description":"查看权限",
         * "createUserName":"admin1","roleIds":null,"depRoleIds":null,"dogId":null,
         * "superUser":false},{"id":177,"createDate":"2017-12-14 14:13:41",
         * "modifyDate":"2017-12-14 14:13:41","createUserId":1,"modifyUserId":1,
         * "loginName":"yincj","userName":"殷纯镜","deptId":null,"type":0,"sortCode":0,
         * "deleteState":false,"description":"管理（深圳迅创）","createUserName":"admin1","roleIds":null,
         * "depRoleIds":null,"dogId":null,"superUser":true},{"id":178,"createDate":"2017-12-14
         * 14:17:40","modifyDate":"2017-12-14 14:17:40","createUserId":1,"modifyUserId":1,
         * "loginName":"fucheng","userName":"付诚","deptId":null,"type":0,"sortCode":0,
         * "deleteState":false,"description":"管理（深圳迅创）","createUserName":"admin1","roleIds":null,
         * "depRoleIds":null,"dogId":null,"superUser":true}]
         * last : false
         * totalElements : 19
         * totalPages : 2
         * sort : [{"direction":"DESC","property":"sortCode","ignoreCase":false,
         * "nullHandling":"NATIVE","ascending":false}]
         * first : true
         * numberOfElements : 10
         * size : 10
         * number : 0
         */

        private boolean last;
        private int totalElements;
        private int totalPages;
        private boolean first;
        private int numberOfElements;
        private int size;
        private int number;
        private List<ContentBean> content;
        private List<SortBean> sort;

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

        public List<SortBean> getSort()
        {
            return sort;
        }

        public void setSort(List<SortBean> sort)
        {
            this.sort = sort;
        }

        public static class ContentBean
        {
            /**
             * id : 120
             * createDate : 2017-10-20 10:26:02
             * modifyDate : 2017-10-20 10:26:02
             * createUserId : 1
             * modifyUserId : 50
             * loginName : xwylcar
             * userName : 新沃车管对接账号
             * deptId : null
             * type : 2
             * sortCode : 0
             * deleteState : false
             * description : 新沃车管对接账号
             * createUserName : admin1
             * roleIds : null
             * depRoleIds : null
             * dogId : null
             * superUser : false
             */

            private int id;
            private String createDate;
            private String modifyDate;
            private int createUserId;
            private int modifyUserId;
            private String loginName;
            private String userName;
            private Object deptId;
            private int type;
            private int sortCode;
            private boolean deleteState;
            private String description;
            private String createUserName;
            private Object roleIds;
            private Object depRoleIds;
            private Object dogId;
            private boolean superUser;

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

            public int getCreateUserId()
            {
                return createUserId;
            }

            public void setCreateUserId(int createUserId)
            {
                this.createUserId = createUserId;
            }

            public int getModifyUserId()
            {
                return modifyUserId;
            }

            public void setModifyUserId(int modifyUserId)
            {
                this.modifyUserId = modifyUserId;
            }

            public String getLoginName()
            {
                return loginName;
            }

            public void setLoginName(String loginName)
            {
                this.loginName = loginName;
            }

            public String getUserName()
            {
                return userName;
            }

            public void setUserName(String userName)
            {
                this.userName = userName;
            }

            public Object getDeptId()
            {
                return deptId;
            }

            public void setDeptId(Object deptId)
            {
                this.deptId = deptId;
            }

            public int getType()
            {
                return type;
            }

            public void setType(int type)
            {
                this.type = type;
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

            public String getCreateUserName()
            {
                return createUserName;
            }

            public void setCreateUserName(String createUserName)
            {
                this.createUserName = createUserName;
            }

            public Object getRoleIds()
            {
                return roleIds;
            }

            public void setRoleIds(Object roleIds)
            {
                this.roleIds = roleIds;
            }

            public Object getDepRoleIds()
            {
                return depRoleIds;
            }

            public void setDepRoleIds(Object depRoleIds)
            {
                this.depRoleIds = depRoleIds;
            }

            public Object getDogId()
            {
                return dogId;
            }

            public void setDogId(Object dogId)
            {
                this.dogId = dogId;
            }

            public boolean isSuperUser()
            {
                return superUser;
            }

            public void setSuperUser(boolean superUser)
            {
                this.superUser = superUser;
            }
        }

        public static class SortBean
        {
            /**
             * direction : DESC
             * property : sortCode
             * ignoreCase : false
             * nullHandling : NATIVE
             * ascending : false
             */

            private String direction;
            private String property;
            private boolean ignoreCase;
            private String nullHandling;
            private boolean ascending;

            public String getDirection()
            {
                return direction;
            }

            public void setDirection(String direction)
            {
                this.direction = direction;
            }

            public String getProperty()
            {
                return property;
            }

            public void setProperty(String property)
            {
                this.property = property;
            }

            public boolean isIgnoreCase()
            {
                return ignoreCase;
            }

            public void setIgnoreCase(boolean ignoreCase)
            {
                this.ignoreCase = ignoreCase;
            }

            public String getNullHandling()
            {
                return nullHandling;
            }

            public void setNullHandling(String nullHandling)
            {
                this.nullHandling = nullHandling;
            }

            public boolean isAscending()
            {
                return ascending;
            }

            public void setAscending(boolean ascending)
            {
                this.ascending = ascending;
            }
        }
    }
}
