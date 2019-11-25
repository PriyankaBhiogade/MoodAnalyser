package com.bridgeLbaz;

public class RealMoodAnalyser {
    private String message;
    public String a;


    public RealMoodAnalyser() {

    }
    public RealMoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalysiseException {
        this.message = message;
        return  analyseMood();
    }

    public String analyseMood() throws MoodAnalysiseException {
        try {
            if(message.length() == 0)
                throw new  MoodAnalysiseException(MoodAnalysiseException.ExceptionType.ENTERED_EMPTY,"Please Enter Proper Mood");
            if (message.contains("SAD")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        }catch (NullPointerException e) {
            throw new MoodAnalysiseException(MoodAnalysiseException.ExceptionType.ENTERED_NULL,"Please Enter Proper Mood");
        }catch (NoSuchMethodError e){
            throw new MoodAnalysiseException(MoodAnalysiseException.ExceptionType.NO_SUCH_METHOD,"Method not found");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this.message.equals(((RealMoodAnalyser) obj).message))
            return true;
        return false;
    }
}

