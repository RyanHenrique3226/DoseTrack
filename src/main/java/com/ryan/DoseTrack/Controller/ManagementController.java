package com.ryan.DoseTrack.Controller;

import com.ryan.DoseTrack.Service.ManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medications")
public class ManagementController {

    private final ManagementService service;

    public ManagementController(ManagementService service) {this.service = service;}

    @PostMapping("/{id}/take")
    public ResponseEntity<Void> markAsTaken(@PathVariable int id) {
        service.markAsTaken(id);
        return ResponseEntity.noContent().build();
    }

}
