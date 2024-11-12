package webflux.Gradle.service;

import com.example.git_library.payload.ProductRequest;
import com.example.git_library.payload.ProductResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import lombok.RequiredArgsConstructor;
import webflux.Gradle.model.Product;
import webflux.Gradle.repository.ProductRepository;
@Service
@RequiredArgsConstructor
public class ProductService implements BaseClass<ProductRequest, ProductResponse> {

    private final ProductRepository productRepository;

    @Override
    public Mono<ProductResponse> create(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        return productRepository.save(product)
                .map(savedProduct -> new ProductResponse(
                        savedProduct.getId(),
                        savedProduct.getName(),
                        savedProduct.getDescription(),
                        savedProduct.getPrice(),
                        savedProduct.getQuantity()
                ));
    }
    @Override
    public Mono<ProductResponse> update(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());

        return productRepository.save(product)
                .map(updatedProduct -> new ProductResponse(
                        updatedProduct.getId(),
                        updatedProduct.getName(),
                        updatedProduct.getDescription(),
                        updatedProduct.getPrice(),
                        updatedProduct.getQuantity()
                ));
    }
    @Override
    public Mono<Void> delete(Long id) {
        return productRepository.deleteById(id);
    }
    @Override
    public Flux<ProductResponse> list() {
        return productRepository.findAll()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getQuantity()
                ));
    }
}
