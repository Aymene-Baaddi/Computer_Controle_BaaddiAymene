package com.controle.computer.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDto {
    private String proce;
    private Integer ram;
    private String HardDrive;
    private Double price;
    private String macAddress;
}
