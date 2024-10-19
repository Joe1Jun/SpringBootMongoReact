import axios from "axios";


//Use axios.create() when you need to configure things like a baseURL, headers, or timeouts for all requests.
//You can also just use axios directly if no special configuration is needed.

export default axios.create({
       baseURL: 'https://9c96-103-106-239-104.ap.ngrok.io/',
       headers: {"ngrok-skip-browser-warning" : "true"}

});