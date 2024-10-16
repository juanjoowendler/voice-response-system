import React from "react";
import { useState } from "react";
import { llamadasService } from "../services/llamadas.services";

const Respuesta = ({
    desR,
    setNoConfirmo
    }) => {
    const [respuesta, setRespuesta] = useState(" ")


    const actualizar = () => {
        llamadasService.enviarDescripcion(respuesta).then((respuesta) => {
            console.log(respuesta)
            }).catch((error) => {
                console.log(error)
            })
        }

    const confirmarTodo = () => {
        setNoConfirmo(false)
        llamadasService.confirmarTodo(respuesta).then((respuesta) => {
            alert("Accion registrada con exito")
            llamadasService.finalizarLlamada().then(()=>{window.close()})
            }).catch(() => {
                setNoConfirmo(false)
                alert("Error, fallo registro de accion requerida")
                window.close()
            })
        }

        const handleChange = (respuesta) => {
            console.log(respuesta)
            setRespuesta(respuesta)
          };
        return (
            <div>
                <div class="card">
                    <div class="card-body">
                        <div className='row text-center'>
                            <div className='col-md-4 offset-4'>
                                <h2 className='tituloCard'>Respuesta Operador</h2>
                            </div>
                        </div>
                        <div className="row">
                            <div className='col-md-6 offset-3'>
                                    <div class="card mb-3">
                                        <div class="card-body">
                                            <div className='row text-center'>
                                                <div className='col mb-2 d-flex justify-content-start'>
                                                    <label id='texto'>Ingrese la respuesta otorgada al cliente</label>
                                                </div>
                                            </div>
                                            <textarea className="form-control" aria-label="With textarea" disabled={desR} 
                                            onChange={(e) => handleChange(e.target.value)} rows={4}></textarea>
                                    </div>
                                </div> 
                            </div>
                        </div>
                        <div className='row'>
                            <div className='col-md-6 offset-3 d-flex justify-content-end' >
                                <button id='acceptBottom' type="button" class="btn btn-success" disabled={desR}
                                    onClick={actualizar}>Guardar respuesta</button>
                                <div className="mx-2"> </div>
                                <button id='acceptBottom' type="button" class="btn btn-success" disabled={desR}
                                    onClick={confirmarTodo} >Confirmar todo</button>       
                            </div>
                        </div>                
                    </div>
                </div>               
            </div>
        )
    }


    
export default Respuesta