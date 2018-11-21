package com.example.zhihao.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class routeInfomation extends AppCompatActivity {
    public static List<String> getAllRouteCode() {
        List<String> code = new ArrayList<String>();
        code.add("88");
        code.add("234");
        code.add("12");
        code.add("54");


        return code;
    }
    public static List<String> getAllRouteName(){
        List<String> name = new ArrayList<>();
        name.add("Terry Fox");
        name.add("Barrheven");
        name.add("Bayshore");
        name.add("Someset");

        return name;
    }
}
