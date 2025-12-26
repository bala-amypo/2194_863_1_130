// src/main/java/com/example/demo/model/FraudRule.java
package com.example.demo.model;

public class FraudRule {
    private Long id;
    private String name;

    public FraudRule() {}
    public FraudRule(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
