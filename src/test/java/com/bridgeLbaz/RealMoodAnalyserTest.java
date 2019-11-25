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


}
