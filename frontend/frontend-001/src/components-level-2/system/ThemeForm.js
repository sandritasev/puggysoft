import React from "react";
import { useHistory } from "react-router";
import { useDispatch } from "react-redux";

import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import i18n from "../../i18n/i18n";
import useInput from "../../hooks/useInput";
import enumBootstrapVariant from "../../models/enumBootstrapVariant";
import enumPaths from "./../../models/enumPaths";
import { openCommonMessage } from "./../../redux/reducers/reducerCommonMessage";

import "./../css/all-forms.css";

function ThemeForm () {
  const history = useHistory();
  const dispatch = useDispatch();
  const theme = window.localStorage.getItem("theme");
  const { value: valueTheme, onChange: onChangeTheme } = useInput(theme || enumBootstrapVariant.DARK);

  const handleAdd = (event) => {
    if (valueTheme) {
      window.localStorage.setItem("theme", valueTheme);
      dispatch(openCommonMessage(
        {
          isMessageModalVisible: true,
          messageModalTitle: i18n.successMessages.successTitle,
          messageModalBody: i18n.successMessages.successfullyEdited,
          messageModalVariant: valueTheme
        }
      ));
      history.push(enumPaths.THEME_FORM);
    } else {
      dispatch(openCommonMessage(
        {
          isMessageModalVisible: true,
          messageModalTitle: i18n.errorMessages.validationErrorTitle,
          messageModalBody: i18n.errorMessages.validationError,
          messageModalVariant: "danger"
        }
      ));
    }
  };

  return (
    <div className="puggysoft-theme-form puggysoft-form-thirty-with" >
      <Card>
        <Card.Header as="h3">{i18n.themeForm.themeForm}</Card.Header>
        <Card.Body>
          <Form>
            <Form.Group className="mb-3" controlId="select-theme">
              <Form.Label>{i18n.themeForm.fieldTheme}</Form.Label>
              <Form.Select
                onChange={onChangeTheme}
                value={valueTheme} >
                <option key="option-dark" value={enumBootstrapVariant.DARK}>{i18n.themeForm.darkTheme}</option>
                <option key="option-light" value={enumBootstrapVariant.LIGHT}>{i18n.themeForm.lightTheme}</option>
                <option key="option-primary" value={enumBootstrapVariant.PRIMARY}>{i18n.themeForm.primaryTheme}</option>
                <option key="option-secondary" value={enumBootstrapVariant.SECONDARY}>{i18n.themeForm.secondaryTheme}</option>
              </Form.Select>
            </Form.Group>
            <Button
              onClick={handleAdd}
              variant="primary"
              type="button">{i18n.commonTable.addButton}</Button>
          </Form>
        </Card.Body>
      </Card>
    </div >
  );
}

export default ThemeForm;
