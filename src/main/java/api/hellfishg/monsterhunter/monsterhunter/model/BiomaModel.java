package api.hellfishg.monsterhunter.monsterhunter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "bioma")
@Table(name = "bioma")
public class BiomaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bioma_id")
    private long biomaId;

    @Column
    private String nombre;

    //getters and setters:
    public long getBiomaId() {
        return biomaId;
    }
    
    public void setBiomaId(long biomaId) {
        this.biomaId = biomaId;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
