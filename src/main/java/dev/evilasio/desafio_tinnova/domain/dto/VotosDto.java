package dev.evilasio.desafio_tinnova.domain.dto;

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
public class VotosDto {

    private String validos;

    private String brancos;

    private String nulos;
}
