package co.willotavio.waifuPick;

public class User {
    private int userId;
    private String userEmail;
    private String userName;
    private String userPassword;

    public void setUserId(int userId){
        this.userId = userId;
    }
    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
    public int getUserId(){
        return userId;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public String getUserName(){
        return userName;
    }
    public String getUserPassword(){
        return userPassword;
    }
}

