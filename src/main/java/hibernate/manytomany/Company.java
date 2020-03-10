package hibernate.manytomany;

import hibernate.task.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.findByThreeFirstCharacters",
        query = "select * from Companies where SUBSTRING(COMPANY_NAME, 1, 3) = :THREE_FIRST_CHARACTERS",
        resultClass = Company.class
)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "COMPANIES")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPANY_ID")
    private int id;
    @Column(name="COMPANY_NAME")
    @NotNull
    private String name;

    public Company(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "companies")
    List<Employee> employees = new ArrayList<>();


}
