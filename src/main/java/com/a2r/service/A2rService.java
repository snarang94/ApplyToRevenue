package com.a2r.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2r.exception.RecordNotFoundException;
import com.a2r.model.A2rEntity;
import com.a2r.repository.A2rRepository;

import java.util.List;

@Service
public class A2rService {

	@Autowired
	A2rRepository repository;

	public List<A2rEntity> getAllRecords() {
		List<A2rEntity> a2rEntity = repository.findAll();
		return a2rEntity;
	}

	public A2rEntity getRecordById(Long id) throws RecordNotFoundException {
		A2rEntity a2rEntity =
		        repository
		            .findById(id)
		            .orElseThrow(() -> new RecordNotFoundException("No record exist for given id",id));
		    return a2rEntity;
	}
	
	  public A2rEntity saveRecord(A2rEntity a2rEntity)
	    {    	
		  return repository.save(a2rEntity);
	 }

	  
	  public void deleteRecordById(Long id) throws RecordNotFoundException
	    {
		  A2rEntity a2rEntity =
				  repository
			            .findById(id)
			            .orElseThrow(() -> new RecordNotFoundException("No record exist for given id",id));
			    repository.delete(a2rEntity);
	    }
	  
}
