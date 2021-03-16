package dev.brunocesar.hrworker.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.brunocesar.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
