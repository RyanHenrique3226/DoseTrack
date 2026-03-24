package com.ryan.DoseTrack.Service;

import com.ryan.DoseTrack.Model.Notification;
import com.ryan.DoseTrack.Repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private NotificationRepository repository;

    public NotificationService (NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> findAll(){
        return repository.findByReadFalse();
    }

    public Notification updateReadById(long id){
        Notification notification = repository.findById(id).orElseThrow(() -> new RuntimeException("Notifications not found"));

        notification.setRead(true);

        return repository.save(notification);
    }

    public List<Notification> updateRead(){
        List<Notification> notifications = repository.findAll();
        for (Notification notification : notifications) {
            notification.setRead(true);
        }
        return repository.saveAll(notifications);
    }

}
