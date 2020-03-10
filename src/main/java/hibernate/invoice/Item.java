package hibernate.invoice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    private Invoice invoice;

    @Column(name = "ITEM_PRICE")
    private BigDecimal price;

    @Column(name = "ITEM_QUANTITY")
    private int quantity;

    @Column(name = "ITEM_VALUE")
    private BigDecimal value;

}
