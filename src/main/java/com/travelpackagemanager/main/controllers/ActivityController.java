package com.travelpackagemanager.main.controllers;

import com.travelpackagemanager.main.dtos.ActivityDto;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    public Activity createActivity(ActivityDto activityDto) {
        return this.activityService.createActivity(activityDto);
    }

    public Activity updateActivityDestination(Long activityId, Destination destination) {
        return this.activityService.updateActivityDestination(activityId, destination);
    }

}
