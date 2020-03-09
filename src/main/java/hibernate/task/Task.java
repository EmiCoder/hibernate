package hibernate.task;

import hibernate.tasklist.TaskList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="CREATED")
    @NotNull
    private Date created;
    @Column(name="DURATION")
    private int duration;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="TASK_FINANCIALS_ID")
    private TaskFinancialDetails taskFinancialDetails;

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @ManyToOne
    @JoinColumn(name="TASKLIST_ID")
    private TaskList taskList;
}
