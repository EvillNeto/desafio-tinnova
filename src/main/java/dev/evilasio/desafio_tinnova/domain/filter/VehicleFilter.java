package dev.evilasio.desafio_tinnova.domain.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import dev.evilasio.desafio_tinnova.domain.enums.MarcaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class VehicleFilter {

    MarcaEnum marca;

    @Schema(example = "2016")
    Integer ano;

    @Schema(example = "vermelho")
    String cor;

    @Schema(example = "false")
    Boolean vendido;

    @Schema(name = "cadastroApartirDe", example = "2000-10-31")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate cadastroApartirDe;
}
