import React, { useState, useEffect, useRef } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const NuevaLlamada = ({onModalButtonClick, llamada}) => {
  const [modalInstance, setModalInstance] = useState(null);
  const modalRef = useRef();

  useEffect(() => {
    const modal = new window.bootstrap.Modal(modalRef.current);
    setModalInstance(modal);
    modal.show();
  }, []);

  const handleCloseModal = () => {
    if (modalInstance) {
      onModalButtonClick();
      modalInstance.hide();
    }
  };

  return (
    <div className="modal fade" ref={modalRef} tabIndex="-1">
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title tituloCard" id='texto'>Nueva Llamada</h5>
          </div>
          <div className="modal-body">
            <div className="row">
              <div className="col text-center">
                <h2 className='tituloCard'>Datos llamada</h2>
              </div>
            </div>
            <div className="row">
              <div className="col text-left">
                <div>
                  <label id='texto'>Nombre Cliente: {llamada.nombreCliente}</label>
                </div>
              </div>
            </div>
            <div className="row">
              <div className="col text-left">
                <div>
                  <label id='texto'>Categoria: {llamada.nombreCategoria}</label>
    
                </div>
              </div>
            </div>
            <div className="row">
              <div className="col text-left">
                <div>
                  <label id='texto'>Opcion: {llamada.nombreOpcion}</label>
                </div>
              </div>
            </div>
            <div className="row">
              <div className="col text-left">
                <div>
                  <label id='texto'>Subopcion: {llamada.nombreSubOpcion !== null ? llamada.nombreSubOpcion : 'Sin subopcion'}</label>
                </div>
              </div>
            </div>
          </div>
          <div className="modal-footer">
            <button id='acceptBottom' type="button" className="btn btn-primary" data-bs-dismiss="modal" onClick={handleCloseModal}>
              Aceptar
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
export default NuevaLlamada