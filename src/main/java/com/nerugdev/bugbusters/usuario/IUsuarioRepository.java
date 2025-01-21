package com.nerugdev.bugbusters.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findByActivoTrue(Pageable pageable);
}
