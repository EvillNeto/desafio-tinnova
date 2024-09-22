package dev.evilasio.desafio_tinnova.controller.v2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.desafio_tinnova.domain.dto.VotosDto;
import dev.evilasio.desafio_tinnova.domain.form.VotosForm;
import dev.evilasio.desafio_tinnova.service.v2.DesafiosService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v2")
@RequiredArgsConstructor
public class DesafiosLogicaController {

    private final DesafiosService desafiosService;

    @Operation(summary = "Calculo de porcentagens dos votos informados", description = "Recebe os valores dos votos: validos, brancos e  nulos. Retorna as porcentagens de cada tipo de voto")
    @PostMapping("/votos")
    public ResponseEntity<VotosDto> votos(@RequestBody @Valid VotosForm form) {
        return ResponseEntity.ok(desafiosService.votosLogic(form));
    }

    @Operation(summary = "Algoritimo de bubble sort", description = "Recebe array de valors inteiros. Retorna array com valores ordenados")
    @PostMapping("/bubble-sort")
    public ResponseEntity<Object> bubbleSort(@RequestBody() int[] intArray) {

        return ResponseEntity.ok(desafiosService.bubbleSort(intArray));
    }

    @Operation(summary = "Algoritimo fatorial", description = "Recebe um valor inteiro. Retorna o fatorial referente a numero informado")
    @PostMapping("/fatorial")
    public ResponseEntity<Object> fatorial(@RequestParam int valor) {

        return ResponseEntity.ok(desafiosService.fatorial(valor));
    }

    @Operation(summary = "Calculo dos multiplos de 3 e 5", description = "Recebe um valor inteiro. Retorna a soma de todos os numero multiplos de 3 e 5 de 1 até o informado")
    @PostMapping("/multiplos")
    public ResponseEntity<Object> multiplos(@RequestParam int valorFinal) {

        return ResponseEntity.ok(desafiosService.multiplos(valorFinal));
    }

}
