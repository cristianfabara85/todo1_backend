package com.todo1.hulkstore.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ventas",schema="public")
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ventaid")
    private Long ventaId;

    @Column(name = "productoid")
    private Long productoId;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "cantidad")
    private Long cantidad;

    @Column(name = "fecharegistro")
    private Date fechaRegistro;

    @Column(name = "preciounitario")
    private Double precioUnitario;

    @Column(name = "preciototal")
    private Double precioTotal;


    public Long getVentaId() {
        return ventaId;
    }

}
