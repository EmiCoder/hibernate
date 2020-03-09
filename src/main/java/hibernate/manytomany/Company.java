package hibernate.manytomany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
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
