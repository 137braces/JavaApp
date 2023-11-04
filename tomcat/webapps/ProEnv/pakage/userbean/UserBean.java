package pakage.userbean;


import java.io.Serializable;

public class UserBean implements Serializable {
    private String name;
    private String email;
    private String password;
    private String address;
    private String job;

    //getterメソッド集
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getAddress(){
        return address;
    }

    public String getJob(){
        return job;
    }
    

    //setterメソッド集
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setJob(String job){
        this.job = job;
    }

    //空のコンストラクタ
    public UserBean(){

    }
    
}
