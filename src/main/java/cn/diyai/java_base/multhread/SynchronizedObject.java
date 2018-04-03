package cn.diyai.java_base.multhread;

public class SynchronizedObject {

    private String userName = "a";
    private String password = "aa";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void printString(String userName,String password){
        try{
            this.userName = userName;
            Thread.sleep(10000);
            this.password = password;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "SynchronizedObject{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
