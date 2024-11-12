package webflux.Gradle.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import webflux.Gradle.model.Product;
import webflux.Gradle.model.User;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}
