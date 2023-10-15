package com.travelpackagemanager.main.services;

import com.travelpackagemanager.main.dtos.ActivityDto;
import com.travelpackagemanager.main.models.Activity;
import com.travelpackagemanager.main.models.Destination;
import com.travelpackagemanager.main.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(ActivityDto activityDto) {
        return this.activityRepository.save(this.getActivityFrom(activityDto));
    }

    public List<Activity> createActivities(List<ActivityDto> activityDtoList) {
        List<Activity> activityList = activityDtoList.stream().map(this::getActivityFrom).toList();
        return this.activityRepository.saveAll(activityList);
    }

    public Activity updateActivityDestination(Long activityId, Destination destination) {
        Activity activity = this.activityRepository.findById(activityId).orElseThrow();
        activity.setDestination(destination);
        return this.activityRepository.save(activity);
    }

    private Activity getActivityFrom(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setName(activityDto.getName());
        activity.setCost(activityDto.getCost());
        activity.setCapacity(activityDto.getCapacity());
        activity.setDestination(activityDto.getDestination());
        activity.setDescription(activityDto.getDescription());
        activity.setEnrolledPassengersCount(activityDto.getEnrolledPassengersCount());
        return activity;
    }
}
