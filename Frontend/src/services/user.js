import instance from "./axios";


const api_uri = "http://localhost:8181";

export const applicationList = () => instance.get(`${api_uri}/api/v1/app/getapp`);
export const deleteApplication=()=>instance.get(`${api_uri}/api/v1/app/deleteApplication/{applicationId}`);
export const getJobs = () => instance.get(`${api_uri}/api/v1/jobs/getjob`);