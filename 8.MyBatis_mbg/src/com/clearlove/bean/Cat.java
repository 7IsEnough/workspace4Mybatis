package com.clearlove.bean;

public class Cat {
    private Integer id;

    private String cname;

    private Integer cage;

    private Integer cgender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getCage() {
        return cage;
    }

    public void setCage(Integer cage) {
        this.cage = cage;
    }

    public Integer getCgender() {
        return cgender;
    }

    public void setCgender(Integer cgender) {
        this.cgender = cgender;
    }
}