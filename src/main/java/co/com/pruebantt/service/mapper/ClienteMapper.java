package co.com.pruebantt.service.mapper;

import co.com.pruebantt.domain.Cliente;
import co.com.pruebantt.service.dto.ClienteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cliente} and its DTO {@link ClienteDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {}
