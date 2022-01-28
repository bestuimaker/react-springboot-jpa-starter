import Greeting from "../../services/greeting/greeting";
import SalesOrders from "../../services/sales-orders/sales-orders";

import { useEffect, useState } from "react";

function Dashboard() {
  const [message, setMessage] = useState("Hello");
  const [salesOrder, setSaleOrder] = useState([]);

  useEffect(() => {
    Greeting().then((response) => {
      setMessage(response.data.content);
      console.log(response.data);
    });
    SalesOrders().then((response) => {
      console.log(response.data);
      setSaleOrder(response.data);
    });
  }, []);
  return (
    <div className="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div className="d-flex justify-content-between pt-3 pb-2 mb-3 flex-wrap flex-md-nowrap align-items-center border-bottom">
        <h1 className="h2">Dashboard {message}</h1>
        <div className="btn-toolbar mb-2 mb-md-0">
          <div className="btn-group me-2">
            <button type="button" className="btn btn-sm btn-outline-secondary">
              Share
            </button>
            <button type="button" className="btn btn-sm btn-outline-secondary">
              Export
            </button>
          </div>
          <button
            type="button"
            className="btn btn-sm btn-outline-secondary dropdown-toggle"
          >
            <span data-feather="calendar"></span>
            This week
          </button>
        </div>
      </div>

      <div className="mb-3">
        <div className="table-responsive">
          <table className="table table-striped table-bordered table-sm">
            <thead>
              <tr>
                <th scope="col">Order Number</th>
                <th scope="col">Name</th>
                <th scope="col">Customer</th>
                <th scope="col">Ordered on</th>
                <th scope="col">Total</th>
              </tr>
            </thead>
            <tbody>
              {salesOrder.map((order, orderKey) => {
                return [
                  <tr key={1}>
                    <th>{order.orderID}</th>
                    <th>{order.orderName}</th>
                    <th>
                      [{order.customerID}]{order.customerName}
                    </th>
                    <th>{order.orderDate}</th>
                    <th>{order.orderTotal}</th>
                  </tr>,
                  <tr key={2}>
                      <td colSpan="5">
                      Product Ordered
                    {order.products.map((product, productKey) => {
                      return (
                        <p key={productKey}>
                          Product ID : <strong>{product.productID}</strong>, Product Name : <strong>{product.productName}</strong>, Product Quantity : <strong>{product.productQuantity}</strong>
                        </p>
                      );
                    })}

                      </td>
                  </tr>,
                ];
              })}
            </tbody>
          </table>
        </div>
      </div>

      <h2>All Sales</h2>
      <canvas
        className="my-4 w-100"
        id="myChart"
        width="900"
        height="380"
      ></canvas>
    </div>
  );
}

export default Dashboard;
