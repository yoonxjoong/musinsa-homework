import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8080/api', // Spring Boot API의 기본 URL
    timeout: 5000,
    headers: { 'Content-Type': 'application/json' }
});

export default instance;