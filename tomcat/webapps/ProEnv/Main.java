import pakage.usermodel.UserModel;

public class Main {
    public static void main(String[] args) {
        // Beanを生成
        UserModel usermodel = new UserModel();

        // getterを使ってプロパティを代入
        usermodel.setName("太郎");
        usermodel.setEmail("aaaaaaaa");
        usermodel.setPassword("zzzzzz");

        // setterを使ってプロパティを取得
        System.out.println(usermodel.getName() + usermodel.getEmail()+usermodel.getPassword());
    }
}
