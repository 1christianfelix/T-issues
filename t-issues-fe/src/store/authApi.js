import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const baseQuery = fetchBaseQuery({
  baseUrl: "http://localhost:8080",
});

export const authApi = createApi({
  reducerPath: "authentication",
  tagTypes: ["User"],
  baseQuery,
  endpoints: (builder) => ({
    login: builder.mutation({
      query: (data) => ({
        url: `/users/login`,
        method: `POST`,
        body: data,
      }),
    }),
  }),
});

export const { useLoginMutation } = authApi;
