package dev.evilasio.desafio_tinnova.domain.form;

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
public class VotosForm {

    @NotNull
    private Integer validos;

    @NotNull
    private Integer brancos;

    @NotNull
    private Integer nulos;

    public Integer generateTotal() {
        return validos + brancos + nulos;
    }
}
