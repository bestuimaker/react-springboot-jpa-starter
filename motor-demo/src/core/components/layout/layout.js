import { Outlet } from "react-router-dom";
import Header from "../../../shared/components/header/header";
import Sidebar from "../../../shared/components/sidebar/sidebar";


function Layout() {
    return (
        <div className="App">
            <Header />
            <div className="container-fluid">
                <div className="row">
                    <Sidebar />
                    <Outlet />
                </div>
            </div>
        </div>
    );
}

export default Layout;