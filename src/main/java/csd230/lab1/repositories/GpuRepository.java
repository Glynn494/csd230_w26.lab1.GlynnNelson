package csd230.lab1.repositories;

import csd230.lab1.entities.GpuEntity;
import csd230.lab1.pojos.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GpuRepository extends JpaRepository<GpuEntity, Long> {
    Gpu findById(long id);
    List<Gpu> findByWarrantyMonths(int warranty);
    List<Gpu> findByVramGb(int vramGb);
}