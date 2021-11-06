package simple.applications.entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "patient", schema = "work")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "поле обязательно для заполнения")
    @Pattern(message = "имя должно содержать только русские буквы",
            regexp = "^[А-Я[ё]а-я\\s]+$")
    @Size(min=2, max = 30, message = "имя должно быть не менее 2 и " +
            "не более 30 знаков")
    @Column(name = "pat_name")
    private String name;

    @NotBlank(message = "поле обязательно для заполнения")
    @Email(message = "почта должна содержать валидные значения")
    @Column(name = "pat_email")
    private String email;

    @NotBlank(message = "поле обязательно для заполнения")
    @Pattern(message = "номер должен быть валидным",
            regexp = "^((\\+380)(\\d{9}))$")
    @Column(name = "pat_phone")
    private String phoneNumber;

    @Column
    private String comments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date date;

    public Patient(String name, String email, String phoneNumber, String comments) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comments = comments;
    }
    public Patient(){
        this.date = new Date();
    }
}
