package co.willotavio.waifuPick;

import java.util.ArrayList;

public class User {
    private int lastWaifu = 1;
    private int userId;
    private String userEmail;
    private String userName;
    private String userPassword;
    private ArrayList<Waifu> userWaifus;

    public User(){
        this.userWaifus = new ArrayList<>();
    }

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

    public ArrayList<Waifu> getUserWaifus(){
        return userWaifus;
    }

    public Waifu addWaifu(String waifuName, String waifuRank, String waifuReview){
        Waifu waifu = new Waifu();
        waifu.setWaifuId(lastWaifu);
        waifu.setWaifuName(waifuName);
        waifu.setWaifuRank(waifuRank);
        waifu.setWaifuReview(waifuReview);
        lastWaifu++;
        return waifu;
    }

    public void insertWaifu(Waifu waifu){
        this.userWaifus.add(waifu);
    }

    public void listWaifu(){
        for (Waifu waifu : userWaifus){
            System.out.println("ID: " + waifu.getWaifuId() + " " +
                    "Name: " + waifu.getWaifuName() + " " +
                    "Rank: " + waifu.getWaifuRank() + " " +
                    "Review: " + waifu.getWaifuReview());
        }
    }

    public Waifu accessWaifu(int waifuId){
        for (Waifu waifu : userWaifus){
            if (waifu.getWaifuId() == waifuId){
                return waifu;
            }
        }
        return null;
    }

    public boolean updateWaifu(int waifuId, String attribute, String newValue){
        if(attribute.equals("1")){
            userWaifus.get(waifuId-1).setWaifuName(newValue);
            return true;
        }
        else if(attribute.equals("2")){
            userWaifus.get(waifuId-1).setWaifuRank(newValue);
            return true;
        }
        else if(attribute.equals("3")){
            userWaifus.get(waifuId-1).setWaifuReview(newValue);
            return true;
        }
        else{
            System.out.println("Invalid option!" +
                    "\nTry again");
            return false;
        }
    }

    public boolean deleteWaifu(int waifuId){
        userWaifus.remove(waifuId - 1);
        for(Waifu waifu : userWaifus){
            if(waifu.getWaifuId() > waifuId){
                waifu.setWaifuId(waifu.getWaifuId()-1);
            }
        }
        lastWaifu--;
        return true;
    }

}

