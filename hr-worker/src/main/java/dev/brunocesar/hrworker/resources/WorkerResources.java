package dev.brunocesar.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);

	@Autowired
	private Environment env;

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

		logger.info("PORT = " + env.getProperty("local.server.port"));

		var worker = repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}

}
