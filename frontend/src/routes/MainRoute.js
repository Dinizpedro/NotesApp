import React from "react";
import {BrowserRouter as Router, Link, Route, Routes} from "react-router-dom";
import Register from "../components/Register";

export default function MainRoute() {
    return (
        <Router>
            <div>

                <Routes>
                    <Route path='register' element={<Register/>}></Route>
                </Routes>
            </div>
        </Router>
    )
}