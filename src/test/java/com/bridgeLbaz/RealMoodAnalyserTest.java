package com.bridgeLbaz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RealMoodAnalyserTest {
    @Test
    public void givenMessage_WhenSad_ShowReturnSad(){
        RealMoodAnalyser moodAnalyser = new RealMoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is Sad Mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_WhenHappy_ShowReturnHappy() {
        RealMoodAnalyser moodAnalyser = new RealMoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is Happy Mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void nullPointerException() {
        RealMoodAnalyser moodAnalyser = new RealMoodAnalyser();
        String mood = moodAnalyser.analyseMood(null);
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenMessage_whenProper_ReturnHappy() throws MoodAnalysiseException {
        RealMoodAnalyser moodAnalyser = new RealMoodAnalyser();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(MoodAnalysiseException.class);
        moodAnalyser.analyseMood(null);
    }

    @Test
    public void givenMoodAnlayserClass_whenProper_ReturnObject() {
        RealMoodAnalyser realMoodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I an in Happy mood");
        try{
            String mood = realMoodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalysiseException e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenMessage_WhenProper_Return_Object_Reflector() {
        RealMoodAnalyser moodAnalyzer = new RealMoodAnalyser("I an in Happy mood");
        ObjectReflector.dump(moodAnalyzer, 5);
    }

    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject() throws MoodAnalysiseException {
        RealMoodAnalyser realMoodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in the happy mood");
        Assert.assertEquals(new RealMoodAnalyser("I am in the happy mood"),realMoodAnalyser);
    }

    @Test
    public void givenNullMood_ShouldThrowException() {
        RealMoodAnalyser realMoodAnalyser = new RealMoodAnalyser(null);
        try {
            realMoodAnalyser.analyseMood(null);
        }catch (MoodAnalysiseException e){
            Assert.assertEquals(MoodAnalysiseException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenEmptyMood_ShouldThrowException() {
        RealMoodAnalyser realMoodAnalyser = new RealMoodAnalyser("");
        try {
            realMoodAnalyser.analyseMood("");
        }catch (MoodAnalysiseException e){
            Assert.assertEquals(MoodAnalysiseException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenWrongMethod_ShouldThrowException() {
        RealMoodAnalyser realMoodAnalyser = new RealMoodAnalyser();
        try {
            realMoodAnalyser.analyseMood();
        }catch (MoodAnalysiseException e){
            Assert.assertEquals(MoodAnalysiseException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
}
