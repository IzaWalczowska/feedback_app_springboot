package pl.coderslab.spring_boot_project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum TaskStatus {

    WAITING,
    TO_REVIEW,
    ONGOING,
    ACCEPTED;

}
