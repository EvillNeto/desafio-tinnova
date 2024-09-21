package dev.evilasio.desafio_tinnova.controller.v2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v2")
@RequiredArgsConstructor
public class DesafiosLogicaController {

    @PostMapping("/votos")
    public ResponseEntity<Object> votos() {

        return ResponseEntity.ok(null);
    }

    @PostMapping("/bubble-sort")
    public ResponseEntity<Object> bubbleSort() {

        return ResponseEntity.ok(null);
    }

    @PostMapping("/fatorial")
    public ResponseEntity<Object> fatorial() {

        return ResponseEntity.ok(null);
    }

    @PostMapping("/multiplos")
    public ResponseEntity<Object> multiplos() {

        return ResponseEntity.ok(null);
    }

}
