package ru.univeralex.mvc.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author - Alexander Kostarev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Float neck;
    private Float biceps;
    private Float chest;
    private Float waist;
    private Float hip;
    private Float weight;
}
