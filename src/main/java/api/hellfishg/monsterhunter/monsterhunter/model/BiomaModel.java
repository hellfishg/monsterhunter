package api.hellfishg.monsterhunter.monsterhunter.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "bioma")
@Table(name = "bioma")
@Schema(description = "Modelo que representa un bioma")
public class BiomaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bioma_id")
    @Schema(description = "ID único del bioma", example = "1")
    private long biomaId;

    @Column
    @Schema(description = "Nombre del bioma", example = "Bosque Inundado")
    private String nombre;

    // Getters and setters:
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
