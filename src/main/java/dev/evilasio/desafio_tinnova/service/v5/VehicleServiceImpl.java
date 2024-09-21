package dev.evilasio.desafio_tinnova.service.v5;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.evilasio.desafio_tinnova.domain.entity.Vehicle;
import dev.evilasio.desafio_tinnova.domain.filter.VehicleFilter;
import dev.evilasio.desafio_tinnova.domain.form.VehicleForm;
import dev.evilasio.desafio_tinnova.repository.vehicle.VehicleRepository;
import dev.evilasio.desafio_tinnova.repository.vehicle.VehicleSpecification;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Page<Vehicle> getAll(Pageable pageable, VehicleFilter filter) {
        return vehicleRepository.findAll(VehicleSpecification.filter(filter), pageable);
    }

    @Override
    public Vehicle getVeliculo(Long id) {
        return vehicleRepository.findById(id).orElseThrow();
    }

    @Override
    public Vehicle register(VehicleForm form) {
        return vehicleRepository.save(form.toEntity());
    }

    @Override
    public Vehicle fullUpdate(Long id, VehicleForm form) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();

        form.fullUpdate(vehicle);

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle partialUpdate(Long id, VehicleForm form) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();

        form.partialUpdate(vehicle);

        return vehicleRepository.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();

        vehicleRepository.delete(vehicle);
    }

}
