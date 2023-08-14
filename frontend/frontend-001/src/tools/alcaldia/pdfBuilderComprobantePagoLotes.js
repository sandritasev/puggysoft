import { jsPDF } from "jspdf";
import i18n from "../../i18n/i18n";

function pdfBuilderComprobantePagoLotes (itemData, totalToPay, arrayOfProducts) {
  /* eslint-disable new-cap */
  const doc = new jsPDF("p", "mm", [60, 80]); // Document of 58mm wide and 60mm high
  doc.setFontSize(12);
  doc.text(`${i18n.regulaLotesPdf.ticketNumber} : ${itemData.id}`, 5, 7);
  doc.line(5, 8, 53, 8);
  doc.setFontSize(8);
  doc.text(`${i18n.regulaLotesPdf.client} : ${itemData.client}`, 5, 13);
  doc.text(`${i18n.regulaLotesPdf.orderedBy} : ${itemData.createdBy}`, 5, 16);
  doc.line(5, 17, 53, 17);
  doc.text(`${i18n.regulaLotesPdf.totalToPay} : ${totalToPay}`, 5, 21);
  doc.line(5, 23, 53, 23);
  doc.setFontSize(7);
  const docString = doc.output("datauristring");
  const embed = "<embed width='100%' height='100%' src='" + docString + "'/>";
  // doc.save("a4.pdf");
  const myWindows = window.open(
    "pdfwindows",
    "pdfwindows",
    "width=1280,height=1280");
  myWindows.document.open();
  myWindows.document.write(embed);
  myWindows.document.close();
}

export default pdfBuilderComprobantePagoLotes;
