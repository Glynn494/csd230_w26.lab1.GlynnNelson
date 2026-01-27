package csd230.lab1;

import com.github.javafaker.Faker;
import csd230.lab1.entities.*;
import csd230.lab1.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final DiscMagRepository discMagRepository;
    private final CartRepository cartRepository;
    private final MagazineRepository magazineRepository;
    private final TicketRepository ticketRepository;
    private final CpuRepository cpuRepository;
    private final GpuRepository gpuRepository;
    private final ProductRepository productRepository;

    public Application(BookRepository bookRepository, DiscMagRepository discMagRepository, CartRepository cartRepository, MagazineRepository magazineRepository, TicketRepository ticketRepository, CpuRepository cpuRepository, GpuRepository gpuRepository, ProductRepository productRepository) {
        this.bookRepository = bookRepository;
        this.discMagRepository = discMagRepository;
        this.cartRepository = cartRepository;
        this.magazineRepository = magazineRepository;
        this.ticketRepository = ticketRepository;
        this.cpuRepository = cpuRepository;
        this.gpuRepository = gpuRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    @Override
    @Transactional
    public void run(String... args) throws Exception {



        System.out.println("Creating objects.");

        Faker faker = new Faker();

        CartEntity cart = new CartEntity();

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
                java.time.LocalDateTime.now()
        );

        DiscMagEntity discMag = new DiscMagEntity(
                faker.lorem().word() + " Magazine",
                faker.number().randomDouble(2, 1, 100),
                faker.random().nextInt(1, 100),
                faker.random().nextInt(1, 100),
                java.time.LocalDateTime.now(),
                faker.random().nextBoolean()
        );

        TicketEntity ticket = new TicketEntity(
                "Ticket for " + faker.superhero().name() + " movie.",
                faker.number().randomDouble(2, 1, 100)
        );

        CpuEntity cpu = new CpuEntity(
                faker.random().nextInt(1, 24),
                faker.random().nextInt(1, 20)
        );

        GpuEntity gpu = new GpuEntity(
                faker.random().nextInt(1, 24),
                faker.random().nextInt(1, 16)
        );

        System.out.println("Saving products to product repository.");

        productRepository.save(book);

        productRepository.save(magazine);

        productRepository.save(discMag);

        productRepository.save(ticket);

        productRepository.save(cpu);

        productRepository.save(gpu);

        System.out.println("Printing products in product repository.");

        // Fetch and print
        List<ProductEntity> allProducts = productRepository.findAll();
        for(ProductEntity p : allProducts) {
            System.out.println(p.toString());
        }

        System.out.println("Adding products to cart and adding cart to cart repository.");

        //cart.addProduct(book);

        cart.addProduct(magazine);

        cart.addProduct(discMag);

        cart.addProduct(ticket);

        cart.addProduct(cpu);

        cart.addProduct(gpu);

        cartRepository.save(cart);

        System.out.println("Printing carts in cart repository and products in carts.");

        // Fetch and print
        List<CartEntity> allCarts = cartRepository.findAll();
        for(CartEntity c : allCarts) {
            System.out.println(c.toString());
            for(ProductEntity p : c.getProducts()) {
                System.out.println(p.toString());
            }
        }

        System.out.println("Updating products.");

        book.setAuthor(faker.book().author());

        magazine.setTitle(faker.lorem().word() + " Magazine");

        discMag.setTitle(faker.lorem().word() + " Magazine");

        ticket.setDescription("Ticket for " + faker.superhero().name() + " movie.");

        cpu.setCoreCount(faker.random().nextInt(1, 20));

        gpu.setVramGb(faker.random().nextInt(1, 16));

        productRepository.save(book);

        productRepository.save(magazine);

        productRepository.save(discMag);

        productRepository.save(ticket);

        productRepository.save(cpu);

        productRepository.save(gpu);

        //cartRepository.save(cart);

        System.out.println("Printing products in product repository.");

        // Fetch and print
        allProducts = productRepository.findAll();
        for(ProductEntity p : allProducts) {
            System.out.println(p.toString());
        }

        System.out.println("Printing carts in cart repository and products in carts.");

        // Fetch and print
        allCarts = cartRepository.findAll();
        for(CartEntity c : allCarts) {
            System.out.println(c.toString());
            for(ProductEntity p : c.getProducts()) {
                System.out.println(p.toString());
            }
        }

        System.out.println("Deleting carts in cart repository.");

        //cartRepository.deleteAll();

        System.out.println("Sold products.");

        System.out.println("Printing carts in cart repository and products in carts.");

        // Fetch and print
        allCarts = cartRepository.findAll();
        for(CartEntity c : allCarts) {
            System.out.println(c.toString());
            for(ProductEntity p : c.getProducts()) {
                System.out.println(p.toString());
            }
        }

        System.out.println("Deleting products in product repository.");

        //productRepository.deleteAll();

        System.out.println("Sold products.");

        System.out.println("Printing products in product repository.");

        // Fetch and print
        allProducts = productRepository.findAll();
        for(ProductEntity p : allProducts) {
            System.out.println(p.toString());
        }



    }
}
