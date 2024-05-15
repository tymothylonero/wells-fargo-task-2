package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;

    @Column(nullable = false)
    private Timestamp creationDate;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    protected Portfolio() {

    }

    public Portfolio(Client client, Timestamp creationDate, List<Security> securities) {
        this.client = client;
        this.creationDate = creationDate;
        this.securities = securities;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
