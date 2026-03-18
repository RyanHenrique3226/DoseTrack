package com.ryan.DoseTrack.Repository;

import com.ryan.DoseTrack.Model.MedicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository <MedicationModel, Integer>{
}