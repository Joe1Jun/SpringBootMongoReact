import axios from "axios";


//Use axios.create() when you need to configure things like a baseURL, headers, or timeouts for all requests.
//You can also just use axios directly if no special configuration is needed.

export default axios.create({
    //Sets a base Url to be used
       baseURL: 'http://localhost:8080',
       headers: {"ngrok-skip-browser-warning" : "true"}

});