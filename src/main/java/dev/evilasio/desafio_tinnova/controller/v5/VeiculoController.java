package dev.evilasio.desafio_tinnova.controller.v5;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.desafio_tinnova.domain.dto.VehicleDto;
import dev.evilasio.desafio_tinnova.domain.filter.VehicleFilter;
import dev.evilasio.desafio_tinnova.domain.form.VehicleForm;
import dev.evilasio.desafio_tinnova.service.v5.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v5")
@RequiredArgsConstructor
public class VeiculoController {

    private final VehicleService vehicleService;

    @GetMapping("/veiculos")
    public ResponseEntity<Page<VehicleDto>> getAll(@ParameterObject VehicleFilter filter,
            @ParameterObject @PageableDefault(page = 0, size = 20) Pageable pageable) {

        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.getAll(pageable, filter)));
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<VehicleDto> getVeiculo(@PathVariable Long id) {
        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.getVeliculo(id)));
    }

    @PostMapping("/veiculos")
    public ResponseEntity<VehicleDto> register(@RequestBody @Valid VehicleForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(VehicleDto.toDto(vehicleService.register(form)));
    }

    @PutMapping("/veiculos/{id}")
    public ResponseEntity<VehicleDto> fullUpdate(@PathVariable Long id, @RequestBody @Valid VehicleForm form) {
        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.fullUpdate(id, form)));
    }

    @PatchMapping("/veiculos/{id}")
    public ResponseEntity<VehicleDto> parcialUpdate(@PathVariable Long id, @RequestBody VehicleForm form) {
        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.partialUpdate(id, form)));
    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
