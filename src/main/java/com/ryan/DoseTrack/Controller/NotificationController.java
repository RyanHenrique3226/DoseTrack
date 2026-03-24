package com.ryan.DoseTrack.Controller;

import com.ryan.DoseTrack.Model.Notification;
import com.ryan.DoseTrack.Service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService service;
    public NotificationController(NotificationService service){this.service = service;}

    @GetMapping
    public List<Notification> findAllNotifications(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateReadById(@PathVariable int id){
        return ResponseEntity.ok(service.updateReadById(id));
    }

    @PutMapping
    public List<Notification> updateRead(){
        return service.updateRead();
    }

}
