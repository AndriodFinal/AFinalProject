package com.example.zhihao.finalproject;


import java.util.ArrayList;
import java.util.List;

public class Resources {
    private   String title;
    public Resources(String title){
        this.title=title;
    }
    public static List<Resources> getNewsTitle(){
        List<Resources> Titles = new ArrayList<Resources>();
        Titles.add(new Resources("Crews intensify search for victims of California's deadliest wildfire"));
        Titles.add(new Resources("After chummy summit in Helsinki, Putin and Trump appear headed for bickering in Buenos Aires"));
        Titles.add(new Resources("California man pleads guilty to hoax that led police to kill innocent person"));
        Titles.add(new Resources("U.S. defence secretary defends Mexico border deployment in first troop visit"));
        Titles.add(new Resources("Theresa May persuades cabinet on Brexit divorce, but Parliament challenge to come"));
        Titles.add(new Resources("Reckless rhetoric is the real threat to public faith in Florida recounts: Keith Boag"));
        Titles.add(new Resources("Cirque du Soleil employees balk at performing in Saudi Arabia"));
        Titles.add(new Resources("After facing near extinction, mountain gorilla population grows"));
        Titles.add(new Resources("Prince Charles at 70: Why he's been 'banging the drum' to make a difference, but says he won't meddle as king"));
        Titles.add(new Resources("Israeli defence minister resigns over Gaza ceasefire, in blow to Netanyahu"));
        Titles.add(new Resources("NASA wants Canadian boots on the moon as first step in deep space exploration"));
        Titles.add(new Resources("U.S. Senate leaders unchanged after election, Kevin McCarthy to succeed Paul Ryan"));
        Titles.add(new Resources("Why tech giants don't invest tax cuts in American jobs: Don Pittis"));
        Titles.add(new Resources("Boeing didn't disclose control feature eyed in Indonesia crash, U.S. pilots say"));
        Titles.add(new Resources("U.K. cabinet to consider new draft Brexit deal agreed to by negotiators"));
        Titles.add(new Resources("'El Chapo' a scapegoat, real drug cartel leaders live freely, lawyer tells court"));
        Titles.add(new Resources("Judge to hold hearing Wednesday into CNN's White House lawsuit"));
        Titles.add(new Resources("Melania Trump calls for White House aide to be fired"));
        Titles.add(new Resources("Amazon picks New York, northern Virginia for new headquarters"));
        Titles.add(new Resources("Pink Legacy diamond sets new world record"));
        return Titles;
    }
    public  String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
