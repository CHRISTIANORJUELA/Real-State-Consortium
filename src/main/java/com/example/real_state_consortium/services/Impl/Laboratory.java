package com.example.real_state_consortium.services.Impl;

public class Laboratory {
    private ExercisesPracticeImpl exercisesPracticeImpl;
    public Laboratory(){
        exercisesPracticeImpl = new ExercisesPracticeImpl();
    }

    public ExercisesPracticeImpl getExercisesPracticeImpl() {
        return exercisesPracticeImpl;
    }
}
