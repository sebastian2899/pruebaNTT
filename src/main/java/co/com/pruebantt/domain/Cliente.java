package co.com.pruebantt.domain;

import co.com.pruebantt.domain.enumeration.TipoIdenficacion;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Cliente.
 */
@Entity
@Table(name = "cliente")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @Column(name = "cedula_ciudadania")
    private Long cedulaCiudadania;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_identificacion")
    private TipoIdenficacion tipoIdentificacion;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Cliente id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public Cliente primerNombre(String primerNombre) {
        this.setPrimerNombre(primerNombre);
        return this;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public Cliente segundoNombre(String segundoNombre) {
        this.setSegundoNombre(segundoNombre);
        return this;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public Cliente primerApellido(String primerApellido) {
        this.setPrimerApellido(primerApellido);
        return this;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public Cliente segundoApellido(String segundoApellido) {
        this.setSegundoApellido(segundoApellido);
        return this;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public Cliente telefono(String telefono) {
        this.setTelefono(telefono);
        return this;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public Cliente direccion(String direccion) {
        this.setDireccion(direccion);
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadResidencia() {
        return this.ciudadResidencia;
    }

    public Cliente ciudadResidencia(String ciudadResidencia) {
        this.setCiudadResidencia(ciudadResidencia);
        return this;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Long getCedulaCiudadania() {
        return this.cedulaCiudadania;
    }

    public Cliente cedulaCiudadania(Long cedulaCiudadania) {
        this.setCedulaCiudadania(cedulaCiudadania);
        return this;
    }

    public void setCedulaCiudadania(Long cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    public TipoIdenficacion getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public Cliente tipoIdentificacion(TipoIdenficacion tipoIdentificacion) {
        this.setTipoIdentificacion(tipoIdentificacion);
        return this;
    }

    public void setTipoIdentificacion(TipoIdenficacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        return id != null && id.equals(((Cliente) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cliente{" +
            "id=" + getId() +
            ", primerNombre='" + getPrimerNombre() + "'" +
            ", segundoNombre='" + getSegundoNombre() + "'" +
            ", primerApellido='" + getPrimerApellido() + "'" +
            ", segundoApellido='" + getSegundoApellido() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", ciudadResidencia='" + getCiudadResidencia() + "'" +
            ", cedulaCiudadania=" + getCedulaCiudadania() +
            ", tipoIdentificacion='" + getTipoIdentificacion() + "'" +
            "}";
    }
}
