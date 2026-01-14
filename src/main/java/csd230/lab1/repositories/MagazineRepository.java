package csd230.lab1.repositories;

import csd230.lab1.entities.MagazineEntity;
import csd230.lab1.pojos.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MagazineRepository extends JpaRepository<MagazineEntity, Long> {
    List<Magazine> findMagazineByOrderQty(int orderQty);
    List<Magazine> findMagazineByCurrentIssue(LocalDateTime currentIssue);
    List<Magazine> findMagazineByTitle(String title);
    List<Magazine> findMagazineByCopies(int copies);
    Magazine findById(long id);
}