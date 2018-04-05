package gaode.trajectory.bean;

/**
 * Created by nielong123 on 2018/4/5.
 */

public class RegisterIdBean {

    /**
     * state : 1
     * msg : registrationId不能为空！
     * result : null
     * obj : null
     * filePre : http://180.101.253.139:30003/file/
     */

    private int state;
    private String msg;
    private Object result;
    private Object obj;
    private String filePre;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getFilePre() {
        return filePre;
    }

    public void setFilePre(String filePre) {
        this.filePre = filePre;
    }
}
