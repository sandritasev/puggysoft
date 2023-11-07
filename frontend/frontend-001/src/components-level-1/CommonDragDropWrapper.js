import React from "react";
import PropTypes from "prop-types";

function CommonDragDropWrapper ({
  type,
  children,
  className,
  id,
  dragDropkey,
  onDragStartAction,
  onDragOverAction,
  onDropAction
}) {
  const onDrop = (event) => {
    event.preventDefault();
    // Final
    const idItem = event.dataTransfer.getData("text");
    onDropAction(idItem, id);
    const source = document.getElementById(idItem);
    if (!source.contains(event.target)) {
      event.target.appendChild(source);
    }
  };

  const onDragOver = (event) => {
    event.preventDefault();
    onDragOverAction();
    // Second
  };

  const onDragStart = (event) => {
    // First
    onDragStartAction();
    const idItem = event.target.id;
    event.dataTransfer.setData("text/plain", idItem);
  };

  const renderDragDrop = () => {
    if (type === "dropZone") {
      return <div
        onDrop={onDrop}
        onDragOver={onDragOver}
        className={className}
        id={"dropZone" - id}
        key={dragDropkey}
      >
        {children}
      </div>;
    } else if (type === "dragDropItem") {
      return <div
        onDragStart={onDragStart}
        draggable="true"
        className={className}
        id={id}
        key={dragDropkey}
      >
        {children}
      </div>;
    } else {
      return <></>;
    }
  };

  return renderDragDrop();
}

export default CommonDragDropWrapper;

CommonDragDropWrapper.propTypes = {
  type: PropTypes.oneOf(["dropZone", "dragDropItem"]),
  children: PropTypes.node,
  className: PropTypes.string,
  id: PropTypes.string,
  dragDropkey: PropTypes.string,
  onDragOverAction: PropTypes.func,
  onDragStartAction: PropTypes.func,
  onDropAction: PropTypes.func
};

CommonDragDropWrapper.defaultProps = {
  type: "dragDropItem",
  children: <></>,
  className: "",
  id: "",
  dragDropkey: "",
  onDragOverAction: () => { },
  onDragStartAction: () => { },
  onDropAction: () => { }
};
