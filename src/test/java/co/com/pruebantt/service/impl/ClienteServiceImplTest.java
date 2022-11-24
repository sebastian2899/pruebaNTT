package co.com.pruebantt.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

import co.com.pruebantt.domain.Cliente;
import co.com.pruebantt.domain.enumeration.TipoIdenficacion;
import co.com.pruebantt.repository.ClienteRepository;
import co.com.pruebantt.service.dto.ClienteDTO;
import co.com.pruebantt.web.rest.errors.BadRequestAlertException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ClienteServiceImplTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void clientesQuemados() {
        String tipoIdentificacion = "PASAPORTE";
        String numeroIdentificacion = "234453222";

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setTipoIdentificacion(TipoIdenficacion.PASAPORTE);
        clienteDTO.setCedulaCiudadania(234453222L);
        clienteDTO.setPrimerApellido("Sebastian");
        clienteDTO.setSegundoNombre("Enrique");
        clienteDTO.setSegundoApellido("Ortegon");
        clienteDTO.setSegundoApellido("Hernadez");
        clienteDTO.setTelefono("300 000 0000");
        clienteDTO.setDireccion("Rojas 2");
        clienteDTO.setCiudadResidencia("Armenia - Quindio");

        List<ClienteDTO> clientes = clienteService.clientesQuemados(tipoIdentificacion, numeroIdentificacion);

        assertNotNull(clientes);
        assertEquals(1, clientes.size());
    }

    @Test
    void clientesQuemadosException() {
        String tipoIdentificacion = "1";
        String numeroIdentificacion = "2";
        try {
            doThrow(BadRequestAlertException.class).when(clienteService.clientesQuemados(tipoIdentificacion, numeroIdentificacion));
        } catch (BadRequestAlertException e) {}

        BadRequestAlertException exception = assertThrows(
            BadRequestAlertException.class,
            () -> {
                clienteService.clientesQuemados(tipoIdentificacion, numeroIdentificacion);
            }
        );

        assertNotNull(exception);
        assertEquals("Solo existe informacion para el usuario con identificacion: 234453222", exception.getErrorKey());
        assertEquals(400, exception.getStatus().getStatusCode());
    }
}
