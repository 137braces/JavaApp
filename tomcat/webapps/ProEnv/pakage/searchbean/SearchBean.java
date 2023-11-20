package pakage.searchbean;

public class SearchBean {

//デフォルトのSQL文※検索条件を絞るためには、下記構文にSQL構文の文字列を追加していく。
private String alterSql = "Select * from users where gender = ?";

private String man;

    public String getMan(){
        return man;
    }
    
    public void ifGender(String gender){
        if("男性".equals(gender)){
            man = "女性";

        }else if("女性".equals(gender)){
            man = "男性";
        }
    }
    
    //年齢(age)検索の部分    
    public void ifAge(int age1,int age2){
        //①age1とage2の年齢数値が逆転しても通常のbetween検索ができるの処理
        if(age1 != 0 && age2 != 0){
            if(age1 <= age2){
                alterSql += " and age between " + age1 + " and " + age2;
            }else if(age1 >= age2){
                alterSql += " and age between " + age2 + " and " + age1;
            }
        //②age1に年齢が選択され、age2は年齢にこだわりがない場合の処理    
        }else if(age1 != 0 && age2 == 0){
            //alterSql += " and age" + " >= " + age1;
            alterSql += " and age between " + age1 + " and " + 60;
        
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
    
}
