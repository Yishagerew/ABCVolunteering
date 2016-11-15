package edu.mum.abcVolunteering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.abcVolunteering.model.Task;

public interface TaskDAO extends JpaRepository<Task, Long> {
	List<Task>findTaskByTaskId(int taskId);
	Long deleteByTaskId(int taskId);
}
