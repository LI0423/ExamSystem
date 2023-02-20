package com.example.serversystem.dto;

public class ResourceQueryDTO {

    //题号
    private Integer num;

    //问题
    private String question;

    //选项
    private String choices;

    //答案
    private String answer;

    //分数
    private String score;

    //类型，1-单选，2-多选，3-判断
    private Integer type;

    private Integer sectionType;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSectionType() {
        return sectionType;
    }

    public void setSectionType(Integer sectionType) {
        this.sectionType = sectionType;
    }
}
