package pakage.follwbean;

import java.io.Serializable;

public class FollowBean implements Serializable {
    private String id;
    private String followee_id;
    private String follower_id;
    private int res;
    private boolean resNext;

    //setterメソッド
    public void setId(String id){
        this.id = id;
    }

    public void setFollows(String followee_id, String foloower_id){
        this.followee_id = followee_id;
        this.follower_id = foloower_id;
    }

    public void setRes(int res){
        this.res = res;
    }

    public void setResNext(boolean resNext){
        this.resNext = resNext;
    }


    //getterメソッド
    public String getId(){
        return id;
    }

    public String getFollowee(){
        return followee_id;
    }

    public String getFollower(){
        return follower_id;
    }

    public int getRes(){
        return res;
    }

    public boolean getResNext(){
        return resNext;
    }


}
