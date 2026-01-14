package csd230.lab1.repositories;

import csd230.lab1.entities.CpuEntity;
import csd230.lab1.pojos.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpuRepository extends JpaRepository<CpuEntity, Long> {
    Cpu findById(long id);
    List<Cpu> findByWarrantyMonths(int warranty);
    List<Cpu> findByCoreCount(int coreCount);
}