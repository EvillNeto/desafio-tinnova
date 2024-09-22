package dev.evilasio.desafio_tinnova.service.v2;

import org.springframework.stereotype.Service;

import dev.evilasio.desafio_tinnova.domain.dto.VotosDto;
import dev.evilasio.desafio_tinnova.domain.form.VotosForm;

@Service
public class DesafiosServiceImpl implements DesafiosService {

    @Override
    public VotosDto votosLogic(VotosForm form) {

        Integer total = form.generateTotal();

        return new VotosDto(porcentagem(form.getValidos(), total), porcentagem(form.getBrancos(), total),
                porcentagem(form.getNulos(), total));
    }

    private String porcentagem(Integer parcial, Integer total) {
        return String.format("%.02f", (parcial * 100.0f) / total) + "%";
    }

    @Override
    public int[] bubbleSort(int[] intArray) {

        int extra = 0;

        for (int i = 0; i < intArray.length; i++) {

            for (int j = 0; j < intArray.length - 1; j++) {

                if (intArray[j] > intArray[j + 1]) {
                    extra = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = extra;
                }
            }
        }
        return intArray;
    }

    @Override
    public int fatorial(int valor) {

        int result = 1;

        while (valor > 0) {
            result *= valor;
            valor--;
        }
        return result;
    }

    @Override
    public int multiplos(int valor) {
        int result = 0;

        while (valor > 0) {

            if (valor % 3 == 0 || valor % 5 == 0) {
                result += valor;
            }
            valor--;
        }
        return result;
    }
}
