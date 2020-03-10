package hibernate.invoice.dao;


import hibernate.invoice.Invoice;
import hibernate.invoice.Item;
import hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao  itemDao;
    @Autowired
    ProductDao productDao;
    final private String number = "123456";

    @Test
    public void testInvoiceDaoSave() {
        Product product = new Product();
                product.setName("product_1");
        Item item = new Item();
                item.setProduct(product);
                item.setPrice(new BigDecimal("25"));
                item.setQuantity(23);
                item.setValue(new BigDecimal("2"));
        Invoice invoice = new Invoice();
        item.setInvoice(invoice);
        invoice.setNumber(number);
        invoice.getItems().add(item);
        invoiceDao.save(invoice);

        Assert.assertEquals(1, invoice.getItems().size());
    }
}
