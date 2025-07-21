package com.br.gov.ms.campogrande.apireme.repository.dbpreme;

import com.br.gov.ms.campogrande.apireme.model.dbpreme.SubstituteTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubstituteTeacherRepository extends JpaRepository<SubstituteTeacher, Long> {
    List<SubstituteTeacher> findAllByHolderCPF(String cpf);

    SubstituteTeacher findBySubstituteCPF(String cpf);
}
