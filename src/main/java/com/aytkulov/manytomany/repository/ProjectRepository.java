package com.aytkulov.manytomany.repository;

import com.aytkulov.manytomany.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
