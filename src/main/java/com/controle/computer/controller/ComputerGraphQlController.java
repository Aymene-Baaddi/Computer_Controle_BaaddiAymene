package com.controle.computer.controller;


import com.controle.computer.dto.ComputerDto;
import com.controle.computer.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ComputerGraphQlController {


    @Autowired
    private IComputerService iComputerService;


    @QueryMapping
    public List<ComputerDto> getComputerByProce(@Argument String proce){
        return iComputerService.getComputerByProce(proce);
    }

    @MutationMapping
    public ComputerDto saveComputer(@Argument ComputerDto Computer){
        return iComputerService.saveComputer(Computer);
    }

    @MutationMapping
    public boolean  deleteComputer(@Argument Long id){
        return iComputerService.deleteProce(id);
    }












}
