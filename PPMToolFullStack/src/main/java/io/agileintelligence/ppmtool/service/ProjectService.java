package io.agileintelligence.ppmtool.service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.exception.ProjectIdException;
import io.agileintelligence.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifer(project.getProjectIdentifer().toUpperCase());
            return projectRepository.save(project);
        }
       catch (Exception e){
            throw new ProjectIdException("Project ID " + project.getProjectIdentifer().toUpperCase() + "already exists");
       }
    }

    public List<Project> findAllProject(){
        return (List<Project>) projectRepository.findAll();
    }

    public Project findProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifer(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project does'nt exist");
        }
        return project;
    }

    public void deleteProject(String projectId){
        Project p = projectRepository.findByProjectIdentifer(projectId);

        if(p == null){
            throw new ProjectIdException("Cannot project with ID :" + projectId);
        }
        projectRepository.delete(p);
    }
}
