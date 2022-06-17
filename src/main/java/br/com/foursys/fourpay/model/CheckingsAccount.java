package br.com.foursys.fourpay.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class CheckingsAccount extends Account {

    //@Column(nullable=false)
    private Double  maintenanceRate = 30.00;

    public Double getMaintenanceRate() {
        return maintenanceRate;
    }

    public void setMaintenanceRate(Double maintenanceRate) {
        this.maintenanceRate = maintenanceRate;
    }
}