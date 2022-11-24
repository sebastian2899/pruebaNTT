import { TipoIdenficacion } from 'app/entities/enumerations/tipo-idenficacion.model';

export interface ICliente {
  id?: number;
  primerNombre?: string | null;
  segundoNombre?: string | null;
  primerApellido?: string | null;
  segundoApellido?: string | null;
  telefono?: string | null;
  direccion?: string | null;
  ciudadResidencia?: string | null;
  cedulaCiudadania?: number | null;
  tipoIdentificacion?: TipoIdenficacion | null;
}

export class Cliente implements ICliente {
  constructor(
    public id?: number,
    public primerNombre?: string | null,
    public segundoNombre?: string | null,
    public primerApellido?: string | null,
    public segundoApellido?: string | null,
    public telefono?: string | null,
    public direccion?: string | null,
    public ciudadResidencia?: string | null,
    public cedulaCiudadania?: number | null,
    public tipoIdentificacion?: TipoIdenficacion | null
  ) {}
}

export function getClienteIdentifier(cliente: ICliente): number | undefined {
  return cliente.id;
}
