package com.daniel.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author daniel <daniel.tamang@f1soft.com>
 * created on 2022-06-26
 */
@Entity
@Table(name = "state")
@Data
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
