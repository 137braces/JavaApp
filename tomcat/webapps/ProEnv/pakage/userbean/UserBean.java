package pakage.userbean;


import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UserBean implements Serializable {
    //各データベースのカラムに登録するプロパティ
    private String name;
    private String email;
    private String password;
    private String address;
    private String job;
    private String hash;

    //SQLでインサートした結果の件数を入れるための変数
    private int res;

    


    //空のコンストラクタ
    public UserBean(){
        super();
    }

    //getterメソッド集
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return hash;
    }

    public String getAddress(){
        return address;
    }

    public String getJob(){
        return job;
    }
    
    public int getRes(){
        return res;
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
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(this.password.getBytes());
            byte[] hashBytes = md.digest();
            hash = Base64.getEncoder().encodeToString(hashBytes);
            System.out.println("Hashed Password: " + hash);
            } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            }
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setJob(String job){
        this.job = job;
    }

    public void setRes(int res){
        this.res = res;
    }

    
}
