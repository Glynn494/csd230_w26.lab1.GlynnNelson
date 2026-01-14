package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class CpuEntity extends ComputerHardwareEntity {
    @Column(name = "core_count")
    private int coreCount;

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public CpuEntity() {
    }

    public CpuEntity(int warrantyMonths, int coreCount) {
        super(warrantyMonths);
        this.coreCount = coreCount;
    }

    @Override
    public void sellItem() {

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "coreCount=" + coreCount +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CpuEntity cpuEntity = (CpuEntity) o;
        return coreCount == cpuEntity.coreCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coreCount);
    }
}