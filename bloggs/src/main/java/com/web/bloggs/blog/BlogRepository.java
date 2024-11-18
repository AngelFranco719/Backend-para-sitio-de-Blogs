package com.web.bloggs.blog;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("SELECT b "
            + "FROM Blog b "
            + "JOIN b.ID_Perfil p "
            + "WHERE p.per_nombre = :profile AND b.blo_titulo = :title")
    Optional<Blog> findByNameAndTitle(@Param("profile") String profile, @Param("title") String title);

    @Query("SELECT b FROM Blog b WHERE b.blo_categoria= :category")
    Optional<List<Blog>> findByCategory(@Param("category") String category);

}
