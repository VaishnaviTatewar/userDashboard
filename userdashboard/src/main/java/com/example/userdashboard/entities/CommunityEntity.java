package com.example.userdashboard.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "community", schema = "public", catalog = "userdashboarddb")
public class CommunityEntity {
    private int communityId;
    private String communityName;
    private Collection<UserEntity> usersByCommunityId;

    @Id
    @Column(name = "community_id", nullable = false)
    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    @Basic
    @Column(name = "community_name", nullable = true, length = 255)
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityEntity that = (CommunityEntity) o;
        return communityId == that.communityId &&
                Objects.equals(communityName, that.communityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(communityId, communityName);
    }

    @OneToMany(mappedBy = "communityByCommunityId")
    public Collection<UserEntity> getUsersByCommunityId() {
        return usersByCommunityId;
    }

    public void setUsersByCommunityId(Collection<UserEntity> usersByCommunityId) {
        this.usersByCommunityId = usersByCommunityId;
    }
}
