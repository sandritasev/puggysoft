import enumTenantFields from "./enumTenantFields";
import enumTableFieldType from "../enumTableFieldType";
import appUrlConfig from "../../tools/appUrlConfig";

const fileName = "user-default.jpg";
const imageUrl = `${appUrlConfig.URL}/${fileName}`;

const arrayDataFields = [
  {
    value: enumTenantFields.IMAGE,
    type: enumTableFieldType.IMAGE,
    imageMaxWidth: "50%",
    tdWidth: "5%",
    defaultImageUrl: imageUrl
  },
  enumTenantFields.ID,
  enumTenantFields.NAME,
  enumTenantFields.SHORTNAME,
  enumTenantFields.STATUS,
  enumTenantFields.DESCRIPTION,
  enumTenantFields.TELEPHONE,
  enumTenantFields.ADDRESS,
  enumTenantFields.CREATED_BY,
  enumTenantFields.UPDATED_BY,
  enumTenantFields.CREATION_DATE,
  enumTenantFields.UPDATE_DATE
];

export default arrayDataFields;
