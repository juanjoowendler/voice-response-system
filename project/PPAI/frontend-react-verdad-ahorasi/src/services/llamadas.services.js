
import {config} from "../config";
import httpService from "./http.service";

const urlResource = config.urlResourceLlamada;

//aca deberia cambiar algunas cosas, las querys que recibo aca no estan para los equipos
async function buscarLlamada() {
  const resp = await httpService.get(urlResource + "/com-operador");
  return resp.data;
}
async function buscarValidacionesLlamada() {
    const resp = await httpService.get(urlResource + "/validaciones");
    return resp.data;
  }

async function validarRespuestas(respuestas){
  const resp = await httpService.post(urlResource + "/respuestas-validaciones", respuestas)
  console.log(resp.data)
  return resp.data
}

async function enviarAccion(accion){
  console.log(accion)
  const resp = await httpService.post(urlResource + "/accion-selec", accion)
  return resp.data
}

async function enviarDescripcion(descripcion){
  const resp = await httpService.post(urlResource + "/descripcion-operador", descripcion)
  return resp
}

async function confirmarTodo(){
  const resp = await httpService.post(urlResource + "/confirmar")
  return resp
}

async function finalizarLlamada(){
  const resp = await httpService.post(urlResource + "/finalizarLlamada")
  return resp
}

async function salir(){
  const resp = await httpService.post(urlResource + "/salir")
  return resp
}
export const llamadasService = {
    buscarLlamada,
    buscarValidacionesLlamada,
    validarRespuestas,
    enviarAccion,
    enviarDescripcion,
    confirmarTodo,
    finalizarLlamada,
    salir
};