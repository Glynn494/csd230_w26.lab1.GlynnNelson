package csd230.lab1.repositories;

import csd230.lab1.entities.DiscMagEntity;
import csd230.lab1.pojos.DiscMag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DiscMagRepository extends JpaRepository<DiscMagEntity, Long> {
    List<DiscMag> findDiscMagByHasDisc(boolean hasDisc);
    List<DiscMag> findDiscMagByOrderQty(int orderQty);
    List<DiscMag> findDiscMagByCurrentIssue(LocalDateTime currentIssue);
    List<DiscMag> findDiscMagByTitle(String title);
    List<DiscMag> findDiscMagByCopies(int copies);
    DiscMag findById(long id);
}