package dev.evilasio.desafio_tinnova.domain.form;

import dev.evilasio.desafio_tinnova.domain.entity.Vehicle;
import dev.evilasio.desafio_tinnova.domain.enums.MarcaEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class VehicleForm {

    @NotBlank
    private String veiculo;

    @NotNull
    private MarcaEnum marca;

    @NotNull
    private Integer ano;

    @NotBlank
    private String descricao;

    @NotNull
    private Boolean vendido;

    @NotBlank
    private String cor;

    public Vehicle toEntity() {
        return new Vehicle(null, null, null, veiculo, marca, ano, descricao, vendido, cor);
    }

    public void fullUpdate(Vehicle vehicle) {
        vehicle.setVeiculo(this.veiculo);
        vehicle.setMarca(this.marca);
        vehicle.setAno(this.ano);
        vehicle.setDescricao(this.descricao);
        vehicle.setVendido(this.vendido);
        vehicle.setCor(this.cor);
    }

    public void partialUpdate(Vehicle vehicle) {
        if (this.veiculo != null) {
            vehicle.setVeiculo(this.veiculo);
        }
        if (this.marca != null) {
            vehicle.setMarca(this.marca);
        }
        if (this.ano != null) {
            vehicle.setAno(this.ano);
        }
        if (this.descricao != null) {
            vehicle.setDescricao(this.descricao);
        }
        if (this.vendido != null) {
            vehicle.setVendido(this.vendido);
        }
        if (this.cor != null) {
            vehicle.setCor(this.cor);
        }
    }
}