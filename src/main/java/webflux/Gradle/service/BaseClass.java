package webflux.Gradle.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseClass<T, R> {
    Mono<R> create(T entity);  // Return Mono<R> instead of R
    Mono<R> update(T entity);  // Return Mono<R> instead of R
    Mono<Void> delete(Long id);
    Flux<R> list();  // Return Flux<R> instead of List<R>
}
