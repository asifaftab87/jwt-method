package com.buaya.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.buaya.security.model.PlayerStatus;

public interface PlayerStatusRepository extends JpaRepositoryImplementation<PlayerStatus, Long> {

}
