package br.com.foursys.fourpay.enums.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CheckingAccount {
    @Id
    private Double maintenanceRate;

    public CheckingAccount() {
    }

    //MAINTENANCEDRATE.EQUALS (TAXA DE MANUTENÇÃO)
    public CheckingAccount(Double maintenanceRate) {
        this.maintenanceRate = maintenanceRate;
    }

    public Double getMaintenanceRate() {
        return maintenanceRate;
    }

    public void setMaintenanceRate(Double maintenanceRate) {
        this.maintenanceRate = maintenanceRate;
    }
}

