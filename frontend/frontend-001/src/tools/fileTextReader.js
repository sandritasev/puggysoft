/**
 *
 * @param {*} file event.target.files[0];
 */
function fileReader (file) {
  const readerObj = new FileReader();
  let fileText = "";
  readerObj.onload = function () {
    fileText = readerObj.result;
  };
  readerObj.readAsText(file);
  return fileText;
}

/**
 *
 * @param {*} file event.target.files[0];
 * @returns array of lines.
 */
function fileReaderByLines (file) {
  const readerObj = new FileReader();
  const output = [];
  readerObj.onload = function (event) {
    const text = event.target.result;
    const lines = text.split(/[\r\n]+/g);
    for (let i = 0; i < lines.length; i++) {
      if (lines[i].length > 240) {
        output.push("<li>" + lines[i] + "<br>");
      }
    }
  };
  readerObj.readAsText(file, "UTF-8");
  console.log({ output });
  return output;
}

export { fileReader, fileReaderByLines };
