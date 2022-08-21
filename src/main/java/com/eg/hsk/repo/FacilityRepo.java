package com.eg.hsk.repo;

import com.eg.hsk.entity.Facility;
import com.eg.hsk.entity.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepo extends JpaRepository<Facility, Long> {
}
