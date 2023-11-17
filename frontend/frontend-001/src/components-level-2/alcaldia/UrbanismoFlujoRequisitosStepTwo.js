import React, { useState } from "react";
import { useHistory } from "react-router";
import CommonLoading from "../../components-level-1/CommonLoading";
import i18n from "../../i18n/i18n";
import { handleFilterRequest, handleEditRequest } from "../../actions/HandleManager";
import enumCompareOperators from "../../models/enumCompareOperators";
import UrbanismoFlujoRequisitosGenericTable from "./generic/UrbanismoFlujoRequisitosGenericTable";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";
import enumRequisitosEstados from "../../models/alcaldia/enumRequisitosEstados";

function UrbanismoFlujoRequisitosStepTwo () {
  const history = useHistory();
  const selectedFlujo = history && history.location && history.location.state.data;
  const tableTitle = i18n.urbanismoFlujoRequisitosTable.title;
  const tableSubTitle = i18n.urbanismoFlujoRequisitosTable.subTitleSelectedTramite + ": " + selectedFlujo.tramiteNombreCorto;
  const pageSize = 20;
  const numberPagesToShow = 10;
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);

  function handleGetData (activePage, filterBody, updateArrayData) {
    filterBody.idTramiteFlujoOperator = enumCompareOperators.TEXT_CONTAINS;
    filterBody.idTramiteFlujoCriteria = selectedFlujo.id;
    handleFilterRequest(`urbanismo-flujo-requisitos/filter?page=${activePage - 1}&size=${pageSize}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    filterBody.idTramiteFlujoOperator = enumCompareOperators.TEXT_CONTAINS;
    filterBody.idTramiteFlujoCriteria = selectedFlujo.id;
    handleFilterRequest(`urbanismo-flujo-requisitos/filter/size/${pageSize}`, filterBody, setTotalPages);
  }

  // eslint-disable-next-line no-unused-vars
  const handleAddFile = (data) => { };

  function handleAfterCambiarEstado () {
    setIsRequestInProgress(false);
  }

  function handleCambiarEstado (data, textboxId) {
    setIsRequestInProgress(true);
    data.estado = data.estado === enumRequisitosEstados.CUMPLIDO
      ? enumRequisitosEstados.INCUMPLIDO
      : enumRequisitosEstados.CUMPLIDO;
    handleEditRequest("urbanismo-flujo-requisitos/",
      data,
      data.id,
      handleAfterCambiarEstado,
      () => setIsRequestInProgress(false),
      true);
  }

  const tableArrayCustomRowButtons = [
    {
      handleCustom: handleCambiarEstado,
      variantFunction: (data) => {
        if (data.estado === enumRequisitosEstados.CUMPLIDO) {
          return "success";
        }
        return "warning";
      },
      textFunction: (data) => {
        if (data.estado === enumRequisitosEstados.CUMPLIDO) {
          return "CUMPLIDO";
        }
        return "INCUMPLIDO";
      }
    }
    /* {
      variant: "info",
      handleCustom: handleAddFile,
      text: "Agregar documento"
    } */
  ];

  if (isRequestInProgress) {
    return <CommonLoading></CommonLoading>;
  }

  return (
    <div>
      <UrbanismoFlujoRequisitosGenericTable
        tableTitle={tableTitle}
        tableSubTitle={tableSubTitle}
        numberPagesToShow={numberPagesToShow}
        handleGetData={handleGetData}
        handleGetSize={handleGetSize}
        tableArrayCustomRowButtons={tableArrayCustomRowButtons}
        columnsToShow={enumTableColumnsToShow.MINIMUM}
      >
      </UrbanismoFlujoRequisitosGenericTable>
    </div>
  );
}

export default UrbanismoFlujoRequisitosStepTwo;
