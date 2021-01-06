package com.example.userdashboard.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "answer", schema = "public", catalog = "userdashboarddb")
public class AnswerEntity {
    private int answerId;
    private Integer questionId;
    private Integer userId;
    private Integer voteId;
    private String description;
    private QuestionEntity questionByQuestionId;
    private UserEntity userByUserId;
    private VoteEntity voteByVoteId;
    private Collection<VoteEntity> votesByAnswerId;

    @Id
    @Column(name = "answer_id", nullable = false)
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "question_id", nullable = true,insertable =false ,updatable=false)
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "user_id", nullable = true ,insertable =false ,updatable=false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "vote_id", nullable = true ,insertable =false ,updatable=false)
    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
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
        AnswerEntity that = (AnswerEntity) o;
        return answerId == that.answerId &&
                Objects.equals(questionId, that.questionId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(voteId, that.voteId) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, questionId, userId, voteId, description);
    }

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    public QuestionEntity getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(QuestionEntity questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "vote_id", referencedColumnName = "vote_id")
    public VoteEntity getVoteByVoteId() {
        return voteByVoteId;
    }

    public void setVoteByVoteId(VoteEntity voteByVoteId) {
        this.voteByVoteId = voteByVoteId;
    }

    @OneToMany(mappedBy = "answerByAnswerId")
    public Collection<VoteEntity> getVotesByAnswerId() {
        return votesByAnswerId;
    }

    public void setVotesByAnswerId(Collection<VoteEntity> votesByAnswerId) {
        this.votesByAnswerId = votesByAnswerId;
    }
}
