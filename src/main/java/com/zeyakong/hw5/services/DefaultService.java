package com.zeyakong.hw5.services;

import com.zeyakong.hw5.models.Default;
import org.springframework.stereotype.Service;

/**
 * Created by Zeya Kong
 * On 4/5/2018 10:07 PM.
 */
@Service
public class DefaultService {
    private Default instance =null;

    //singleton
    public Default getDefault(){
        if(instance==null){
            instance = new Default();
            return instance;
        }else{
            return instance;
        }
    }
}
