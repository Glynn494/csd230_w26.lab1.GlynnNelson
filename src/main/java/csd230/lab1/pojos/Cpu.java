package csd230.lab1.pojos;

import csd230.lab1.entities.CpuEntity;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.CpuEntity}
 */
/**
 * DTO for {@link CpuEntity}
 */
public class Cpu extends ComputerHardware{

    private int coreCount;

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public Cpu() {
    }

    public Cpu(int warrantyMonths, int coreCount) {
        super(warrantyMonths);
        this.coreCount = coreCount;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "coreCount=" + coreCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cpu cpu = (Cpu) o;
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
