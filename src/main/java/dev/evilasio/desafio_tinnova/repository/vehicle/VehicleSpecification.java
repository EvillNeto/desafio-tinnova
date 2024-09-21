package dev.evilasio.desafio_tinnova.repository.vehicle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import dev.evilasio.desafio_tinnova.domain.entity.Vehicle;
import dev.evilasio.desafio_tinnova.domain.filter.VehicleFilter;
import jakarta.persistence.criteria.Predicate;

public class VehicleSpecification {

    public static Specification<Vehicle> filter(VehicleFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter != null) {
                if (filter.getAno() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("ano"), filter.getAno()));
                }
                if (filter.getMarca() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("marca"),
                            filter.getMarca()));
                }
                if (filter.getCor() != null && !filter.getCor().isBlank()) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("cor")),
                            "%" + filter.getCor().toLowerCase() + "%"));
                }
                if (filter.getVendido() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("vendido"), filter.getVendido()));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
