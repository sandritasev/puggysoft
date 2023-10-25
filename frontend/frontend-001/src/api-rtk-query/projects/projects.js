import { baseApi as api } from "./../baseApi";

/**
 * Query: Si está obteniendo y almacenando en caché datos del servidor.
 * Mutation:  Si estás actualización al servidor o no quieres guardar en cache.
 */
const projectsApi = api.injectEndpoints({
  endpoints: (build) => ({
    getProjects: build.mutation({
      query: (projectId) => ({
        url: `/todo-projects/${projectId}`,
        method: "GET"
      })
    }),
    getProjectsFilter: build.query({
      query: (page, size, filter) => ({
        url: `/todo-projects/filter?page=${page}&size=${size}`,
        method: "POST",
        body: filter
      }),
      providesTags: ["projectsList"]
    }),
    getProjectsFilterSize: build.query({
      query: (size, filter) => ({
        url: `/todo-projects/filter/size${size}`,
        method: "POST",
        body: filter
      }),
      providesTags: ["projectsTotalPages"]
    }),
    postProject: build.mutation({
      query: (newProject) => ({
        url: "/todo-projects",
        method: "POST",
        body: newProject
      }),
      invalidatesTags: ["projectsList", "projectsTotalPages"]
    }),
    putProject: build.mutation({
      query: (project, id) => ({
        url: `/todo-projects/${id}`,
        method: "PUT",
        body: project
      }),
      invalidatesTags: ["projectsList", "projectsTotalPages"]
    }),
    deleteProject: build.mutation({
      query: (id) => ({
        url: `/todo-projects/${id}`,
        method: "DELETE"
      }),
      invalidatesTags: ["projectsList", "projectsTotalPages"]
    })
  })
});

export const {
  useGetProjectsMutation,
  useGetProjectsFilterQuery,
  useGetProjectsFilterSizeQuery,
  usePostProjectMutation,
  usePutProjectMutation,
  useDeleteProjectMutation
} = projectsApi;
