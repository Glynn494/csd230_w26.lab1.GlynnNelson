package csd230.lab1.repositories;

import csd230.lab1.entities.GPUEntity;
import csd230.lab1.pojos.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GPURepository extends JpaRepository<GPUEntity, Long> {
    GPU findById(long id);
    List<GPU> findByWarrantyMonths(int warranty);
    List<GPU> findByVramGB(int vramGB);
}