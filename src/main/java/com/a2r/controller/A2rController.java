package com.a2r.controller;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a2r.service.A2rService;
import com.a2r.exception.RecordNotFoundException;
import com.a2r.model.A2rEntity;

@RestController
@RequestMapping("/arc")
public class A2rController {

	@Autowired
	A2rService service;

	/**
	 * Get all arc list.
	 *
	 * @return the list
	 */
	@GetMapping
	public ResponseEntity<List<A2rEntity>> getAllArc() {
		List<A2rEntity> list = service.getAllRecords();
		return new ResponseEntity<List<A2rEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * Gets arc by id.
	 *
	 * @return the record by id
	 * @throws RecordNotFoundException the resource not found exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<A2rEntity> getArcById(@PathVariable(value = "id") Long arcId) throws RecordNotFoundException {
		A2rEntity entity = service.getRecordById(arcId);
		return new ResponseEntity<A2rEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * Create arc record.
	 *
	 * @return the arc record
	 */
	@PostMapping
	public ResponseEntity<A2rEntity> createArc(@Valid @RequestBody A2rEntity entity) {
		A2rEntity updatedEntity = service.saveRecord(entity);
		return new ResponseEntity<A2rEntity>(updatedEntity, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * Update arc response entity.
	 *
	 * @return the response entity
	 * @throws RecordNotFoundException the resource not found exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<A2rEntity> updateArc(@PathVariable(value = "id") Long arcId,
			@Valid @RequestBody A2rEntity entity) throws RecordNotFoundException {
		A2rEntity updatedEntity = service.getRecordById(arcId);

		updatedEntity.setPartnerId(entity.getPartnerId());
		updatedEntity.setSolutionId(entity.getSolutionId());
		updatedEntity.setSolutionDescr(entity.getSolutionDescr());
		updatedEntity.setArcStatus(entity.getArcStatus());
		updatedEntity.setUpdatedAt(new Date());

		final A2rEntity finalEntity = service.saveRecord(updatedEntity);
		return new ResponseEntity<A2rEntity>(finalEntity, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * Delete arc.
	 *
	 * @return the map
	 * @throws RecordNotFoundException the exception
	 */
	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteArc(@PathVariable(value = "id") Long arcId) throws RecordNotFoundException {
		service.deleteRecordById(arcId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
