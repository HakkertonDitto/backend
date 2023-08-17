package com.ditto.ditto.repository;

import com.ditto.ditto.entity.Donor;
import com.ditto.ditto.entity.Helper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findAllByHelper(Helper helperEntity);
}
