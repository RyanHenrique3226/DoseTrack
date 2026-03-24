package com.ryan.DoseTrack.Repository;

import com.ryan.DoseTrack.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByReadFalse();
}
