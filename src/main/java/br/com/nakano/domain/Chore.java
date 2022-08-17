package br.com.nakano.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chore")
public class Chore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String choreName;

    private String detail;
    @Column(nullable = false)
    private String category;
    private LocalDate deadline;

    public Chore(String choreName, String category, String detail) {
        this.choreName = choreName;
        this.category = category;
        this.detail = detail;
    }

    public Chore(String choreName, String category, LocalDate deadline, String detail) {
        this.choreName = choreName;
        this.category = category;
        this.deadline = deadline;
        this.detail = detail;
    }

}
