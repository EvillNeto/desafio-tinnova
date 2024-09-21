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
        return String.format("%.02f", (parcial * 100.0f) / total)+ "%";
    }
}
