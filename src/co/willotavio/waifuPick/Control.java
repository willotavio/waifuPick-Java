package co.willotavio.waifuPick;

import java.util.ArrayList;

public class Control {

    public int lastUser = 1;

    ArrayList<User> usersList = new ArrayList<>();

    public User generateUser(String userEmail, String userName, String userPassword){
        User user = new User();
        user.setUserId(lastUser);
        user.setUserEmail(userEmail);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        this.lastUser++;
        return user;
    }

    public void insertUser(User user){
        this.usersList.add(user);
    }

    public void listUsers(){
        for(int i = 0; i < this.usersList.size(); i++) {
                System.out.println(this.usersList.get(i).getUserId() + " " +
                     this.usersList.get(i).getUserEmail() + " "
                     + this.usersList.get(i).getUserName());
        }
    }

    public User login(String userEmail, String userPassword){
        for(User user : usersList){
            if (user.getUserEmail().equals(userEmail) && user.getUserPassword().equals(userPassword)){
                return user;
            }
        }
        return null;
    }

    public boolean userExists(String userEmail){
        for (User account : usersList) {
            if (account.getUserEmail().equals(userEmail)) {
                return false;
            }
        }
        return true;
    }

}
