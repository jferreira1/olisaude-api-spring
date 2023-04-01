package olisaude.desafiobackend.DTO;

import olisaude.desafiobackend.enums.Gender;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class PatientDTO {
    private UUID id;
    private String name;
    private Gender gender;
    private Date birthDate;
    //private List<HealthIssue> healthIssues;
    private Date createdAt;
    private Date updatedAt;

    public PatientDTO() {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && gender == that.gender && Objects.equals(birthDate, that.birthDate) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, birthDate, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
