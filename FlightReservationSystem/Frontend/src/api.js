import axios from "axios"

//${process.env.REACT_APP_API_URL}
console.log(process.env.REACT_APP_API_URL);
const api = axios.create({
    
    baseURL : `${process.env.REACT_APP_API_URL}/api`,
});

export default api;