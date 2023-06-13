import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import ScheduleTable from "../../components-level-2/reservation/ScheduleTableEditDelete";

function ScheduleTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <ScheduleTable></ScheduleTable>
    </div>
  );
}

export default ScheduleTablePage;
