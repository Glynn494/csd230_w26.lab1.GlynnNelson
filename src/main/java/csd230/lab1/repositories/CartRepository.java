package csd230.lab1.repositories;

import csd230.lab1.entities.CartEntity;
import csd230.lab1.entities.ProductEntity;
import csd230.lab1.pojos.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    List<Cart> findByProducts(Set<ProductEntity> products);
    Cart findById(long id);
}