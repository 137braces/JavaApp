package pakage.userbean;


import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UserBean implements Serializable {
    //各データベースのカラムに登録するプロパティ
    private String id;
    private String name;
    private String email;
    private String password;
    private int age;
    private String gender;
    private String address;
    private String job;
    private String hash;
    private String image;
    

    //SQLでインサートした結果の件数を入れる変数
    private int res;

    //SQLでSELECT検索したときの結果を入れる変数
    private boolean resNext;


    //正規表現パターンの概要：
    //- `(?=.*[a-z])`：少なくとも1つの小文字を含む
    //- `(?=.*[A-Z])`：少なくとも1つの大文字を含む
    //- `(?=.*\d)`：少なくとも1つの数字を含む
    //- `(?=.*[@$!%*?&])`：少なくとも1つの記号を含む
    //- `[A-Za-z\d@$!%*?&]{8,}`：アルファベット（大文字・小文字）、数字、記号からなる8文字以上の文字列
    final private String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";


    //空のコンストラクタ
    public UserBean(){
        super();
    }

    //getterメソッド集
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getHash(){
        return hash;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
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

    public boolean getResNext(){
        return resNext;
    }

    public String getImage(){
        return image;
    }



    //setterメソッド集
    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }


    //変更したいパスワードをハッシュ化するためのメソッド。
    public void setHash(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hashBytes = md.digest();
            hash = Base64.getEncoder().encodeToString(hashBytes);

            } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            }
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setJob(String job){
        this.job = job;
    }

    public void setImage(String image){
        this.image = image;
    }

    //executeUpdateの戻り値(int)をセット
    public void setRes(int res){
        this.res = res;
    }

    public void setResNext(boolean resNext){
        this.resNext  = resNext;
    }

    

    public boolean validatePassword(String password){
        if(password.matches(pattern)){
            return true;

        }else {
            return false;
        }
    }


    public void ifGender(String gender){
        if("男性".equals(gender)){
            setGender("女性");

        }else if("女性".equals(gender)){
            setGender("男性");
        }
    }

    
}  
