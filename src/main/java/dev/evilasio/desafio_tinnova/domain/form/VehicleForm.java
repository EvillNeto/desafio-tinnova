package dev.evilasio.desafio_tinnova.domain.form;

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

    @NotBlank
    private String marca;

    @NotNull
    private Integer ano;

    @NotBlank
    private String descricao;

    @NotNull
    private Boolean vendido;
}
