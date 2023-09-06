import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import { handleFilterRequest } from "../../actions/HandleManager";
import enumCompareOperators from "../../models/enumCompareOperators";
import UrbanismoHistorialGenericTable from "./generic/UrbanismoHistorialGenericTable";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";

function UrbanismoFlujoHistorialStepTwo () {
  const tableTitle = i18n.urbanismoHistorialTable.title;
  const tableSubTitle = i18n.urbanismoHistorialTable.subTitleSelection;
  const pageSize = 10;
  const numberPagesToShow = 10;

  const history = useHistory();
  const selectedFlujo = history && history.location && history.location.state.data;

  function handleGetData (activePage, filterBody, updateArrayData) {
    filterBody.idTramiteFlujoOperator = enumCompareOperators.TEXT_CONTAINS;
    filterBody.idTramiteFlujoCriteria = selectedFlujo.id;
    handleFilterRequest(`urbanismo-historial/filter?page=${activePage - 1}&size=${pageSize}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    filterBody.idTramiteFlujoOperator = enumCompareOperators.TEXT_CONTAINS;
    filterBody.idTramiteFlujoCriteria = selectedFlujo.id;
    handleFilterRequest(`urbanismo-historial/filter/size/${pageSize}`, filterBody, setTotalPages);
  }

  return (
    <UrbanismoHistorialGenericTable
      tableTitle={tableTitle}
      tableSubTitle={tableSubTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      columnsToShow={enumTableColumnsToShow.FULL}
    >
    </UrbanismoHistorialGenericTable>
  );
}

export default UrbanismoFlujoHistorialStepTwo;
