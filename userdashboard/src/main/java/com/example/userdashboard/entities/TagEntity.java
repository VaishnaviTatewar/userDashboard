package com.example.userdashboard.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tag", schema = "public", catalog = "userdashboarddb")
public class TagEntity {
    private int tagId;
    private String tagDesc;
    private int score;
    private Integer questionId;
    private Collection<QuestionEntity> questionsByTagId;
    private QuestionEntity questionByQuestionId;

    @Id
    @Column(name = "tag_id", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "tag_desc", nullable = false, length = 255)
    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    @Basic
    @Column(name = "score", nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Basic
    @Column(name = "question_id", nullable = true ,insertable =false ,updatable=false)
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntity tagEntity = (TagEntity) o;
        return tagId == tagEntity.tagId &&
                score == tagEntity.score &&
                Objects.equals(tagDesc, tagEntity.tagDesc) &&
                Objects.equals(questionId, tagEntity.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tagDesc, score, questionId);
    }

    @OneToMany(mappedBy = "tagByTagId")
    public Collection<QuestionEntity> getQuestionsByTagId() {
        return questionsByTagId;
    }

    public void setQuestionsByTagId(Collection<QuestionEntity> questionsByTagId) {
        this.questionsByTagId = questionsByTagId;
    }

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }
}
