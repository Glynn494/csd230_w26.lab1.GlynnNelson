package csd230.lab1.pojos;

import csd230.lab1.entities.GpuEntity;

import java.util.Objects;

/**
 * DTO for {@link GpuEntity}
 */
public class Gpu extends ComputerHardware{

    private int vramGb;

    public Gpu() {
    }

    public Gpu(int warrantyMonths, int vramGb) {
        super(warrantyMonths);
        this.vramGb = vramGb;
    }

    public int getVramGb() {
        return vramGb;
    }

    public void setVramGb(int vramGb) {
        this.vramGb = vramGb;
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

    @Override
    public String toString() {
        return "Gpu{" +
                "vramGb=" + vramGb +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gpu gpu = (Gpu) o;
        return vramGb == gpu.vramGb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vramGb);
    }
}
