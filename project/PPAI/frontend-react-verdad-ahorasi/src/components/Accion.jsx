import React, {useState} from 'react';
import { llamadasService } from '../services/llamadas.services';

const Accion = ({
    actualizarParteDePagina,
    desA,
    desD,
    acciones
}) => {
    const handleActualizar = () => {
        actualizarParteDePagina()
    }
    const [accion, setAccion] = useState()

    const handleChange = (accion) => {
        setAccion(accion)
        console.log(accion)
      };

      const actualizar = () => {
        if(accion!==undefined){
          handleActualizar()
          llamadasService.enviarAccion(accion).then((respuesta) => {
            console.log(respuesta)
            }).catch((error) => {
              console.log(error)
            })
        } else {
          alert("Debe seleccionar una accion!")
        }
        
      }
 

      const clickConfirmar = () => {
        actualizar()
      }

      const clickDeshacer = () => {
        handleActualizar()
      }

  return (
    <div>
      <div className='card mb-4'>
        <div className="card-body">
          <div className='row text-center'>
            <div className='col-md-4 offset-4'>
              <h2 className='tituloCard'>Accion A Realizar</h2>
            </div>
          </div>
 
          <div className='row text-center'>
            <div className='col-md-6 offset-3'>
              <div className='card mb-3'>
                <div className="card-body">
                  <div className='row text-center'>
                    <div className='col mb-2 d-flex justify-content-start'>
                      <label id='texto'>Seleccione la accion a realizar</label>
                    </div>
                  </div> 
                  <select className="form-select" aria-label="Default select example" disabled={desA} 
                      onChange={(e) => handleChange(e.target.value)}>
                        <option selected id='texto' disabled value={""}>Despliegue para ver acciones</option>
                        {acciones?.map((accion) => (                 
                            <option id='texto' key={accion.idAccion} value= {accion.idAccion}>
                            {accion.descripcion}
                            </option>
                        ))}
                  </select> 
                </div>
              </div>
            </div>
          </div>
            <div className='row '>
              <div className='col-md-6 offset-3 d-flex justify-content-end' >
                <button type="button" id='acceptBottom' className="btn btn-success" onClick={clickConfirmar} disabled={desA}>Guardar seleccion</button>
                <div className="mx-2"> </div>
                <button type="button" id='rollbackBottom' className="btn btn-success" onClick={clickDeshacer} disabled={desD}>Deshacer</button>
              </div>
            </div> 
        </div>
      </div>
      
    </div>
  );
};

export default Accion;