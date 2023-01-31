package at.ac.htlwrn.dto;

import javax.persistence.Column;
import java.sql.Timestamp;

public class PurchaseOrderDto {
    private Long id;

    private String anrede;

    private String vorname;

    private String name;

    private String street;

    private String zipCode;

    private String city;

    private Timestamp date;

    private float price;

    private Timestamp finished;

    private Timestamp canceled;
}
