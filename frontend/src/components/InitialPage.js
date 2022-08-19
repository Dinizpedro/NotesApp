import * as React from 'react';
import {Link} from "react-router-dom";

export default function InitialPage() {
    return (
        <body>
        <div className="container text-center">
            <h1>Welcome to Notes-App</h1>
            <Link to="register"> Register</Link>
            <h3><a>Login</a></h3>
        </div>

        </body>
    );
}
