import React, { useState, useEffect } from "react";

import { useDispatch } from "react-redux";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "../../models/enumPaths";
import CommonDragDropWrapper from "../../components-level-1/CommonDragDropWrapper";
import { handleGetRequest, handleAddRequest, handleEditRequest } from "../../actions/HandleManager";
import { openCommonMessage } from "./../../redux/reducers/reducerCommonMessage";
import CommonLoading from "../../components-level-1/CommonLoading";

import "./UrbanismoFlujoBoardStepTwo.css";

function UrbanismoFlujoBoard () {
  const dispatch = useDispatch();
  const history = useHistory();
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  const [isRequestInProgressA, setIsRequestInProgressA] = useState(false);
  const [tramite, setTramite] = useState([null]);
  const [arrayEstados, setArrayEstados] = useState([]);
  const [currentStateSelected, setCurrentStateSelected] = useState();
  const selectedFlujoParam = history && history.location && history.location.state.data;
  const [selectedFlujo, setSelectedFlujo] = useState(selectedFlujoParam);

  useEffect(() => {
    setIsRequestInProgress(true);
    handleGetRequest(`urbanismo-tramites-buscar?shortName=${selectedFlujo.tramiteNombreCorto}`,
      afterGetTramite,
      handleRequestError,
      false
    );
  }, []);

  useEffect(() => {
    setIsRequestInProgressA(true);
    handleGetRequest("urbanismo-estados",
      afterGetAllEstados,
      handleRequestError,
      false
    );
  }, []);

  function afterGetTramite (tramiteData) {
    setIsRequestInProgress(false);
    setTramite(tramiteData);
  }

  function afterGetAllEstados (allEstados) {
    setIsRequestInProgressA(false);
    setArrayEstados(allEstados);
  }

  function handleRequestError (response, errorMessage) {
    setIsRequestInProgress(false);
    dispatch(openCommonMessage(
      {
        isMessageModalVisible: true,
        messageModalTitle: i18n.errorMessages.errorTitle,
        messageModalBody: errorMessage,
        messageModalVariant: "danger"
      }
    ));
  }

  function handleNavigateEdit () {
    setIsRequestInProgress(true);
    function afterGetEstadoSuccess (dataEstado) {
      setIsRequestInProgress(false);
      history.push({
        pathname: enumPaths.URBANISMO_TRAMITE_ESTADOS_STEP_THREE,
        state: {
          data: {
            selectedTramite: tramite,
            selectedEstado: dataEstado,
            selectedFlujo,
            edit: true
          }
        }
      });
    }
    handleGetRequest(`urbanismo-estados-buscar?shortName=${selectedFlujo.estadoNombreCorto}`,
      afterGetEstadoSuccess,
      handleRequestError,
      false
    );
  }

  function handleNavigateChangeState () {
    history.push({
      pathname: enumPaths.URBANISMO_FLUJO_CHANGE_STATE_STEP_TWO,
      state: {
        data: selectedFlujo
      }
    });
  }

  function handleNavigateHistorial () {
    history.push({
      pathname: enumPaths.URBANISMO_FLUJO_HISTORIAL_STEP_TWO,
      state: {
        data: selectedFlujo
      }
    });
  }

  function handleNavigateRequisitos () {
    history.push({
      pathname: enumPaths.URBANISMO_FLUJO_REQUISITOS_STEP_TWO,
      state: {
        data: selectedFlujo
      }
    });
  }

  function handleSaveChanges (newStateSelected) {
    if (newStateSelected === selectedFlujo.estadoNombreCorto) {
      return;
    }
    const username = window.sessionStorage.getItem("username");
    const tenant = window.sessionStorage.getItem("tenant");
    const body = {
      tramiteNombreCorto: selectedFlujo.tramiteNombreCorto,
      estadoNombreCorto: newStateSelected,
      nombreCliente: selectedFlujo.nombreCliente,
      ciCliente: selectedFlujo.ciCliente,
      tenant,
      createdBy: username,
      updatedBy: username
    };
    const bodyHistorial = {
      idTramiteFlujo: selectedFlujo.id,
      username,
      estadoAnterior: selectedFlujo.estadoNombreCorto,
      estadoNuevo: newStateSelected,
      tenant,
      createdBy: username,
      updatedBy: username
    };
    const handleAfterSucess = function (itemId) {
      handleAddRequest(
        "urbanismo-historial/",
        bodyHistorial,
        () => { },
        false,
        handleRequestError
      );
      dispatch(openCommonMessage(
        {
          isMessageModalVisible: true,
          messageModalTitle: i18n.successMessages.successTitle,
          messageModalBody: i18n.successMessages.successfullyEdited,
          messageModalVariant: "warning"
        }
      ));
      setSelectedFlujo({ ...selectedFlujo, estadoNombreCorto: newStateSelected });
      setIsRequestInProgress(false);
    };
    setIsRequestInProgress(true);
    handleEditRequest(
      "urbanismo-tramite-flujo/",
      body,
      selectedFlujo.id,
      handleAfterSucess,
      handleRequestError,
      false
    );
  }

  function handleMoveTicket (oldState, newState) {
    setCurrentStateSelected(newState);
  }

  if (isRequestInProgress || isRequestInProgressA) {
    return <CommonLoading />;
  }

  return (
    <div className="puggysoft-board-container">
      <div>
        <div className="header-board">
          <h1>{i18n.urbanismoFlujoBoard.title}</h1>
          <button
            onClick={() => handleSaveChanges(currentStateSelected)}
            className="button"
            id="add-button"
          >
            {i18n.urbanismoFlujoBoard.saveChanges}
          </button>
        </div>
        <div className="flex">
          {arrayEstados.map(function (estado, index) {
            return (
              <CommonDragDropWrapper
                key={`scrum-board-${index}`}
                dragDropkey={`scrum-board-${index}`}
                type="dropZone"
                onDropAction={handleMoveTicket}
                id={estado.nombreCorto}
              >
                <div className="backlog">
                  <h2 className="scrum-board">{estado.nombre}</h2>
                  {selectedFlujo.estadoNombreCorto === estado.nombreCorto &&
                    <CommonDragDropWrapper
                      id={selectedFlujo.estadoNombreCorto}
                      type="dragDropItem"
                    >
                      <div className="input-group overflow">
                        <span>
                          {i18n.urbanismoFlujoBoard.tramite}: {selectedFlujo.id}
                        </span>
                        <div>{selectedFlujo.nombreCliente}</div>
                        <div>{tramite.nombre}</div>
                        <div className="margin-top-10">
                          <button
                            onClick={handleNavigateEdit}
                            className="button button-backlog"
                          >
                            {i18n.urbanismoFlujoBoard.edit}
                          </button>
                          <button
                            onClick={handleNavigateRequisitos}
                            className="button button-progress"
                          >
                            {i18n.urbanismoFlujoBoard.requisites}
                          </button>
                          <button
                            onClick={handleNavigateChangeState}
                            className="button button-done"
                          >
                            {i18n.urbanismoFlujoBoard.changeState}
                          </button>
                          <button
                            onClick={handleNavigateHistorial}
                            className="button button-historial"
                          >
                            {i18n.urbanismoFlujoBoard.history}
                          </button>
                        </div>
                      </div>
                    </CommonDragDropWrapper>
                  }
                </div>
              </CommonDragDropWrapper>
            );
          }
          )}
        </div>
      </div>
    </div>
  );
}

export default UrbanismoFlujoBoard;
