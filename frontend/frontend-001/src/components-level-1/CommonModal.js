import React, { useState } from "react";
import PropTypes from "prop-types";
import Modal from "react-bootstrap/Modal";

function CommonModal ({
  isVisible,
  size,
  closeButton,
  centered,
  scrollable,
  titleText,
  bodyContent,
  footerContent
}) {
  const [show, setShow] = useState(isVisible);
  const handleClose = () => setShow(false);
  return (
    <Modal
      size={size}
      show={show}
      onHide={handleClose}
      centered={centered}
      scrollable={scrollable}
    >
      <Modal.Header closeButton={closeButton}>
        <Modal.Title>{titleText}</Modal.Title>
      </Modal.Header>
      <Modal.Body>{bodyContent}</Modal.Body>
      <Modal.Footer>{footerContent}</Modal.Footer>
    </Modal>
  );
}

export default CommonModal;
CommonModal.propTypes = {
  isVisible: PropTypes.bool,
  size: PropTypes.oneOf([
    "sm",
    "lg",
    "xl"
  ]),
  centered: PropTypes.bool,
  closeButton: PropTypes.bool,
  scrollable: PropTypes.bool,
  titleText: PropTypes.string,
  bodyContent: PropTypes.node,
  footerContent: PropTypes.node
};

CommonModal.defaultProps = {
  isVisible: false,
  size: "lg",
  closeButton: true,
  centered: false,
  scrollable: false,
  titleText: "Modal Example",
  setIsVisible: () => { },
  bodyContent: <></>,
  footerContent: <></>
};
