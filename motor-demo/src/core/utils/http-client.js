import axios from 'axios';
const baseURL = 'http://localhost:8787';

export function getData(endpoint, method, headers, payload) {
    // we will use the unused parameter later
    return axios.get(baseURL+endpoint);
}