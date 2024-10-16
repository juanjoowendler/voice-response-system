//import "./App.css";
import React, { useEffect, useState } from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import { ErrorBoundary } from "react-error-boundary";
import { Header } from "./components/Header";
import Menu from "./components/Menu";
import { Inicio } from "./components/Inicio";
import "./styles/styles.css"
import { llamadasService } from "./services/llamadas.services";
function App() {

  const[noConfirmo, setNoConfirmo] = useState(true)

  const handleBeforeUnload = (event) => {
    console.log(noConfirmo)
    if (noConfirmo){
      const message = '¿Estás seguro de que quieres salir?';
      event.returnValue = message;
      return message;
    }

  };

  useEffect(() => {
    // Agrega el event listener cuando el componente se monta
    window.addEventListener('beforeunload', handleBeforeUnload);

    // Limpia el event listener cuando el componente se desmonta
    return () => {
      window.removeEventListener('beforeunload', handleBeforeUnload);
    };
  }, [noConfirmo]);



  return (
    <ErrorBoundary>
    <BrowserRouter>
      <div className="App">
        <Header/>
        <Routes>
          <Route path="/inicio" element={<Menu noConfirmo={noConfirmo} setNoConfirmo={setNoConfirmo}/>} />
          <Route path="*" element={<Navigate to="/inicio" replace />} />
        </Routes>
      </div>
    </BrowserRouter>
  </ErrorBoundary>
  );
}

export default App;
