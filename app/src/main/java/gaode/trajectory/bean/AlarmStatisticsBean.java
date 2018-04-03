package gaode.trajectory.bean;

import java.util.List;

/**
 * Created by nielong123 on 2018/4/3.
 */

public final class AlarmStatisticsBean {


    /**
     * state : 0
     * msg : null
     * result : null
     * obj : [["2018-04",2366],["2018-03",140810],["2018-02",65717],["2018-01",135841],["2017-12",155202],["2017-11",57977],["2017-10",33446],["2017-09",1060],["2004-01",42]]
     * filePre : http://180.101.253.139:30003/file/
     */

    private int state;
    private String msg;
    private String result;
    private String filePre;
    private List<List<String>> obj;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getMsg() {
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

    public List<List<String>> getObj() {
        return obj;
    }

    public void setObj(List<List<String>> obj) {
        this.obj = obj;
    }
}
