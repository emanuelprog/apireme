package com.br.gov.ms.campogrande.apireme.repository.dbergon;

import com.br.gov.ms.campogrande.apireme.model.dbergon.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
     Optional<Teacher> findByCpf(String cpf);
}