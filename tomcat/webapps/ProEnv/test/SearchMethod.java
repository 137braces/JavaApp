package test;

public class SearchMethod {

private String alterSql = "Select * from users where gender = ?";
private String man = "";

    public SearchMethod(){
        
    }

    public void filter_gender(String gender){
        if(gender.equals("男性")){
            man = "女性";
        }else if(gender.equals("女性")){
            man = "男性";
        }
    }

    //年齢(age)検索の部分    
    public void ifAge(int age1,int age2){
        //①age1とage2の年齢数値が逆転しても通常のbetween検索ができるの処理
        if(age1 != 0 && age2 != 0){
            if(age1 <= age2){
                alterSql += " and age between " + age1 + " and " + age2;
            }else if(age1 > age2){
                alterSql += " and age between " + age2 + " and " + age1;
            }
        //②age1に年齢が選択され、age2は年齢にこだわりがない場合の処理    
        }else if(age1 != 0 && age2 == 0){
            alterSql += " and age" + " >= " + age1;
        
        //③age1は年齢にこだわりがなく、age2に年齢が選択された場合の処理。
        }else if(age1 == 0 && age2 != 0){
            alterSql += " and age between " + 18 + " and " + age2;
        
        //④age1,age2に両方こだわりがない場合、何もしない。(全検索)
        }else if(age1 == 0 && age2 == 0){

        }
    }

    public String getAlterSql(){
        return alterSql;
    }
    
    public String getMan(){
        return man;
    }

}
