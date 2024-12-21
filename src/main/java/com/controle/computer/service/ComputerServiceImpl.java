package com.controle.computer.service;


import com.controle.computer.dto.ComputerDto;
import com.controle.computer.entity.Computer;
import com.controle.computer.repository.ComputerRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerServiceImpl implements IComputerService{

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ComputerDto> getComputerByProce(String proce) {
        List<Computer> computers=computerRepository.findAllByProce(proce);
        List<ComputerDto> computerDtos=new ArrayList<>();
        for(Computer c :computers){

            ComputerDto computerDto=modelMapper.map(c, ComputerDto.class);
            computerDtos.add(computerDto);

        }
        return computerDtos;
    }

    @Override
    public ComputerDto saveComputer(ComputerDto computerDto) {
        if (computerDto == null) {
            throw new IllegalArgumentException("Input AvionDto cannot be null");
        }

        Computer computer=modelMapper.map(computerDto,Computer.class);
        Computer computer1=computerRepository.save(computer);

        ComputerDto computerDto1=modelMapper.map(computer1,ComputerDto.class);
        return computerDto1;


    }

    @Override
    public boolean deleteProce(Long id) {
        if(computerRepository.findById(id).isPresent()){
            computerRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }

    }


    @PostConstruct
    public void initDatabase() {
        computerRepository.save(new Computer(null, "Intel Core i5", 8, "512GB SSD", 800.0, "00:1A:2B:3C:4D:5E"));
        computerRepository.save(new Computer(null, "Intel Core i5", 16, "1TB SSD", 1200.0, "00:1A:2B:3C:4D:5F"));
        computerRepository.save(new Computer(null, "AMD Ryzen 5", 8, "1TB HDD", 700.0, "00:1A:2B:3C:4D:60"));
        computerRepository.save(new Computer(null, "AMD Ryzen 7", 16, "512GB SSD", 1100.0, "00:1A:2B:3C:4D:61"));
        computerRepository.save(new Computer(null, "Intel Core i3", 4, "256GB SSD", 500.0, "00:1A:2B:3C:4D:62"));
    }

}


