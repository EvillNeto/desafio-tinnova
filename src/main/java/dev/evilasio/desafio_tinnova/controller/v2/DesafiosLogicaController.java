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
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v2")
@RequiredArgsConstructor
public class DesafiosLogicaController {

    private final DesafiosService desafiosService;

    @PostMapping("/votos")
    public ResponseEntity<VotosDto> votos(@RequestBody @Valid VotosForm form) {
        return ResponseEntity.ok(desafiosService.votosLogic(form));
    }

    @PostMapping("/bubble-sort")
    public ResponseEntity<Object> bubbleSort(@RequestBody() int[] intArray) {

        return ResponseEntity.ok(desafiosService.bubbleSort(intArray));
    }

    @PostMapping("/fatorial")
    public ResponseEntity<Object> fatorial(@RequestParam int valor) {

        return ResponseEntity.ok(desafiosService.fatorial(valor));
    }

    @PostMapping("/multiplos")
    public ResponseEntity<Object> multiplos(@RequestParam int valorFinal) {

        return ResponseEntity.ok(desafiosService.multiplos(valorFinal));
    }

}
