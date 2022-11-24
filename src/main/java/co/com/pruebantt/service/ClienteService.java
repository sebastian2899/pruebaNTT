package co.com.pruebantt.service;

import co.com.pruebantt.domain.enumeration.TipoIdenficacion;
import co.com.pruebantt.service.dto.ClienteDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link co.com.pruebantt.domain.Cliente}.
 */
public interface ClienteService {
    /**
     * Save a cliente.
     *
     * @param clienteDTO the entity to save.
     * @return the persisted entity.
     */
    ClienteDTO save(ClienteDTO clienteDTO);

    /**
     * Updates a cliente.
     *
     * @param clienteDTO the entity to update.
     * @return the persisted entity.
     */
    ClienteDTO update(ClienteDTO clienteDTO);

    /**
     * Partially updates a cliente.
     *
     * @param clienteDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ClienteDTO> partialUpdate(ClienteDTO clienteDTO);

    /**
     * Get all the clientes.
     *
     * @return the list of entities.
     */
    List<ClienteDTO> findAll();

    /**
     * Get the "id" cliente.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ClienteDTO> findOne(Long id);

    /**
     * Delete the "id" cliente.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<ClienteDTO> clientesQuemados(String tipoIdentificacion, String numeroDocumento);
}
