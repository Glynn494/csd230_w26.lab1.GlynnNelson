package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class GPUEntity extends ComputerHardwareEntity {
    @Column(name = "vram_gb")
    private int vramGB;

    public int getVramGB() {
        return vramGB;
    }

    public void setVramGB(int vramGB) {
        this.vramGB = vramGB;
    }

    public GPUEntity() {
    }

    public GPUEntity(int warrantyMonths, int vramGB) {
        super(warrantyMonths);
        this.vramGB = vramGB;
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
        return "GPU{" +
                "vramGB=" + vramGB +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GPUEntity gpuEntity = (GPUEntity) o;
        return vramGB == gpuEntity.vramGB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vramGB);
    }
}