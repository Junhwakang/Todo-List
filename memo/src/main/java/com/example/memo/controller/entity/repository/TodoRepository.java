package com.example.memo.controller.entity.repository;

import com.example.memo.controller.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
