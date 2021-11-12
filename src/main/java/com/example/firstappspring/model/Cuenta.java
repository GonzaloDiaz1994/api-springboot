package com.example.firstappspring.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id", nullable = false)
    private Long cuenta_id;
    @Column(name = "alias", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private String alias;
    @Column(name = "dinero", nullable = false)
    private Long dinero;

    public Cuenta(String alias, long dinero) {
        this.alias = alias;
        this.dinero = dinero;
    }
}
