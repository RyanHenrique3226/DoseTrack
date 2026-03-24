package com.ryan.DoseTrack.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    private LocalDateTime dateTime;
    private boolean read;

}
