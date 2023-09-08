import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import {
  handleFilterRequest,
  handleEditRequest,
  handleAddRequest
} from "../../actions/HandleManager";
import UrbanismoEstadosGenericTable from "./generic/UrbanismoEstadosGenericTable";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";
import CommonLoading from "../../components-level-1/CommonLoading";
import { openCommonMessage } from "./../../redux/reducers/reducerCommonMessage";

function UrbanismoTramiteEstadosStepTwo () {
  const dispatch = useDispatch();
  const history = useHistory();
  const selectedTramiteParam = history && history.location && history.location.state.data;
  const tableTitle = i18n.urbanismoEstadosTable.title + " - " + i18n.urbanismoEstadosTable.titleToSelect;
  const pageSize = 10;
  const numberPagesToShow = 10;
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  const [selectedTramite, setSelectedTramite] = useState(selectedTramiteParam);

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`urbanismo-estados/filter?page=${activePage - 1}&size=${pageSize}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`urbanismo-estados/filter/size/${pageSize}`, filterBody, setTotalPages);
  }

  const handleAfterFail = function (response, errorMessage) {
    dispatch(openCommonMessage(
      {
        isMessageModalVisible: true,
        messageModalTitle: i18n.errorMessages.errorTitle,
        messageModalBody: errorMessage,
        messageModalVariant: "danger"
      }
    ));
    setIsRequestInProgress(false);
  };

  function handleSelection (selectedEstado) {
    console.log({ selectedTramite, selectedEstado });
    const username = window.sessionStorage.getItem("username");
    const tenant = window.sessionStorage.getItem("tenant");
    const body = {
      tramiteNombreCorto: selectedTramite.tramiteNombreCorto,
      estadoNombreCorto: selectedEstado.nombreCorto,
      nombreCliente: selectedTramite.nombreCliente,
      ciCliente: selectedTramite.ciCliente,
      tenant,
      createdBy: username,
      updatedBy: username
    };
    const bodyHistorial = {
      idTramiteFlujo: selectedTramite.id,
      username,
      estadoAnterior: selectedTramite.estadoNombreCorto,
      estadoNuevo: selectedEstado.nombreCorto,
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
        handleAfterFail
      );
      dispatch(openCommonMessage(
        {
          isMessageModalVisible: true,
          messageModalTitle: i18n.successMessages.successTitle,
          messageModalBody: i18n.successMessages.successfullyEdited,
          messageModalVariant: "warning"
        }
      ));
      setIsRequestInProgress(false);
    };
    setSelectedTramite({ ...selectedTramite, estadoNombreCorto: selectedEstado.nombreCorto });
    setIsRequestInProgress(true);
    handleEditRequest(
      "urbanismo-tramite-flujo/",
      body,
      selectedTramite.id,
      handleAfterSucess,
      handleAfterFail,
      false
    );
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "info",
      handleCustom: handleSelection,
      text: i18n.commonTable.selectButton
    }
  ];

  if (isRequestInProgress) {
    return <CommonLoading></CommonLoading>;
  }

  return (
    <UrbanismoEstadosGenericTable
      tableTitle={tableTitle}
      tableSubTitle={i18n.urbanismoEstadosTable.infoTramiteEnCurso +
        " : " + selectedTramite.tramiteNombreCorto + " , " +
        i18n.urbanismoEstadosTable.infoTramiteCliente + " , " +
        " : " + selectedTramite.nombreCliente + " , " +
        i18n.urbanismoEstadosTable.infoEstadoActual + " , " +
        " : " + selectedTramite.estadoNombreCorto
      }
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.MEDIUM}
    >
    </UrbanismoEstadosGenericTable>
  );
}

export default UrbanismoTramiteEstadosStepTwo;
