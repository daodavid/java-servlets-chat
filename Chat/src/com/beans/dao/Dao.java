package com.beans.dao;

import java.util.List;

import com.beans.entity.Gender;
import com.beans.entity.Town;
import com.beans.entity.User;
import com.beans.entity.Massage;

public interface Dao {
    boolean addUser(User user);
    User getUser(String username);
    List<User> getUsers();
    Gender getGender(String name);
    Town getTown(String name);
    boolean addMassage(Massage msg);
    Massage getMassage();
    List<Massage> getMassage(String usenameMassge,String withRetriever);
    List<Massage> getMassageRead(String usenameMassage,String NotRead);
    boolean deleteMassage(String msg);
    boolean deleteMassage(int id);
    
    
}
