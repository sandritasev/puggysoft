import React from "react";
import CommonMessage from "./../../components-level-1/CommonMessage";
import { useSelector, useDispatch } from "react-redux";
import { closeCommonMessage } from "./../../redux/reducers/reducerCommonMessage";

function CommonMessageRedux () {
  const stateCommonMessage = useSelector(state => state);
  const dispatch = useDispatch();
  const handleClose = () => {
    dispatch(closeCommonMessage());
  };
  return (
    <CommonMessage
      isVisible={stateCommonMessage.isMessageModalVisible}
      setIsVisible={handleClose}
      titleText={stateCommonMessage.messageModalTitle}
      bodyText={stateCommonMessage.messageModalBody}
      varian={stateCommonMessage.messageModalVariant}
    />
  );
}

export default CommonMessageRedux;
