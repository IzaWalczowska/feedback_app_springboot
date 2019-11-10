package pl.coderslab.spring_boot_project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


public enum TaskStatus {

//    oczekujące - domyślny dla nowo utworzonych zdań, każde w którego historii nie ma jeszcze żadnych plików
//do recenzji - po dodaniu pliku
//    w trakcie realizacji - po wysłaniu recenzji i kolejnych komentarzy
//    zaakceptowane - po zatwierdzeniu przez klienta

    WAITING,
    TO_REVIEW,
    ONGOING,
    ACCEPTED;



}
