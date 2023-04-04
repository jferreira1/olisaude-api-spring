package olisaude.desafiobackend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import olisaude.desafiobackend.enums.Gender;
import olisaude.desafiobackend.model.HealthIssue;

import java.util.*;

public class PatientDTO {
    private UUID id;
    private String name;
    private Gender gender;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;

    private ArrayList<HealthIssue> healthIssues;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public PatientDTO() {
    }

    public PatientDTO(UUID id, String name, Gender gender, Date birthdate, ArrayList<HealthIssue> healthIssues) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.healthIssues = healthIssues;
    }

    public ArrayList<HealthIssue> getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(ArrayList<HealthIssue> healthIssues) {
        this.healthIssues = healthIssues;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO that = (PatientDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && gender == that.gender && Objects.equals(birthdate, that.birthdate) && Objects.equals(healthIssues, that.healthIssues) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, birthdate, healthIssues, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                ", healthIssues=" + healthIssues +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
