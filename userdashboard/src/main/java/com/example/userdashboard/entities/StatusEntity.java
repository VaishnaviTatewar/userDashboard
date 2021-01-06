package com.example.userdashboard.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "status", schema = "public", catalog = "userdashboarddb")
public class StatusEntity {
    private int statusId;
    private String statusName;
    private Collection<VoteEntity> votesByStatusId;

    @Id
    @Column(name = "status_id", nullable = false)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "status_name", nullable = false, length = 255)
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity that = (StatusEntity) o;
        return statusId == that.statusId &&
                Objects.equals(statusName, that.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusName);
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<VoteEntity> getVotesByStatusId() {
        return votesByStatusId;
    }

    public void setVotesByStatusId(Collection<VoteEntity> votesByStatusId) {
        this.votesByStatusId = votesByStatusId;
    }
}
