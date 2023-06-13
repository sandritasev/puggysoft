import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "../../models/enumPaths";
import { handleFilterRequest, handleDeleteRequest } from "../../actions/HandleManager";
import ScheduleGenericTable from "./generic/ScheduleGenericTable";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";

function ScheduleGenericEditDelete () {
  const tableTitle = i18n.scheduleTable.title;
  const pageSize = 10;
  const numberPagesToShow = 10;

  const history = useHistory();

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`reservations-schedule/filter?page=${activePage - 1}&size=${pageSize}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`reservations-schedule/filter/size/${pageSize}`, filterBody, setTotalPages);
  }

  function handleDelete (data) {
    handleDeleteRequest(`reservations-schedule/${data.id}`, undefined, undefined, undefined, true);
  }

  function handleEdit (data) {
    history.push({
      pathname: enumPaths.RESERVATION_SCHEDULE_FORM,
      state: {
        data,
        edit: true
      }
    });
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

  return (
    <ScheduleGenericTable
      tableTitle={tableTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.FULL}
    >
    </ScheduleGenericTable>
  );
}

export default ScheduleGenericEditDelete;
