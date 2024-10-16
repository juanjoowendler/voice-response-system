import React, { useState } from 'react';
import { useEffect } from 'react';
import { llamadasService } from '../services/llamadas.services';
import { Row } from 'react-bootstrap';
import '../styles/styles.css'

// eslint-disable-next-line react-hooks/exhaustive-deps
//const [llamada, setLlamada] = useEffect("")

const ListadoLlamadas = ({llamada}) => {
    return (
      <div className="bodyLlamada">
        <div class="card mb-4 mt-4" >
          <div class="card-body" >
            <div class="row">
              <div class="col text-left">
                <h2 className='tituloCard'>Datos llamada</h2>
              </div>
            </div>
            <div class="row">
              <div class="col text-left">
                <div>
                  <label id='texto'>Nombre Cliente: {llamada.nombreCliente}</label>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col text-left">
                <div>
                  <label id='texto'> Categoria: {llamada.nombreCategoria}</label>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col text-left">
                <div>
                  <label id='texto'>Opcion: {llamada.nombreOpcion}</label>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col text-left">
                <div>
                  <label id='texto'>Subopcion: {llamada.nombreSubOpcion !== null ? llamada.nombreSubOpcion : 'Sin subopcion'}</label>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  };
  
  // No olvidarse de exportar:
  export default ListadoLlamadas;
  