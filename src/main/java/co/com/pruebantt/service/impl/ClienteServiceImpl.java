package co.com.pruebantt.service.impl;

import co.com.pruebantt.domain.Cliente;
import co.com.pruebantt.domain.enumeration.TipoIdenficacion;
import co.com.pruebantt.repository.ClienteRepository;
import co.com.pruebantt.service.ClienteService;
import co.com.pruebantt.service.dto.ClienteDTO;
import co.com.pruebantt.service.mapper.ClienteMapper;
import co.com.pruebantt.web.rest.errors.BadRequestAlertException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cliente}.
 */
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        log.debug("Request to save Cliente : {}", clienteDTO);
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) {
        log.debug("Request to save Cliente : {}", clienteDTO);
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    @Override
    public Optional<ClienteDTO> partialUpdate(ClienteDTO clienteDTO) {
        log.debug("Request to partially update Cliente : {}", clienteDTO);

        return clienteRepository
            .findById(clienteDTO.getId())
            .map(existingCliente -> {
                clienteMapper.partialUpdate(existingCliente, clienteDTO);

                return existingCliente;
            })
            .map(clienteRepository::save)
            .map(clienteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> findAll() {
        log.debug("Request to get all Clientes");
        return clienteRepository.findAll().stream().map(clienteMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findOne(Long id) {
        log.debug("Request to get Cliente : {}", id);
        return clienteRepository.findById(id).map(clienteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cliente : {}", id);
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDTO> clientesQuemados(String tipoIdentificacion, String numeroDocumento) {
        if (
            (tipoIdentificacion.equals("CEDULA_CIUDADANIA") || tipoIdentificacion.equals("PASAPORTE")) &&
            numeroDocumento.equals("234453222")
        ) {
            ClienteDTO cliente = new ClienteDTO();
            cliente.setPrimerNombre("Sebastian");
            cliente.setSegundoNombre("Enrique");
            cliente.setPrimerApellido("Ortegon");
            cliente.setSegundoApellido("Hernandez");
            cliente.setTelefono("3005371491");
            cliente.setDireccion("rojas 2");
            cliente.setCiudadResidencia("Armenia Quindio");

            return Arrays.asList(cliente);
        }

        throw new BadRequestAlertException("error", "error", "Solo existe informacion para el usuario con identificacion: 234453222");
    }
}
