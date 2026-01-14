package csd230.lab1.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.CPUEntity}
 */
/**
 * DTO for {@link csd230.lab1.entities.CPUEntity}
 */
public class CPU extends ComputerHardware{

    private int coreCount;

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public CPU() {
    }

    public CPU(int warrantyMonths, int coreCount) {
        super(warrantyMonths);
        this.coreCount = coreCount;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "coreCount=" + coreCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CPU cpu = (CPU) o;
        return coreCount == cpu.coreCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coreCount);
    }

    @Override
    public void edit() {

    }

    @Override
    public void initialize() {

    }

    @Override
    public void sellItem() {

    }

    @Override
    public double getPrice() {
        return 0;
    }
}
