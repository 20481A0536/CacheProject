package com.cache;

import java.util.*;
import java.io.*;
public class MovieRecommendationCache {
    //L1 Cache Implementation
    private final int Max_Entries=100;
    private final Map<String,String> recentmovieCache=new LinkedHashMap<String,String>(100,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry<String,String>eldest){
            return size()>Max_Entries;
        }
    };
    //L2 Cache Implementation
    private static final int Max_Entries_L2=1000;
    private final Map<String,String> popularMovieCache=new LinkedHashMap<String,String>(Max_Entries_L2,0.75f,true){
        protected boolean removeEldestEntry(Map.Entry<String,String>eldest){
            return size()>Max_Entries_L2;
        }
    };
    public static void main(String[] args){
        Map<String,String> recentMovieCache=new LinkedHashMap<String,String>(100,0.75f,true);
        Map<String,String> popularMovieCache=new LinkedHashMap<String,String>(1000,0.75f,true);
        String[] genres={"Action","Comedy","Drama","Horror","Romance","Sci-fi","Thriller"};
        for(int i=0;i<2000;i++){
            String movie="Movie"+i;
            String genre=genres[new Random().nextInt(genres.length)];
            popularMovieCache.put(movie,genre);
        }
        for(int i=0;i<100;i++){
            String movie="Movie"+i;
            recentMovieCache.put(movie,"Recently viewed");
        }
        long startTime=System.nanoTime();
        String movie=popularMovieCache.get("Movie100");
        long endTime=System.nanoTime();
        System.out.println("time taken to fetch movie:"+(endTime-startTime)+" nano seconds");

    }
}

