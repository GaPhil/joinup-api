/**
 * User.java
 *
 * Created by C. Seger on 2017-04-21.
 */

package io.github.core55.user;

import javax.persistence.*;
import io.github.core55.meetup.Meetup;
import io.github.core55.core.BaseEntity;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseEntity {

    @Size(min = 1, max = 50)
    private String nickname;

    @NotNull
    private Double lastLongitude;
    @NotNull
    private Double lastLatitude;

    @ManyToMany
    @JoinTable(
            name = "meetup_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "meetup_id")})
    private List<Meetup> meetups = new ArrayList<>();

    protected User() {
        super();
    }

    public User(Double lastLongitude, Double lastLatitude) {
        this();
        this.lastLongitude = lastLongitude;
        this.lastLatitude = lastLatitude;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getLastLongitude() {
        return lastLongitude;
    }

    public void setLastLongitude(Double lastLongitude) {
        this.lastLongitude = lastLongitude;
    }

    public Double getLastLatitude() {
        return lastLatitude;
    }

    public void setLastLatitude(Double lastLatitude) {
        this.lastLatitude = lastLatitude;
    }

    public List<Meetup> getMeetups() {
        return meetups;
    }

    public void setMeetups(List<Meetup> meetups) {
        this.meetups = meetups;
    }
}
