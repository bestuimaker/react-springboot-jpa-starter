import { getData } from "../../utils/http-client";

const SalesOrders = function () {
    return getData('/sales', 'GET', null, null );
}

export default SalesOrders;