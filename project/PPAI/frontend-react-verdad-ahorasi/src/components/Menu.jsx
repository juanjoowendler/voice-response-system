import { NavLink} from "react-router-dom";
import React, {useState, useEffect} from 'react';
import Validaciones from './Validaciones';
import Accion from "./Accion";
import Respuesta from "./Respuesta";
import ListadoLlamadas from "./ListadoLlamada";
import { llamadasService } from "../services/llamadas.services";
import NuevaLlamada from "./NuevaLlamada";

function Menu({noConfirmo, setNoConfirmo}) {
  const [contador, SetContador] = useState(0)
  const [desVal, setDesValidacion] =  useState(false)
  const [desA, setDesAccion] = useState(true)
  const [desD, setDesDeshacer] = useState(true)
  const [desR, setDesRespuesta] = useState(true)
  const[acciones, setAcciones] = useState([])
  const [datoAValidar, setDatoAValidar] = useState()

  const actualizarParteDePagina = () => {
      SetContador(contador + 1)
      if (contador === 0) {
        setDesValidacion(true);
        setDesAccion(false)
      } else if (contador === 1) {
        setDesAccion(true)
        setDesRespuesta(false)
        setDesDeshacer(false)
      }
      else if(contador >= 1 && desA) {
        console.log(contador)
        setDesDeshacer(true)
        setDesRespuesta(true)
        setDesAccion(false)
        SetContador(contador - 1)
      }
  }
  const [llamada, setLlamada] = useState("")

  useEffect(() =>{
      const traerLlamada = async () => {
          const rdo = await llamadasService.buscarLlamada();
          setLlamada(rdo);
      }
      traerLlamada();
    }, []);

    const buscarValidacionesLlamada = async () => {
      const rdo = await llamadasService.buscarValidacionesLlamada();
      setDatoAValidar(rdo) 
      console.log(rdo)       
    }

    const validarLlamada = async ({arrayFiltrado}) => {
       llamadasService.validarRespuestas(arrayFiltrado).then((respuesta) => {
        alert("Cliente validado con exito!")
        setAcciones(respuesta)
        console.log(respuesta)
        }).catch((error) => {
          setNoConfirmo(false)
          console.log(error.message)
          alert("error, una de las validaciones fallo")
          window.close()
        })
        actualizarParteDePagina()  
    }

  return (
    <div id="menuPrincipal">
        <NuevaLlamada onModalButtonClick={buscarValidacionesLlamada} llamada={llamada}></NuevaLlamada>
        <ListadoLlamadas llamada={llamada} />
      <div>
        <Validaciones actualizarParteDePagina={actualizarParteDePagina} desVal={desVal} setAcciones={setAcciones}
        validaciones={datoAValidar} validarLlamada={validarLlamada} />
        <Accion actualizarParteDePagina={actualizarParteDePagina} desA={desA} desD={desD} acciones={acciones} />
        <Respuesta desR={desR} setNoConfirmo={setNoConfirmo}/>
      </div>
    </div>
  );
}

export default Menu;