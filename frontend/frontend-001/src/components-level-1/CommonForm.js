import React from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import PropTypes from "prop-types";
import enumInputType from "./../models/enumInputType";
import enumBootstrapVariant from "./../models/enumBootstrapVariant";

import "./CommonForm.css";

function CommonForm ({
  title,
  handleAction,
  buttonText,
  buttonVariant,
  schema
}) {
  return (
    <div className="puggysoft-form" >
      <Card>
        <Card.Header as="h3">{title}</Card.Header>
        <Card.Body>
          <Form>
            {schema.map(function (item) {
              console.log({ item });
              return (
                <>
                  {(item.inputType === enumInputType.TEXT ||
                    item.inputType === enumInputType.NUMBER ||
                    item.inputType === enumInputType.PASSWORD ||
                    item.inputType === enumInputType.DATE) &&
                    <Form.Group key={item.key} className="mb-3">
                      <Form.Label>
                        {item.label}
                      </Form.Label>
                      <Form.Control
                        disabled={item.isDisabledEdit}
                        onChange={item.onChange}
                        value={item.inputValue}
                        type={item.inputType}
                      />
                      <Form.Text muted className={item.suggestionTextClassName}>
                        {item.suggestionText}
                      </Form.Text>
                    </Form.Group>
                  }
                  {item.inputType === enumInputType.SELECT &&
                    <Form.Group key={item.key} className="mb-3">
                      <Form.Label>
                        {item.label}
                      </Form.Label>
                      <Form.Select
                        disabled={item.isDisabledEdit}
                        onChange={item.onChange}
                        value={item.inputValue} >
                        {item.inputSelectOption && item.inputSelectOption.map(function (itemDropDown) {
                          return <option key={itemDropDown.key} value={itemDropDown.value}>{itemDropDown.label}</option>;
                        })}
                      </Form.Select>
                      <Form.Text muted className={item.suggestionTextClassName}>
                        {item.suggestionText}
                      </Form.Text>
                    </Form.Group>
                  }
                </>
              );
            })}
            <Button
              onClick={handleAction}
              variant={buttonVariant}
              type="button"
            >
              {buttonText}
            </Button>
          </Form>
        </Card.Body>
      </Card>
    </div>
  );
}

export default CommonForm;

CommonForm.propTypes = {
  title: PropTypes.string,
  handleAction: PropTypes.func,
  buttonText: PropTypes.string,
  buttonVariant: PropTypes.oneOf(
    enumBootstrapVariant.SUCCESS,
    enumBootstrapVariant.WARNING,
    enumBootstrapVariant.SECONDARY,
    enumBootstrapVariant.PRIMARY,
    enumBootstrapVariant.LIGHT,
    enumBootstrapVariant.INFO,
    enumBootstrapVariant.DANGER,
    enumBootstrapVariant.DARK
  ),
  schema: PropTypes.arrayOf({
    key: PropTypes.string,
    inputType: PropTypes.oneOf(
      [
        enumInputType.TEXT,
        enumInputType.NUMBER,
        enumInputType.DATE,
        enumInputType.EMAIL,
        enumInputType.PASSWORD,
        enumInputType.SELECT
      ]
    ),
    label: PropTypes.string,
    inputValue: PropTypes.string,
    suggestionText: PropTypes.string,
    suggestionTextClassName: PropTypes.oneOf("", "puggysoft-red-text"),
    isValid: PropTypes.func,
    onChange: PropTypes.func,
    isDisabledEdit: PropTypes.bool,
    inputSelectOption: PropTypes.arrayOf({
      key: PropTypes.string,
      value: PropTypes.string,
      label: PropTypes.string
    })
  })
};

CommonForm.defaultProps = {
  title: "",
  handleAction: () => { },
  buttonText: "",
  schema: []
};
