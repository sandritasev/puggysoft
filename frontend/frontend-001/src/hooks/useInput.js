import { useState } from "react";

const useInput = (initialValue) => {
  const [value, setValue] = useState(initialValue);

  return {
    value,
    setValue,
    reset: () => setValue(""),
    onChange: (event) => {
      event.preventDefault();
      setValue(event.target.value);
    }
  };
};

export default useInput;
