package com.example.userdashboard.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "public", catalog = "userdashboarddb")
public class UserEntity {
    private int userId;
    private String userName;
    private Integer communityId;
    private String emailId;
    private String password;
    private Collection<AnswerEntity> answersByUserId;
    private Collection<QuestionEntity> questionsByUserId;
    private CommunityEntity communityByCommunityId;
    private Collection<VoteEntity> votesByUserId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "community_id", nullable = true ,insertable =false ,updatable=false)
    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    @Basic
    @Column(name = "email_id", nullable = false, length = 255)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(communityId, that.communityId) &&
                Objects.equals(emailId, that.emailId) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, communityId, emailId, password);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<AnswerEntity> getAnswersByUserId() {
        return answersByUserId;
    }

    public void setAnswersByUserId(Collection<AnswerEntity> answersByUserId) {
        this.answersByUserId = answersByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<QuestionEntity> getQuestionsByUserId() {
        return questionsByUserId;
    }

    public void setQuestionsByUserId(Collection<QuestionEntity> questionsByUserId) {
        this.questionsByUserId = questionsByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "community_id", referencedColumnName = "community_id")
    public CommunityEntity getCommunityByCommunityId() {
        return communityByCommunityId;
    }

    public void setCommunityByCommunityId(CommunityEntity communityByCommunityId) {
        this.communityByCommunityId = communityByCommunityId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<VoteEntity> getVotesByUserId() {
        return votesByUserId;
    }

    public void setVotesByUserId(Collection<VoteEntity> votesByUserId) {
        this.votesByUserId = votesByUserId;
    }
}
