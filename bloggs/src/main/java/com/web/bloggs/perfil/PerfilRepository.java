package com.web.bloggs.perfil;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    @Query("SELECT p FROM Perfil p WHERE p.per_nombre= :username")
    Perfil findByPerNombre(@Param("username") String username);

    @Query("SELECT p.per_nombre FROM Perfil p WHERE p.ID_Perfil= :id")
    Optional<String> getProfileNameByID(@Param("id") Long id); 
    
}
