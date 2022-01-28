import { getData } from "../../utils/http-client";

const Greeting = function () {
    return getData('/greeting', 'GET', null, null );
}

export default Greeting;