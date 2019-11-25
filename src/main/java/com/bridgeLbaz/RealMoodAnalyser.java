package com.bridgeLbaz;

public class RealMoodAnalyser {
//    private String message;
//
//    public RealMoodAnalyser(String message) {
//        this.message = message;
//    }

    public String analyseMood(String message) {
        try {
            if (message.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        }catch (NullPointerException e) {
            return "HAPPY";
        }
    }
}
