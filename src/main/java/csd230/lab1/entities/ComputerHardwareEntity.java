package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;
import java.util.Set;

@Entity
public abstract class ComputerHardwareEntity extends ProductEntity {
    @Column(name = "warranty_months")
    private int warrantyMonths;

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public ComputerHardwareEntity() {
    }

    public ComputerHardwareEntity(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String toString() {
        return "ComputerHardware{" +
                "warrantyMonths=" + warrantyMonths +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComputerHardwareEntity that = (ComputerHardwareEntity) o;
        return warrantyMonths == that.warrantyMonths;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyMonths);
    }
}