package domain.chaya;

/**
 * Created by Tony on 4/10/16.
 */
public class Day {

    private String medicine;


    public Day(String name){

        this.medicine = name;
    }

    public String getMedicine(){
        return this.medicine;
    }

    public void setMedicine(String m){
        this.medicine = m;
    }

}
