package com.example.politibil.Repository;
import com.example.politibil.Pojo.Politibil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolitibilRepository extends JpaRepository<Politibil, Long> {
    List<Politibil> findByStatus(String status);
    //findByStatusOrderByIdAsc er også lov

}
