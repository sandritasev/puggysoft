import React from "react";
import CommonModal from "./CommonModal";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

export default {
  title: "CommonModal",
  component: CommonModal
};

const Template = (args) => <CommonModal {...args} />;

export const CommonModalTemplate1 = Template.bind({});

CommonModalTemplate1.args = {
  isVisible: true,
  titleText: "Story book example",
  bodyContent: <div>Some Body Conent</div>,
  footerContent: <div>Some Footer Content</div>
};

export const CommonModalTemplate2 = Template.bind({});

const bodyContent = <Form>
  <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
    <Form.Label>Email address</Form.Label>
    <Form.Control
      type="email"
      placeholder="name@example.com"
      autoFocus
    />
  </Form.Group>
  <Form.Group
    className="mb-3"
    controlId="exampleForm.ControlTextarea1"
  >
    <Form.Label>Example textarea</Form.Label>
    <Form.Control as="textarea" rows={3} />
  </Form.Group>
</Form>;

const footerContent = <>
  <Button variant="secondary">
    Close
  </Button>
  <Button variant="primary">
    Save Changes
  </Button>
</>;

CommonModalTemplate2.args = {
  isVisible: true,
  titleText: "Story book example",
  bodyContent,
  footerContent
};
