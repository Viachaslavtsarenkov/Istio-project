import { Link } from "react-router-dom";
import axios from 'axios'
import React, { useEffect, useState } from 'react';

function AudioListView() {

    let list = {
        field : ""
    }

    const [s,setS] = useState();



    useEffect(() => {
        getList()
    }, )


    return (

        <div className={"wrapper"}>
            This is audio page
            <Link to={".."}>to main view</Link>
            <p>{s}</p>
        </div>
    )
}

export default AudioListView;