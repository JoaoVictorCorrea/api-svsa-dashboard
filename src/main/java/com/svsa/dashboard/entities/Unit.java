package com.svsa.dashboard.entities;

import java.io.Serializable;
import java.util.Objects;

public class Unit implements Serializable {

    private Long id;
    private String name;

    public Unit() {}

    public Unit(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unity = (Unit) o;
        return Objects.equals(id, unity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
