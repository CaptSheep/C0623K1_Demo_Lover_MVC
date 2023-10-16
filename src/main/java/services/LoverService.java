package services;

import model.Lover;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoverService {
    List<Lover> loverList = new ArrayList<>();

    public LoverService(){
        loverList.add(new Lover(1,"Maria Ozawa","Japan","01234"));
        loverList.add(new Lover(2,"Duong","Phung - Dan Phuong","0353415266"));
    }

    public List<Lover> showAllLover(){
        return loverList;
    }

    public void addLover(Lover lover){
        lover.setId((int)(Math.random()*1000));
        loverList.add(lover);

    }
    public void updateLover(int id ,Lover lover){
        Lover findLover = this.findById(id);
        if(findLover != null){
            findLover.setName(lover.getName());
            findLover.setAddress(lover.getAddress());
            findLover.setPhoneNumber(lover.getPhoneNumber());
        }
    }
    public void deleteLover(int id){
        Lover findLover = this.findById(id);
        if(findLover != null){
            loverList.remove(findLover);
        }
    }

    public Lover findById(int id){
        for (Lover item : loverList){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

}
