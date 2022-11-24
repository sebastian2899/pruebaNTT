import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { ICliente, Cliente } from '../cliente.model';
import { ClienteService } from '../service/cliente.service';
import { TipoIdenficacion } from 'app/entities/enumerations/tipo-idenficacion.model';

@Component({
  selector: 'jhi-cliente-update',
  templateUrl: './cliente-update.component.html',
})
export class ClienteUpdateComponent implements OnInit {
  isSaving = false;
  tipoIdenficacionValues = Object.keys(TipoIdenficacion);

  editForm = this.fb.group({
    id: [],
    primerNombre: [],
    segundoNombre: [],
    primerApellido: [],
    segundoApellido: [],
    telefono: [],
    direccion: [],
    ciudadResidencia: [],
    cedulaCiudadania: [],
    tipoIdentificacion: [],
  });

  constructor(protected clienteService: ClienteService, protected activatedRoute: ActivatedRoute, protected fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ cliente }) => {
      this.updateForm(cliente);
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const cliente = this.createFromForm();
    if (cliente.id !== undefined) {
      this.subscribeToSaveResponse(this.clienteService.update(cliente));
    } else {
      this.subscribeToSaveResponse(this.clienteService.create(cliente));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICliente>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(cliente: ICliente): void {
    this.editForm.patchValue({
      id: cliente.id,
      primerNombre: cliente.primerNombre,
      segundoNombre: cliente.segundoNombre,
      primerApellido: cliente.primerApellido,
      segundoApellido: cliente.segundoApellido,
      telefono: cliente.telefono,
      direccion: cliente.direccion,
      ciudadResidencia: cliente.ciudadResidencia,
      cedulaCiudadania: cliente.cedulaCiudadania,
      tipoIdentificacion: cliente.tipoIdentificacion,
    });
  }

  protected createFromForm(): ICliente {
    return {
      ...new Cliente(),
      id: this.editForm.get(['id'])!.value,
      primerNombre: this.editForm.get(['primerNombre'])!.value,
      segundoNombre: this.editForm.get(['segundoNombre'])!.value,
      primerApellido: this.editForm.get(['primerApellido'])!.value,
      segundoApellido: this.editForm.get(['segundoApellido'])!.value,
      telefono: this.editForm.get(['telefono'])!.value,
      direccion: this.editForm.get(['direccion'])!.value,
      ciudadResidencia: this.editForm.get(['ciudadResidencia'])!.value,
      cedulaCiudadania: this.editForm.get(['cedulaCiudadania'])!.value,
      tipoIdentificacion: this.editForm.get(['tipoIdentificacion'])!.value,
    };
  }
}
