package com.bridgeLbaz;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static RealMoodAnalyser createMoodAnalyser(String s){
        try {
               Class<?>moodAnalyserClass = Class.forName("com.bridgeLbaz.RealMoodAnalyser");
               Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
               Object moodObj = moodConstructor.newInstance(s);
               return (RealMoodAnalyser) moodObj;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
            return  null;
    }
}
