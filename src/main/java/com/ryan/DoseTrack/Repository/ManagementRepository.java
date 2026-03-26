package com.ryan.DoseTrack.Repository;

import com.ryan.DoseTrack.Model.MedicationManagement;
import com.ryan.DoseTrack.Model.MedicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ManagementRepository extends JpaRepository <MedicationManagement, Long> {
    Optional<MedicationManagement> findByMedicationModelAndDate(MedicationModel medicationModel, LocalDate date);
    void deleteByMedicationModelId(long medicationId);
}
