package com.cache;
import com.google.common.cache.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class GuavaCacheExample{
    public static void main(String[] args) {
        LoadingCache<String,String> cache=CacheBuilder.newBuilder()
                                                    .maximumSize(200000)
                                                    .expireAfterWrite(10, TimeUnit.MINUTES)
                                                    .build(new CacheLoader<String,String>() {
                                                        @Override
                                                        public String load(String key)throws Exception{
                                                            return "value for "+key;
                                                        }
                                                        });
        try{
            String[] genres={"Action","Comedy","Drama","Horror","Romance","Sci-Fi","Thriller"};
            //write a code to generate 20000 movies with random genre
            for(int i=0;i<20000;i++){
                String movie="Movie"+i;
                String genre=genres[new Random().nextInt(genres.length)];
                cache.put(movie,genre);
            }
            //Thread.sleep(1000);
            for(int i=0;i<100;i++){
                long startTime=System.nanoTime();
                String movie=cache.get("Movie92600");
                long endTime=System.nanoTime();
                System.out.println("Time taken to fetch the movie :"+(endTime-startTime)+" nanoseconds");

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
                                                      
    }
}

