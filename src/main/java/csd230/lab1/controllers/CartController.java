package csd230.lab1.controllers;
import csd230.lab1.entities.BookEntity;
import csd230.lab1.entities.CartEntity;
import csd230.lab1.entities.OrderEntity;
import csd230.lab1.entities.ProductEntity;
import csd230.lab1.repositories.BookRepository;
import csd230.lab1.repositories.CartRepository;
import csd230.lab1.repositories.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private OrderEntityRepository orderRepository;
    // 1. View the contents of the cart
    @GetMapping
    public String viewCart(Model model) {
        // HARDCODED ID: In a real app, this comes from the Session or SecurityContext
        Long defaultCartId = 1L;

        // Find cart with ID 1, or create a temporary empty one if not found
        CartEntity cart = cartRepository.findById(defaultCartId)
                .orElseGet(() -> {
                    CartEntity newCart = new CartEntity();
                    newCart.setId(defaultCartId);
                    return cartRepository.save(newCart); // Save it so it exists
                });
        model.addAttribute("cart", cart);
        return "cartDetails";
    }
    // 2. Add a specific book to the cart
    @GetMapping("/add/{bookId}")
    public String addToCart(@PathVariable Long bookId) {
        Long defaultCartId = 1L;
        CartEntity cart = cartRepository.findById(defaultCartId).orElse(null);
        BookEntity book = bookRepository.findById(bookId).orElse(null);
        if (cart != null && book != null) {
            cart.addProduct(book); // Uses the helper method in CartEntity
            cartRepository.save(cart); // Updates the Join Table
        }
        return "redirect:/books"; // Send them back to the shopping list
    }

    // 3. Remove item from cart
    @GetMapping("/remove/{bookId}")
    public String removeFromCart(@PathVariable Long bookId) {
        Long defaultCartId = 1L;
        CartEntity cart = cartRepository.findById(defaultCartId).orElse(null);
        BookEntity book = bookRepository.findById(bookId).orElse(null);
        if(cart != null && book != null) {
            cart.getProducts().remove(book);
            cartRepository.save(cart);
        }
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        // HARDCODED ID: In a real app, this comes from the Session or SecurityContext
        Long defaultCartId = 1L;

        CartEntity cart = cartRepository.findById(defaultCartId).orElse(null);

        if(!cart.getProducts().isEmpty()){

            OrderEntity order = new OrderEntity();

            order.setOrderDate(LocalDateTime.now());

            ProductEntity[] products = cart.getProducts().toArray(new ProductEntity[0]);

            double total = 0;

            Set<ProductEntity> productList = new LinkedHashSet<>();

            for (ProductEntity product : products) {

                total = total + product.getPrice();

                if (product instanceof BookEntity) {

                    ((BookEntity) product).setCopies(((BookEntity) product).getCopies() - 1);

                    bookRepository.save((BookEntity) product);

                }

                productList.add(product);

            }

            cart.setProducts(null);

            cartRepository.save(cart);

            order.setTotalAmount(total);

            order.setProducts(productList);

            orderRepository.save(order);

            model.addAttribute("order", order);

            return "orderDetails";

        }

        return "";
    }

}
