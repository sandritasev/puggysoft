import React from "react";
import PropTypes from "prop-types";

function CommonDragDropWrapper ({
  type,
  children,
  className
}) {
  const onDrop = (event) => {
    event.preventDefault();
    const data = event.dataTransfer.getData("text");
    const source = document.getElementById(data);
    event.target.appendChild(source);
  };

  const onDragOver = (event) => {
    event.preventDefault();
  };

  const onDragStart = (event) => {
    event.dataTransfer.setData("text/plain", event.target.id);
  };

  const renderDragDrop = () => {
    if (type === "dropZone") {
      return <div
        onDrop={onDrop}
        onDragOver={onDragOver}
        className={className}
      >
        {children}
      </div>;
    } else if (type === "dragDropItem") {
      return <div
        onDragStart={onDragStart}
        draggable="true"
        className={className}
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
  className: PropTypes.string
};

CommonDragDropWrapper.defaultProps = {
  type: "dragDropItem",
  children: <></>,
  className: ""
};
