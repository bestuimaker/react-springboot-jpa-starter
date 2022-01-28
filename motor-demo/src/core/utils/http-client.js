import axios from 'axios';
const baseURL = 'http://localhost:8787/motor-insurance';
export function getData() {
    return axios.get(baseURL+'/greeting');
}