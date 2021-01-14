package io.agileintelligence.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "projectName is required")
    private String projectName;
    @NotBlank(message = "projectIdentifier is required")
    @Size(min = 4 , max = 5 , message = "projectIdentifier must be between 4 or 5 char")
    private String projectIdentifer;
    @NotBlank(message = "project description is required")
    private String description;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date endDate;

    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date recDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date modDate;

    public Project(){}

    @PrePersist
    protected void onCreate(){
        this.recDate = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.modDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifer() {
        return projectIdentifer;
    }

    public void setProjectIdentifer(String projectIdentifer) {
        this.projectIdentifer = projectIdentifer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }
}
