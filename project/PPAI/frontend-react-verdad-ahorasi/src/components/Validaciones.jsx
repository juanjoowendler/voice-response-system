import React, {useState} from 'react';
import { useEffect } from 'react';
import { llamadasService } from '../services/llamadas.services';
import { useForm } from 'react-hook-form';
import Accion from './Accion';

// fijarse que nombre tienen los atributos de los objetos que llegan para poder renderizarlos..

const ValidacionesComponent = ({
  desVal,
  validaciones,
  validarLlamada
}) => {
  const {register, handleSubmit, setValue} = useForm()
  const [respuestas, setRespuestas] = useState([])

 
  const actualizar = () => {
    console.log(respuestas)
    const arrayFiltrado = respuestas.filter((elemento) => elemento !== undefined);
    console.log(arrayFiltrado)
    if (arrayFiltrado.length > 0 && arrayFiltrado.length === validaciones.length){
      validarLlamada({arrayFiltrado});
    } else {alert("Debe seleccionar una opcion para cada validacion!")}
    
  }

  const handleChange = (index, nroOrdenValidacion, opcionSeleccionada) => {
    setRespuestas((respuestas) => {
      const nuevasRespuestas = [...respuestas];
      nuevasRespuestas[index] = { nroOrdenValidacion, opcionSeleccionada: opcionSeleccionada };
      return nuevasRespuestas;
    });
  };

  return (

      <div>
        <div class="card mb-4">
          <div class="card-body">
            <div className='row text-center'>
                <div className='col-md-4 offset-4'>
                  <h2 className='tituloCard'>Validaciones</h2>
                </div>
            </div>
            <div className='row text-center'>
              <div className='col-md-12'>
                <form onSubmit={handleSubmit(actualizar)}>
                  <div className="mb-4">
                  {validaciones && validaciones.map((validacion) => (
                      <div>
                        <div className='col-md-6 offset-3'>
                          <div class="card mb-3">
                            <div class="card-body">
                              <div className='row'>
                                <div className='col-12 d-flex justify-content-start'>
                                  <label className="form-label" id='texto'>{validacion.descripcionValidacion}</label>
                                </div>
                              </div>
                              <select className="form-select"  onChange={(e) => handleChange(validacion.nroOrden, validacion.nroOrden, e.target.value)} >
                                <option selected id='texto' disabled value={""}>Seleccione una opcion</option>
                                {validacion.descripcionesOpciones.map((datos) => (
                                  <option key={datos} id='texto' >{datos}</option>
                                ))}
                              </select>
                            </div>
                          </div>
                        </div>
                      </div>
                    ))}
                  </div>
                  <div className='row '>
                    <div className='col-md-6 offset-3 d-flex justify-content-end' >
                      <button type="submit" id='acceptBottom' className="btn btn-success" disabled={desVal}>Validar</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
    </div>
    
  );
};


export default ValidacionesComponent