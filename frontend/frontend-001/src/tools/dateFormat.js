import i18n from "../i18n/i18n";

/**
 * @param dateString in format 2023-04-27T13:23:51Z.
 * @returns date in format. 18 April 2023 5:30pm.
 */
const getFormattedDate = (dateString) => {
  const date = new Date(dateString);
  const month = date.getUTCMonth();
  const day = date.getUTCDate();
  const year = date.getUTCFullYear();
  const time = date.toLocaleString(
    "en-US",
    {
      hour: "numeric",
      minute: "numeric",
      hour12: true
    }
  );
  return `${day} ${i18n.commonMonths[month]} ${year} ${time}`;
};

export default { getFormattedDate };
