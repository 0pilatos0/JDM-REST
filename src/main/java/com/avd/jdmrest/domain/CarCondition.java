package com.avd.jdmrest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class CarCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    public VisibleDamageType visibleDamageType;
    @Getter
    @Setter
    public Boolean yellowDashLights;
    @Getter
    @Setter
    public String extraNotes;

    public CarCondition() {

    }
    
    public CarCondition(VisibleDamageType visibleDamageType, Boolean yellowDashLights, String extraNotes) {
        this.visibleDamageType = visibleDamageType;
        this.yellowDashLights = yellowDashLights;
        this.extraNotes = extraNotes;
    }
}
