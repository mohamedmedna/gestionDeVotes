package com.example.questionnaireapp.model;

import java.util.ArrayList;

public class Question {

    private int questionId;
    private String questionTitre;
    private String questionDesc;

    public Question(int questionId, String questionTitre, String questionDesc) {
        this.questionId = questionId;
        this.questionTitre = questionTitre;
        this.questionDesc = questionDesc;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionTitre() {
        return questionTitre;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}