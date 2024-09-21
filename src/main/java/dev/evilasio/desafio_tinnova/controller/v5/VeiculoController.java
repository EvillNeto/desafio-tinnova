package dev.evilasio.desafio_tinnova.controller.v5;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v5")
public class VeiculoController {

    @GetMapping("/veiculos")
    public ResponseEntity<?> getAll(@ParameterObject @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<?> getVeiculo(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/veiculos")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/veiculos/{id}")
    public ResponseEntity<?> fullUpdate(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/veiculos/{id}")
    public ResponseEntity<?> parcialUpdate(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }
}
