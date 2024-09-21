package dev.evilasio.desafio_tinnova.domain.filter;

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
public class VehicleFilter {

    MarcaEnum marca;

    Integer ano;

    String cor;

    Boolean vendido;
}
