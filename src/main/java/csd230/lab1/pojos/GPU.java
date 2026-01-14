package csd230.lab1.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.GPUEntity}
 */
public class GPU extends ComputerHardware{

    private int vramGB;

    public GPU() {
    }

    public GPU(int warrantyMonths, int vramGB) {
        super(warrantyMonths);
        this.vramGB = vramGB;
    }

    public int getVramGB() {
        return vramGB;
    }

    public void setVramGB(int vramGB) {
        this.vramGB = vramGB;
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
        return "GPU{" +
                "vramGB=" + vramGB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GPU gpu = (GPU) o;
        return vramGB == gpu.vramGB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vramGB);
    }
}
