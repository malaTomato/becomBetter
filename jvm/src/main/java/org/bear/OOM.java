package org.bear;

import java.util.ArrayList;
import java.util.List;

import org.bear.dto.User;

public class OOM {
    
    public static void main(String[] args) throws InterruptedException {

   
        for(int i = 0; i < 200; i++){
            
            Thread.sleep(10000L);
            genUserList();
        }
    }

    private static void genUserList(){
        List<User> list =new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add(new User());
        }

    }
}
