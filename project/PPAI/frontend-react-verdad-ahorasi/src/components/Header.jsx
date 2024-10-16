import { Image } from "react-bootstrap";
import MiImagen from "../images/logoSinFondo.png"
export function Header(){
    return (
        <header id="header">
                <div class="row justify-content-start" id="logo">
                    <div class="col">
                        <Image  src= {MiImagen} alt="Descripción de la imagen" fluid/>  
                    </div>
                </div>
                <div className="container text-center" >
                    <div class="row" id="filaTituloPrincipal">
                        <div class="col text-center">
                            <h1 className="tituloPrincipal">REGISTRAR RESPUESTA DE OPERADOR</h1>
                        </div>
                    </div>
                </div>
        </header>
    );
}