package dev.evilasio.desafio_tinnova.service.v5;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.evilasio.desafio_tinnova.domain.entity.Vehicle;
import dev.evilasio.desafio_tinnova.domain.filter.VehicleFilter;
import dev.evilasio.desafio_tinnova.domain.form.VehicleForm;

public interface VehicleService {

    public Page<Vehicle> getAll(Pageable pageable, VehicleFilter filter);

    public Vehicle getVeliculo(Long id);

    public Vehicle register(VehicleForm form);

    public Vehicle fullUpdate(Long id, VehicleForm form);

    public Vehicle partialUpdate(Long id, VehicleForm form);

    public void delete(Long id);
}
