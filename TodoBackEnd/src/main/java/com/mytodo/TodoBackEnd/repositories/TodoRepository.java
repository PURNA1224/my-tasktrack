package com.mytodo.TodoBackEnd.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytodo.TodoBackEnd.entities.TodoEntity;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Integer>{
	List<TodoEntity> findByIsPending(boolean isPending);
}
