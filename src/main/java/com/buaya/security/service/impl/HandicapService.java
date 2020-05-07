package com.buaya.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buaya.security.dto.HandicapDTO;
import com.buaya.security.model.Handicap;
import com.buaya.security.repository.HandicapRepository;

@Service
public class HandicapService {

	@Autowired
	private HandicapRepository handicapRepository;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	public List<Handicap> findAll() {
		return handicapRepository.findAll();
	}

	
	public Handicap findById(long id) {
		
		Optional<Handicap> optional = handicapRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	public HandicapDTO add(HandicapDTO handicapDTO) {
		
		Handicap handicap = dozerBeanMapper.map(handicapDTO, Handicap.class);
		
		return dozerBeanMapper.map(handicapRepository.save(handicap), HandicapDTO.class);
	}
	
	public Handicap add(Handicap handicap) {
		
		return handicapRepository.save(handicap);
	}
	
	public Handicap findByUserId(int userId) {
		
		Optional<Handicap> optional = handicapRepository.findByUserId(userId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	public Handicap update(Handicap handicap) {
		
		return handicapRepository.save(handicap);
	}

}
