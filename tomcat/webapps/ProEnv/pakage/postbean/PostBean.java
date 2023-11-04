package pakage.postbean;

import java.io.Serializable;

public class PostBean implements Serializable {
    private String title;
    private String content;

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }


    //空のコンストラクタ
    public PostBean(){

    }
}
