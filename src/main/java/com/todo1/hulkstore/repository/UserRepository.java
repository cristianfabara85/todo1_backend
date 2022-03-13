package com.todo1.hulkstore.repository;

import java.util.List;
import com.todo1.hulkstore.entities.Usuario;
import com.todo1.hulkstore.entities.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Usuario,Long> {

    @Query(value = "SELECT usuarioId,usuario, password, tipo FROM public.usuario where nombreUsuario=:nombreUsuario", nativeQuery = true)
    UsuarioVO findUserById(String nombreUsuario);

}
