import React, { useState } from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "../../models/enumPaths";
import {
  handleFilterRequest,
  handleDeleteRequest,
  handleGetRequest
} from "../../actions/HandleManager";
import UrbanismoTramiteEstadosGenericTable from "./generic/UrbanismoTramiteEstadosGenericTable";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";
import CommonLoading from "../../components-level-1/CommonLoading";
import CommonMessage from "../../components-level-1/CommonMessage";

function UrbanismoTramiteTableEstadosEditDelete () {
  const tableTitle = i18n.urbanismoTramiteEstadosTable.title;
  const pageSize = 10;
  const numberPagesToShow = 10;
  const history = useHistory();
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  const [isMessageVisible, setIsMessageVisible] = useState(false);
  const [messageTitle, setMessageTitle] = useState("");
  const [messageText, setMessageText] = useState("");

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`urbanismo-tramite-flujo/filter?page=${activePage - 1}&size=${pageSize}`,
      filterBody,
      updateArrayData,
      handleRequestError,
      false);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`urbanismo-tramite-flujo/filter/size/${pageSize}`,
      filterBody,
      setTotalPages,
      handleRequestError,
      false
    );
  }

  function handleDelete (data) {
    handleDeleteRequest(`urbanismo-tramite-flujo/${data.id}`, undefined, undefined, undefined, true);
  }

  function handleRequestError (response, errorMessage) {
    setIsRequestInProgress(false);
    setMessageTitle(i18n.errorMessages.errorTitle);
    setMessageText(errorMessage);
    setIsMessageVisible(true);
  }

  function handleEdit (selectedFlujo) {
    setIsRequestInProgress(true);
    function afterGetTramiteSuccess (dataTramite) {
      function afterGetEstadoSuccess (dataEstado) {
        setIsRequestInProgress(false);
        history.push({
          pathname: enumPaths.URBANISMO_TRAMITE_ESTADOS_STEP_THREE,
          state: {
            data: {
              selectedTramite: dataTramite,
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
    handleGetRequest(`urbanismo-tramites-buscar?shortName=${selectedFlujo.tramiteNombreCorto}`,
      afterGetTramiteSuccess,
      handleRequestError,
      false
    );
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "warning",
      handleCustom: handleEdit,
      text: i18n.commonTable.editButton
    },
    {
      variant: "danger",
      handleCustom: handleDelete,
      text: i18n.commonTable.deleteButton
    }
  ];

  if (isRequestInProgress) {
    return <CommonLoading />;
  }

  return (
    <>
      <CommonMessage
        isVisible={isMessageVisible}
        setIsVisible={setIsMessageVisible}
        titleText={messageTitle}
        bodyText={messageText}
        variant="danger"
      />
      <UrbanismoTramiteEstadosGenericTable
        tableTitle={tableTitle}
        numberPagesToShow={numberPagesToShow}
        handleGetData={handleGetData}
        handleGetSize={handleGetSize}
        tableArrayCustomRowButtons={tableArrayCustomRowButtons}
        columnsToShow={enumTableColumnsToShow.FULL}
      >
      </UrbanismoTramiteEstadosGenericTable>
    </>
  );
}

export default UrbanismoTramiteTableEstadosEditDelete;
