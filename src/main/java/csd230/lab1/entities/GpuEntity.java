package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class GpuEntity extends ComputerHardwareEntity {
    @Column(name = "vram_gb")
    private int vramGb;

    public int getVramGb() {
        return vramGb;
    }

    public void setVramGb(int vramGb) {
        this.vramGb = vramGb;
    }

    public GpuEntity() {
    }

    public GpuEntity(int warrantyMonths, int vramGb) {
        super(warrantyMonths);
        this.vramGb = vramGb;
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
        return "Gpu{" +
                "vramGb=" + vramGb +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GpuEntity gpuEntity = (GpuEntity) o;
        return vramGb == gpuEntity.vramGb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vramGb);
    }
}