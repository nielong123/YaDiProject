package gaode.trajectory.bean;

import java.util.List;

/**
 * Created by MrKong on 18/4/4.
 */

public class AlarmStatisticsBean
{

    /**
     * state : 0
     * msg : null
     * result : null
     * obj : {"content":[["2018-04",2370],["2018-03",140810],["2018-02",65717],["2018-01",
     * 135841],["2017-12",155202],["2017-11",57977],["2017-10",33446],["2017-09",1060],
     * ["2004-01",42]],"last":true,"totalElements":9,"totalPages":1,"sort":null,"first":true,
     * "numberOfElements":9,"size":10,"number":0}
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
         * content : [["2018-04",2370],["2018-03",140810],["2018-02",65717],["2018-01",135841],
         * ["2017-12",155202],["2017-11",57977],["2017-10",33446],["2017-09",1060],["2004-01",42]]
         * last : true
         * totalElements : 9
         * totalPages : 1
         * sort : null
         * first : true
         * numberOfElements : 9
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
        private List<List<String>> content;

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

        public List<List<String>> getContent()
        {
            return content;
        }

        public void setContent(List<List<String>> content)
        {
            this.content = content;
        }
    }
}
