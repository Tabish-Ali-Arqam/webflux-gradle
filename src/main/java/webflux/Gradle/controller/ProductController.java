package webflux.Gradle.controller;

import com.example.git_library.payload.ProductRequest;
import com.example.git_library.payload.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import org.springframework.http.HttpStatus;
import webflux.Gradle.service.ProductService;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        return productService.create(productRequest);
    }
    @PutMapping("/{id}")
    public Mono<ProductResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest) {
        productRequest.setId(id); // Set the id for the update, if not already present
        return productService.update(productRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }
    @GetMapping
    public Flux<ProductResponse> listProducts() {
        return productService.list();
    }
}
