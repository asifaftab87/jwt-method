package com.buaya.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buaya.security.model.Handicap;

public interface HandicapRepository extends JpaRepository<Handicap, Long>{
	
	public Optional<Handicap> findByUserId(long userId);
	
}
