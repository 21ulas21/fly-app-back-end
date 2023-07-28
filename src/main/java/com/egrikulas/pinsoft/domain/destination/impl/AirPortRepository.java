package com.egrikulas.pinsoft.domain.destination.impl;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirPortRepository extends JpaRepository<AirPort, String> {

    Optional<AirPort> findByCode(String code);
}
