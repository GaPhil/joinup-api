/*
  Authors: S. Stefani
 */

package io.github.core55.meetup;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;

import io.github.core55.user.User;
import io.github.core55.core.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
public class Meetup extends BaseEntity {

    @NotNull
    private Double centerLongitude;
    @NotNull
    private Double centerLatitude;

    @NotNull
    private Integer zoomLevel;

    @NotNull
    private String hash;

    private Double pinLongitude;
    private Double pinLatitude;

    @Size(min = 1, max = 50)
    private String name;

    @ManyToMany(mappedBy = "meetups", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<User> users = new ArrayList<>();

    protected Meetup() {
        super();
    }

    public Meetup(Double centerLongitude, Double centerLatitude, Integer zoomLevel) {
        this();
        this.centerLongitude = centerLongitude;
        this.centerLatitude = centerLatitude;
        this.zoomLevel = zoomLevel;
        setCreatedAt();
        setUpdatedAt();
    }

    public Double getCenterLongitude() {
        return centerLongitude;
    }

    public void setCenterLongitude(Double centerLongitude) {
        this.centerLongitude = centerLongitude;
    }

    public Double getCenterLatitude() {
        return centerLatitude;
    }

    public void setCenterLatitude(Double centerLatitude) {
        this.centerLatitude = centerLatitude;
    }

    public Integer getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Double getPinLongitude() {
        return pinLongitude;
    }

    public void setPinLongitude(Double pinLongitude) {
        this.pinLongitude = pinLongitude;
    }

    public Double getPinLatitude() {
        return pinLatitude;
    }

    public void setPinLatitude(Double pinLatitude) {
        this.pinLatitude = pinLatitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}