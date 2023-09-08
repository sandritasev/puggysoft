import React from "react";
import PropTypes from "prop-types";
import Card from "react-bootstrap/Card";

function CommonCard ({
  header,
  body,
  as,
  width,
  backgroundVariant,
  textVariant,
  className,
  key
}) {
  return (
    <Card
      style={{ width }}
      bg={backgroundVariant}
      text={textVariant}
      className={className}
      key={key}
    >
      <Card.Header
        as={as}
      >
        {header}
      </Card.Header>
      <Card.Body>
        {body}
      </Card.Body>
    </Card>
  );
}

export default CommonCard;

CommonCard.propTypes = {
  header: PropTypes.node,
  body: PropTypes.node,
  as: PropTypes.oneOf(["h1", "h2", "h3", "h4"]),
  width: PropTypes.string,
  backgroundVariant: PropTypes.oneOf([
    "primary",
    "secondary",
    "success",
    "danger",
    "warning",
    "info",
    "light",
    "dark"
  ]),
  textVariant: PropTypes.oneOf(["dark", "white"]),
  className: PropTypes.string,
  key: PropTypes.string
};

CommonCard.defaultProps = {
  header: <></>,
  body: <></>,
  as: "h4",
  width: "", // Eg. 18rem
  backgroundVariant: "",
  textVariant: "",
  className: "",
  key: ""
};
