package io.agileintelligence.ppmtool.repository;

import io.agileintelligence.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    public Project findByProjectIdentifer(String projectId);

    @Override
    public Iterable<Project> findAll();

}
