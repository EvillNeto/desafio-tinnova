package dev.evilasio.desafio_tinnova.controller.v1;

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
import dev.evilasio.desafio_tinnova.service.v1.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class VeiculoController {

    private final VehicleService vehicleService;

    @Operation(summary = "Busca paginada de veiculos", description = "Recebe valores de filtro e paginação. Retorna uma pagina filtrada dos veiculos registrados")
    @GetMapping("/veiculos")
    public ResponseEntity<Page<VehicleDto>> getAll(@ParameterObject VehicleFilter filter,
            @ParameterObject @PageableDefault(page = 0, size = 20) Pageable pageable) {

        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.getAll(pageable, filter)));
    }

    @Operation(summary = "Busca veiculo por id")
    @GetMapping("/veiculos/{id}")
    public ResponseEntity<VehicleDto> getVeiculo(@PathVariable Long id) {
        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.getVeliculo(id)));
    }

    @Operation(summary = "Cadastro de veiculo", description = "Recebe formulario de cadastro. Salva veiculo no banco com os dados do formulario")
    @PostMapping("/veiculos")
    public ResponseEntity<VehicleDto> register(@RequestBody @Valid VehicleForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(VehicleDto.toDto(vehicleService.register(form)));
    }

    @Operation(summary = "Atualização completa de veiculo por id", description = "Recebe o id do veiculo e o formulario de cadastro. Subistitui todos os valors da entidade de id informado")
    @PutMapping("/veiculos/{id}")
    public ResponseEntity<VehicleDto> fullUpdate(@PathVariable Long id, @RequestBody @Valid VehicleForm form) {
        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.fullUpdate(id, form)));
    }

    @Operation(summary = "Atualização parcial de veiculo por id", description = "Recebe o id do veiculo e o formulario de cadastro. Subistitui os valors não nulos do formulario na entidade de id informado")
    @PatchMapping("/veiculos/{id}")
    public ResponseEntity<VehicleDto> partialUpdate(@PathVariable Long id, @RequestBody VehicleForm form) {
        return ResponseEntity.ok(VehicleDto.toDto(vehicleService.partialUpdate(id, form)));
    }

    @Operation(summary = "Deleta veiculo por id")
    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
