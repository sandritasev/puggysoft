import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "../../models/enumPaths";
import { handleFilterRequest, handleDeleteRequest } from "../../actions/HandleManager";
import StorageRecordGenericTable from "./generic/StorageRecordGenericTable";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";
import enumCompareOperators from "../../models/enumCompareOperators";

function StorageSchemaTable () {
  const tableTitle = i18n.datastorage.recordTableTitleStepTwo;
  const tableSubTitle = i18n.datastorage.recordSubTitle;
  const pageSize = 7;
  const numberPagesToShow = 7;
  const history = useHistory();
  const dataParams = history && history.location && history.location.state;
  const schemaSelected = dataParams?.schemaSelected;

  const filterBodyRecords = {
    idCriteria: "",
    idOperator: enumCompareOperators.NONE,
    shortNameCriteria: "",
    shortNameOperator: enumCompareOperators.NONE,
    schemaCriteria: schemaSelected.shortName,
    schemaOperator: enumCompareOperators.TEXT_EQUALS,
    auxCriteria: "",
    auxOperator: enumCompareOperators.NONE
  };

  function handleGetData (activePage, filterBody, updateArrayData) {
    function afterGetRecords (arrayRecordData) {
      // Get all data fields that belongs to record
      const tenant = window.sessionStorage.getItem("tenant");
      const filterBodyData = {
        recordCriteria: "",
        recordOperator: enumCompareOperators.NONE,
        fieldValueCriteria: "",
        fieldValueOperator: enumCompareOperators.NONE,
        schemaCriteria: schemaSelected.shortName,
        schemaOperator: enumCompareOperators.TEXT_EQUALS,
        tenantCriteria: tenant,
        tenantOperator: enumCompareOperators.TEXT_EQUALS
      };
      /**
       * @param {*} arrayOfData contains all the data of one row.
       * [{record: '1', field: '', fieldValue: ''}, {record: '2', field: '', fieldValue: ''}...]
       */
      const newArrayOfData = [];
      function afterGetDataOfRecords (arrayOfAllData) {
        arrayRecordData.forEach((recordItem) => {
          const filterRecord = arrayOfAllData.filter(
            (itemData) => itemData.record === recordItem.shortName);
          const newData = {};
          const mapIds = new Map();
          filterRecord.forEach((dataForRow) => {
            newData.record = dataForRow.record;
            newData[dataForRow.field] = dataForRow.fieldValue;
            mapIds.set(dataForRow.field, dataForRow.id);
          });
          newData.mapIds = mapIds;
          newData.recordId = recordItem.id;
          newArrayOfData.push(newData);
        });
        updateArrayData(newArrayOfData);
      }
      handleFilterRequest(`storage-data/filter?page=${0}&size=${1000}`,
        filterBodyData,
        afterGetDataOfRecords);
    }
    handleFilterRequest(`storage-record/filter?page=${activePage - 1}&size=${pageSize}`,
      filterBodyRecords,
      afterGetRecords);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`storage-record/filter/size/${pageSize}`, filterBodyRecords, setTotalPages);
  }

  function handleDelete (data) {
    function afterDeleteData () {
      handleDeleteRequest(`storage-record/${data.recordId}`, undefined, undefined, undefined, true, false, true);
    }
    let index = 0;
    const message = i18n.errorMessages.confirmModal;
    const resultConfirm = window.confirm(message);
    if (resultConfirm) {
      if (data.mapIds.size === 0) {
        afterDeleteData();
      }
      data.mapIds.forEach((value, key) => {
        if (index === data.mapIds.size - 1) {
          handleDeleteRequest(`storage-data/${value}`, afterDeleteData, undefined, undefined, false, false, false);
        } else {
          handleDeleteRequest(`storage-data/${value}`, undefined, undefined, undefined, false, false, false);
        }
        index++;
      });
    }
  }

  function handleEdit (editData) {
    history.push({
      pathname: enumPaths.DATA_STORAGE_RECORD_FORM_STEP_TWO,
      state: { schemaSelected, editData }
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
    <StorageRecordGenericTable
      tableTitle={tableTitle}
      tableSubTitle={tableSubTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.FULL}
      schemaSelected={schemaSelected}
    >
    </StorageRecordGenericTable>
  );
}

export default StorageSchemaTable;
