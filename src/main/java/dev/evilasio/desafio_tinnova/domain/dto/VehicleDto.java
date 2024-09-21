package dev.evilasio.desafio_tinnova.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import dev.evilasio.desafio_tinnova.domain.entity.Vehicle;
import dev.evilasio.desafio_tinnova.domain.enums.MarcaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private Long id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String veiculo;

    private MarcaEnum marca;

    private Integer ano;

    private String descricao;

    private Boolean vendido;

    private String cor;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.createdAt = vehicle.getCreatedAt();
        this.updatedAt = vehicle.getUpdatedAt();
        this.veiculo = vehicle.getVeiculo();
        this.marca = vehicle.getMarca();
        this.ano = vehicle.getAno();
        this.descricao = vehicle.getDescricao();
        this.vendido = vehicle.getVendido();
        this.cor = vehicle.getCor();

    }

    public static VehicleDto toDto(Vehicle vehicle){
        return vehicle == null ? null : new VehicleDto(vehicle);
    }

    public static List<VehicleDto> toDto(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleDto::toDto).collect(Collectors.toList());
    }

    public static Page<VehicleDto> toDto(Page<Vehicle> vehicles) {
        return vehicles.map(VehicleDto::toDto);
    }
}
