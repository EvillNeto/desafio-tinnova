package dev.evilasio.desafio_tinnova.service.v2;

import dev.evilasio.desafio_tinnova.domain.dto.VotosDto;
import dev.evilasio.desafio_tinnova.domain.form.VotosForm;

public interface DesafiosService {

    public VotosDto votosLogic(VotosForm form);

    public int[] bubbleSort(int[] intArray);

    public int fatorial(int valor);

    public int multiplos(int valor);
}
