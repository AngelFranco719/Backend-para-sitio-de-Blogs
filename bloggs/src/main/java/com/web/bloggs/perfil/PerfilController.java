package com.web.bloggs.perfil;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatusCode;

@RestController
@RequestMapping("/Perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    /// Obtener todos los perfiles.
    @CrossOrigin
    @GetMapping
    public List<Perfil> getAllPerfiles() {
        return perfilRepository.findAll();
    }

    /// Obtener un perfil según el ID obtenido.
    @CrossOrigin
    @GetMapping("/{ID}")
    public ResponseEntity<Perfil> getPerfilByID(@PathVariable Long ID) {
        Optional<Perfil> perfil = perfilRepository.findById(ID);
        return perfil.map((ResponseEntity::ok)).orElseGet(() -> (ResponseEntity.notFound().build()));
    }

    @CrossOrigin
    @GetMapping("/filter/{ID}")
    public ResponseEntity<String> getUsernameByID(@PathVariable Long ID){
        Optional<String> username = perfilRepository.getProfileNameByID(ID); 
        if(username.isPresent()){
            String newUsername = username.get(); 
            return ResponseEntity.ok(newUsername); 
        }
        return ResponseEntity.notFound().build(); 
    }
    
    /// Crear un perfil según el body obtenido.
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil) {
        String currentPassword = perfil.getPer_contraseña();
        perfil.setPer_contraseña(BCrypt.hashpw(currentPassword, BCrypt.gensalt()));
        Perfil savedPerfil = perfilRepository.save(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerfil);
    }

    @CrossOrigin
    @DeleteMapping("/{ID}")
    public ResponseEntity<Perfil> deletePerfilbyID(@PathVariable Long ID) {
        if (!perfilRepository.existsById(ID)) {
            return ResponseEntity.notFound().build();
        } else {
            perfilRepository.deleteById(ID);
            return ResponseEntity.ok().build();
        }
    }

    @CrossOrigin
    @PutMapping("{ID}")
    public ResponseEntity<Perfil> updatePerfilByID(@PathVariable Long ID, @RequestBody Perfil updatedPerfil) {
        if (!perfilRepository.existsById(ID)) {
            return ResponseEntity.notFound().build();
        } else {
            updatedPerfil.setID_Perfil(ID);
            Perfil savedPerfil = perfilRepository.save(updatedPerfil);
            return ResponseEntity.ok(savedPerfil);
        }
    }

    /// Verificar una sesión.
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<Perfil> Login(@RequestBody ParamsLogin parametros) {
        Perfil sesionActual = perfilRepository.findByPerNombre(parametros.username);
        System.out.println(parametros.username);
        if (sesionActual == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (BCrypt.checkpw(parametros.password, sesionActual.getPer_contraseña())) {
            return ResponseEntity.ok(sesionActual);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    public static class ParamsLogin {

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
}
