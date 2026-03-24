package com.ryan.DoseTrack.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_Medication_Management")
public class MedicationManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "medication_id")
    private MedicationModel medicationModel;

}
