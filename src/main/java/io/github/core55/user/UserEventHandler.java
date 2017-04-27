/**
 * UserEventHandler.java
 *
 * Created by P. Gajland on 2017-04-24.
 */

package io.github.core55.user;

import java.util.UUID;

import io.github.core55.location.Location;
import io.github.core55.location.LocationRepository;
import io.github.core55.location.LocationService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Component
@RepositoryEventHandler
public class UserEventHandler {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public UserEventHandler(UserRepository userRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    @HandleBeforeCreate
    public void setUserTimestampsOnCreate(User user) {
        user.setCreatedAt();
        user.setUpdatedAt();
    }

    @HandleBeforeSave
    public void setUserTimestampOnUpdate(User user) {
        user.setUpdatedAt();
    }

    @HandleBeforeCreate
    public void setUserHash(User user) {
        UserService userService = new UserService(userRepository);
        user.setUsername(userService.generateHash());
    }

    @HandleBeforeCreate
    public void syncLocationListOnCreate(User user) {
        LocationService locationService = new LocationService(locationRepository);
        locationService.updateUserLocationList(user);
    }

    @HandleBeforeSave
    public void syncLocationListOnUpdate(User user) {
        LocationService locationService = new LocationService(locationRepository);
        locationService.updateUserLocationList(user);
    }
}