package csd230.lab1.repositories;

import csd230.lab1.entities.CPUEntity;
import csd230.lab1.pojos.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CPURepository extends JpaRepository<CPUEntity, Long> {
    CPU findById(long id);
    List<CPU> findByWarrantyMonths(int warranty);
    List<CPU> findByCoreCount(int coreCount);
}