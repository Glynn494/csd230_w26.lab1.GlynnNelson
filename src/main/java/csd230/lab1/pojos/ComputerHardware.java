package csd230.lab1.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.ComputerHardwareEntity}
 */
public abstract class ComputerHardware extends Product {

    private int warrantyMonths;

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public ComputerHardware() {
    }

    public ComputerHardware(int warrantyMonths) {
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
        ComputerHardware that = (ComputerHardware) o;
        return warrantyMonths == that.warrantyMonths;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(warrantyMonths);
    }
}
