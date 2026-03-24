package com.ryan.DoseTrack.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_Medication")
public class MedicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Frequency")
    private int frequency;

    @NotNull
    @Column(name = "Term_Days")
    private int termDays;

    @Column(name = "Start_Date")
    private LocalDate startDate;

    @Column(name = "End_Date")
    private LocalDate endDate;

}
