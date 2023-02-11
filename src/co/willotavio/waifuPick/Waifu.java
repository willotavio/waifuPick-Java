package co.willotavio.waifuPick;
public class Waifu {
    private int waifuId;
    private String waifuName;
    private String waifuRank;
    private String waifuReview;

    public void setWaifuId(int waifuId){
        this.waifuId = waifuId;
    }
    public void setWaifuName(String waifuName){
        this.waifuName = waifuName;
    }
    public void setWaifuRank(String waifuRank){
        this.waifuRank = waifuRank;
    }
    public void setWaifuReview(String waifuReview){
        this.waifuReview = waifuReview;
    }

    public int getWaifuId(){
        return waifuId;
    }
    public String getWaifuName(){
        return waifuName;
    }
    public String getWaifuRank(){
        return waifuRank;
    }
    public String getWaifuReview(){
        return waifuReview;
    }

}
