package com.semicolon.eslamy.Models;

import java.io.Serializable;

/**
 * Created by Delta on 28/03/2018.
 */

public class QuesModel implements Serializable {
    private int id;
    private String question;
    private String answer;
    private int lang;

    public QuesModel() {
    }

    public QuesModel(int id, String question, String answer, int lang) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.lang = lang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }
}
