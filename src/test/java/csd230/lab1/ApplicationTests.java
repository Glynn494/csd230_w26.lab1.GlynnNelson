package csd230.lab1;

import csd230.lab1.entities.*;
import csd230.lab1.pojos.Product;
import csd230.lab1.repositories.CartRepository;
import csd230.lab1.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // use application db (mysql) not default h2 embedded db
@Transactional(propagation = Propagation.NOT_SUPPORTED)// dont rollback so you can see data in the db

class ApplicationTests {
    @Autowired
    private ProductRepository productRepository;
	@Test
	void productRepositoryTest() {

        Faker faker = new Faker();

        LocalDateTime time = LocalDateTime.parse("2007-12-03T10:15:30");

        BookEntity book = new BookEntity(
                faker.book().title(),
                faker.number().randomDouble(2, 1, 100),
                faker.random().nextInt(1, 100),
                faker.book().author(),
                faker.random().nextInt(1, 10000).toString()
        );

        MagazineEntity magazine = new MagazineEntity(
                faker.lorem().word() + " Magazine",
                faker.number().randomDouble(2, 1, 100),
                faker.random().nextInt(1, 100),
                faker.random().nextInt(1, 100),
                time

        );

        DiscMagEntity discMag = new DiscMagEntity(
                faker.lorem().word() + " Magazine",
                faker.number().randomDouble(2, 1, 100),
                faker.random().nextInt(1, 100),
                faker.random().nextInt(1, 100),
                time,
                faker.random().nextBoolean()
        );

        TicketEntity ticket = new TicketEntity(
                "Ticket for " + faker.superhero().name() + " movie.",
                faker.number().randomDouble(2, 1, 100)
        );

        CPUEntity cpu = new CPUEntity(
                faker.random().nextInt(1, 24),
                faker.random().nextInt(1, 20)
        );

        GPUEntity gpu = new GPUEntity(
                faker.random().nextInt(1, 24),
                faker.random().nextInt(1, 16)
        );

        productRepository.save(book);

        productRepository.save(magazine);

        productRepository.save(discMag);

        productRepository.save(ticket);

        productRepository.save(cpu);

        productRepository.save(gpu);

        Long bookId = book.getId();

        Long magazineId = magazine.getId();

        Long discMagId = discMag.getId();

        Long ticketId = ticket.getId();

        Long cpuId = cpu.getId();

        Long gpuId = gpu.getId();

        ProductEntity product = productRepository.findById(bookId).orElseThrow();

        assertEquals(book, product);

        product = productRepository.findById(magazineId).orElseThrow();

        assertEquals(magazine, product);

        product = productRepository.findById(discMagId).orElseThrow();

        assertEquals(discMag, product);

        product = productRepository.findById(ticketId).orElseThrow();

        assertEquals(ticket, product);

        product = productRepository.findById(cpuId).orElseThrow();

        assertEquals(cpu, product);

        product = productRepository.findById(gpuId).orElseThrow();

        assertEquals(gpu, product);

        book.setAuthor(faker.book().author());

        magazine.setTitle(faker.lorem().word() + " Magazine");

        discMag.setTitle(faker.lorem().word() + " Magazine");

        ticket.setDescription("Ticket for " + faker.superhero().name() + " movie.");

        cpu.setCoreCount(faker.random().nextInt(1, 20));

        gpu.setVramGB(faker.random().nextInt(1, 16));

        productRepository.save(book);

        productRepository.save(magazine);

        productRepository.save(discMag);

        productRepository.save(ticket);

        productRepository.save(cpu);

        productRepository.save(gpu);

        product = productRepository.findById(bookId).orElseThrow();

        assertEquals(book, product);

        product = productRepository.findById(magazineId).orElseThrow();

        assertEquals(magazine, product);

        product = productRepository.findById(discMagId).orElseThrow();

        assertEquals(discMag, product);

        product = productRepository.findById(ticketId).orElseThrow();

        assertEquals(ticket, product);

        product = productRepository.findById(cpuId).orElseThrow();

        assertEquals(cpu, product);

        product = productRepository.findById(gpuId).orElseThrow();

        assertEquals(gpu, product);

        productRepository.deleteAll();

        Assertions.assertFalse(productRepository.findById(bookId).isPresent());

        Assertions.assertFalse(productRepository.findById(magazineId).isPresent());

        Assertions.assertFalse(productRepository.findById(discMagId).isPresent());

        Assertions.assertFalse(productRepository.findById(ticketId).isPresent());

        Assertions.assertFalse(productRepository.findById(cpuId).isPresent());

        Assertions.assertFalse(productRepository.findById(gpuId).isPresent());

	}

    @Autowired
    private CartRepository cartRepository;
    @Test
    void cartRepositoryTest() {
        Faker faker = new Faker();

        CartEntity cart = new CartEntity();

        LocalDateTime time = LocalDateTime.parse("2007-12-03T10:15:30");

        BookEntity book = new BookEntity(
                faker.book().title(),
                faker.number().randomDouble(2, 1, 100),
                faker.random().nextInt(1, 100),
                faker.book().author(),
                faker.random().nextInt(1, 10000).toString()
        );

        MagazineEntity magazine = new MagazineEntity(
                faker.lorem().word() + " Magazine",
                faker.number().randomDouble(2, 1, 100),
                faker.random().nextInt(1, 100),
                faker.random().nextInt(1, 100),
                time

        );

        DiscMagEntity discMag = new DiscMagEntity(
                faker.lorem().word() + " Magazine",
                faker.number().randomDouble(2, 1, 100),
                faker.random().nextInt(1, 100),
                faker.random().nextInt(1, 100),
                time,
                faker.random().nextBoolean()
        );

        TicketEntity ticket = new TicketEntity(
                "Ticket for " + faker.superhero().name() + " movie.",
                faker.number().randomDouble(2, 1, 100)
        );

        CPUEntity cpu = new CPUEntity(
                faker.random().nextInt(1, 24),
                faker.random().nextInt(1, 20)
        );

        GPUEntity gpu = new GPUEntity(
                faker.random().nextInt(1, 24),
                faker.random().nextInt(1, 16)
        );

        cart.addProduct(book);

        cart.addProduct(magazine);

        cart.addProduct(discMag);

        cart.addProduct(ticket);

        cart.addProduct(cpu);

        cart.addProduct(gpu);

        cartRepository.save(cart);

        assertEquals(cartRepository.findById(cart.getId()).orElseThrow(), cart);

        book.setAuthor(faker.book().author());

        magazine.setTitle(faker.lorem().word() + " Magazine");

        discMag.setTitle(faker.lorem().word() + " Magazine");

        ticket.setDescription("Ticket for " + faker.superhero().name() + " movie.");

        cpu.setCoreCount(faker.random().nextInt(1, 20));

        gpu.setVramGB(faker.random().nextInt(1, 16));

        cartRepository.save(cart);

        assertEquals(cartRepository.findById(cart.getId()).orElseThrow(), cart);

        cartRepository.deleteAll();

        Assertions.assertFalse(cartRepository.findById(cart.getId()).isPresent());

    }

}
