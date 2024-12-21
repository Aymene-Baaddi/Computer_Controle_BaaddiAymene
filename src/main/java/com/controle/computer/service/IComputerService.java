package com.controle.computer.service;

import com.controle.computer.dto.ComputerDto;

import java.util.List;

public interface IComputerService {

    public List<ComputerDto> getComputerByProce(String proce);
    public ComputerDto saveComputer(ComputerDto computerDto);

    public boolean deleteProce(Long id);
}
