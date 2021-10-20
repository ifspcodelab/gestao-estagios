package br.edu.ifsp.ifspcodelab.gestaoestagiosbackend.requestAppraisal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestAppraisalRepository extends JpaRepository<RequestAppraisal, UUID> {
}
