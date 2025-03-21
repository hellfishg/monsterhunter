package api.hellfishg.monsterhunter.monsterhunter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.hellfishg.monsterhunter.monsterhunter.model.BiomaModel;

@Repository
public interface BiomasRepository extends CrudRepository<BiomaModel, Long>{

    @Query("SELECT b.nombre FROM bioma b")
    List<String> findAllNames();
    
}
