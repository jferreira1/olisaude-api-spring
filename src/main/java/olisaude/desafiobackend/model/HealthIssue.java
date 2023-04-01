package olisaude.desafiobackend.model;

import jakarta.persistence.*;
import olisaude.desafiobackend.Grade;

import java.util.UUID;

@Entity
public class HealthIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Grade grade;

    @ManyToOne
    private Patient patient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrau() {
        return grade;
    }

    public void setGrau(Grade grau) {
        this.grade = grau;
    }
}
