import axios, {AxiosInstance} from "axios";

const baseUrl:string = "http://localhost:8999";

export const MKServer:AxiosInstance = axios.create({
    baseURL:baseUrl,
});
