import React from "react";
import CommonCard from "./CommonCard";

export default {
  title: "CommonCard",
  component: CommonCard
};

const Template = (args) => <CommonCard {...args} />;

export const CommonCard1 = Template.bind({});

CommonCard1.args = {};

export const CommonCard2 = Template.bind({});

const getBody = () => {
  return <div>Some Body</div>;
};

const getHeader = () => {
  return <div>Some Header</div>;
};

CommonCard2.args = {
  header: getHeader(),
  body: getBody(),
  as: "h4"
};

export const CommonCard3 = Template.bind({});

CommonCard3.args = {
  header: getHeader(),
  body: getBody(),
  as: "h4",
  backgroundVariant: "light",
  textVariant: "dark",
  width: "18rem"
};

export const CommonCard4 = Template.bind({});

CommonCard4.args = {
  header: getHeader(),
  body: getBody(),
  as: "h4",
  backgroundVariant: "info",
  textVariant: "white",
  width: "18rem"
};
