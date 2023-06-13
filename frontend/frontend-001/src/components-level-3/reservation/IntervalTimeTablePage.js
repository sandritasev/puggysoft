import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import IntervalTimeTable from "../../components-level-2/reservation/IntervalTimeTableEditDelete";

function IntervalTimeTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <IntervalTimeTable></IntervalTimeTable>
    </div>
  );
}

export default IntervalTimeTablePage;
