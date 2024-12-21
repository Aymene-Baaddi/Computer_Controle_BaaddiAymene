package com.controle.computer.repository;

import com.controle.computer.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer,Long> {

    public List<Computer> findAllByProce(String proce);
}
