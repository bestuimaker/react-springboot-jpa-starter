import { getData } from "../../utils/http-client";



const Greeting = function () {
    return getData();
}

export default Greeting;