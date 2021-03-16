package dev.brunocesar.hrworker.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.brunocesar.hrworker.entities.Worker;
import dev.brunocesar.hrworker.repositores.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

	private final WorkerRepository repository;

	public WorkerResources(WorkerRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		var list = repository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
		var worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}

}
