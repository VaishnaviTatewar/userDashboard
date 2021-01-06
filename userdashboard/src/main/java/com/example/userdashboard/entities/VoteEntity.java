package com.example.userdashboard.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "vote", schema = "public", catalog = "userdashboarddb")
public class VoteEntity {
    private int voteId;
    private Integer userId;
    private Integer statusId;
    private Integer answerId;
    private Collection<AnswerEntity> answersByVoteId;
    private UserEntity userByUserId;
    private StatusEntity statusByStatusId;
    private AnswerEntity answerByAnswerId;

    @Id
    @Column(name = "vote_id", nullable = false)
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
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
    @Column(name = "status_id", nullable = true,insertable =false ,updatable=false)
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "answer_id", nullable = true,insertable =false ,updatable=false)
    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteEntity that = (VoteEntity) o;
        return voteId == that.voteId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(statusId, that.statusId) &&
                Objects.equals(answerId, that.answerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteId, userId, statusId, answerId);
    }

    @OneToMany(mappedBy = "voteByVoteId")
    public Collection<AnswerEntity> getAnswersByVoteId() {
        return answersByVoteId;
    }

    public void setAnswersByVoteId(Collection<AnswerEntity> answersByVoteId) {
        this.answersByVoteId = answersByVoteId;
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
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "answer_id", referencedColumnName = "answer_id")
    public AnswerEntity getAnswerByAnswerId() {
        return answerByAnswerId;
    }

    public void setAnswerByAnswerId(AnswerEntity answerByAnswerId) {
        this.answerByAnswerId = answerByAnswerId;
    }
}
