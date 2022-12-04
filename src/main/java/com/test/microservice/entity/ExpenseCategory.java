package com.test.microservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_categories")
public class ExpenseCategory extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public ExpenseCategory() {

    }
    public ExpenseCategory(Long id) {
        setId(id);
    }
    public ExpenseCategory(String name) {
        setName(name);
    }
    public ExpenseCategory(Long id, String name) {
        setId(id);
        setName(name);
    }

    @Override
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Id:" + this.getId() + "\n" + "Name:" + this.getName();
    }

    public int hashCode() {
        int res = 17;
        res = 31 * res + getId().hashCode();
        res = 31 * res + getName().hashCode();
        return res;
    }
    public boolean equals(Object o) {
        if(!(o instanceof ExpenseCategory || o == null)) return false;
        if(o == this) return true;
        ExpenseCategory e = (ExpenseCategory) o;
        return this.getId() == e.getId() && this.getName() == e.getName();
    }

    public void setId(Long id) {
        this.id = id;
    }
}
