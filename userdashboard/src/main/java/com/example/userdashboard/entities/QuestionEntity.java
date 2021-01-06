package com.example.userdashboard.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "question", schema = "public", catalog = "userdashboarddb")
public class QuestionEntity {
    private int questionId;
    private Integer tagId;
    private Integer userId;
    private String description;
    private Collection<AnswerEntity> answersByQuestionId;
    private TagEntity tagByTagId;
    private UserEntity userByUserId;
    private Collection<TagEntity> tagsByQuestionId;

    @Id
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "tag_id", nullable = true,insertable =false ,updatable=false)
    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "user_id", nullable = true,insertable =false ,updatable=false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return questionId == that.questionId &&
                Objects.equals(tagId, that.tagId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, tagId, userId, description);
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<AnswerEntity> getAnswersByQuestionId() {
        return answersByQuestionId;
    }

    public void setAnswersByQuestionId(Collection<AnswerEntity> answersByQuestionId) {
        this.answersByQuestionId = answersByQuestionId;
    }

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    public TagEntity getTagByTagId() {
        return tagByTagId;
    }

    public void setTagByTagId(TagEntity tagByTagId) {
        this.tagByTagId = tagByTagId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<TagEntity> getTagsByQuestionId() {
        return tagsByQuestionId;
    }

    public void setTagsByQuestionId(Collection<TagEntity> tagsByQuestionId) {
        this.tagsByQuestionId = tagsByQuestionId;
    }
}
