package io.github.core55.user;

import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;
import io.github.core55.meetup.Meetup;
import io.github.core55.core.BaseEntity;
import javax.validation.constraints.Size;
import io.github.core55.location.Location;
import javax.validation.constraints.NotNull;

@Entity
public class User extends BaseEntity {

    @Size(min = 1, max = 50)
    private String nickname;

    @NotNull
    private Double lastLongitude;
    @NotNull
    private Double lastLatitude;

    @NotNull
    private String username;

    private String authenticationToken;

    @ManyToMany
    @JoinTable(
            name = "meetup_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "meetup_id")})
    private List<Meetup> meetups = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Location> locations;

    protected User() {
        super();
    }

    public User(Double lastLongitude, Double lastLatitude) {
        this();
        this.lastLongitude = lastLongitude;
        this.lastLatitude = lastLatitude;
        setCreatedAt();
        setUpdatedAt();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
