import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const { REACT_APP_BACKEND_PROTOCOL } = process.env;
const { REACT_APP_BACKEND_HOST } = process.env;
const { REACT_APP_BACKEND_PORT } = process.env;
const { REACT_APP_BACKEND_VERSION } = process.env;

let baseUrl = "";
baseUrl = baseUrl.concat(REACT_APP_BACKEND_PROTOCOL);
baseUrl = baseUrl.concat("://");
baseUrl = baseUrl.concat(REACT_APP_BACKEND_HOST);
baseUrl = baseUrl.concat(":");
baseUrl = baseUrl.concat(REACT_APP_BACKEND_PORT);
baseUrl = baseUrl.concat(REACT_APP_BACKEND_VERSION);

export const baseApi = createApi({
  baseQuery: fetchBaseQuery({
    baseUrl,
    prepareHeaders: (headers) => {
      const token = window.sessionStorage.getItem("token");
      headers.set("Authorization", token);
      return headers;
    }
  }),
  endpoints: () => ({})
});
