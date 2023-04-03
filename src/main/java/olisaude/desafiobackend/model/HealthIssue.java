package olisaude.desafiobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import olisaude.desafiobackend.Grade;

import java.util.Objects;
import java.util.UUID;

@Entity
public class HealthIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int grade;
    @ManyToOne()
    @JsonIgnore
    private Patient patient;

    public HealthIssue() {
    }

    public HealthIssue(String name, int grade, Patient patient) {
        this.name = name;
        this.grade = grade;
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthIssue that = (HealthIssue) o;
        return grade == that.grade && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, grade, patient);
    }

    @Override
    public String toString() {
        return "HealthIssue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", patient=" + patient +
                '}';
    }
}
