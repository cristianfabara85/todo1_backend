package com.todo1.hulkstore.repository;

import com.todo1.hulkstore.entities.Usuario;
import com.todo1.hulkstore.entities.UsuarioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Usuario,Long> {

    @Query(value = "SELECT usuarioId,usuario, password, tipo FROM public.usuarios where usuario=:nombreUsuario", nativeQuery = true)
    UsuarioVO findUserById(String nombreUsuario);

}
