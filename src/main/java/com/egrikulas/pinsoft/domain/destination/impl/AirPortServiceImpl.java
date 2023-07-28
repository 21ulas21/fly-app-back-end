package com.egrikulas.pinsoft.domain.destination.impl;

import com.egrikulas.pinsoft.domain.destination.api.AirPortDto;
import com.egrikulas.pinsoft.domain.destination.api.AirPortService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AirPortServiceImpl implements AirPortService {

    private final AirPortRepository repository;


    @Override
    public List<AirPortDto> saveAll(List<AirPortDto> airPortDtoList) {
        return airPortDtoList.stream()
               .map(dto-> repository.save(toEntity(new AirPort(), dto)))
               .map(this::toDto).toList();
    }

    @Override
    public List<AirPortDto> getAllAirPort() {

        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public AirPortDto create(AirPortDto dto) {
      var airport =  repository.findByCode(dto.getCode()).orElseGet(()-> repository.save(toEntity(new AirPort(), dto)));
        return toDto(airport);
    }



    @Override
    public AirPortDto getAirPortById(String id) {

        return repository.findById(id).map(this::toDto).orElseThrow(()-> new EntityNotFoundException("Kayıt Bulunamadı"));
    }
    public AirPort getAirportByCode(String code){
        var airport = repository.findByCode(code).orElseThrow(EntityNotFoundException::new);
        return airport;
    }


    public AirPort toEntity(AirPort airPort,AirPortDto dto){
        airPort.setCode(dto.getCode());
        airPort.setCodeOnly(dto.getCodeOnly());
        airPort.setExplanation(dto.getExplanation());
        airPort.setExplanationOnly(dto.getExplanationOnly());
        return airPort;
    }
    public AirPortDto toDto(AirPort airPort){
        return AirPortDto.builder()
                .code(airPort.getCode())
                .codeOnly(airPort.getCodeOnly())
                .explanation(airPort.getExplanation())
                .explanationOnly(airPort.getExplanationOnly())
                .build();
    }
}
