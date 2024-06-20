import { Link } from "react-router-dom";
import axios from 'axios'
import React, { useEffect, useState } from 'react';
import {Button, Header, Menu} from "grommet";

function AudioListView() {

    let list = {
        field : ""
    }

    const [s,setS] = useState();

    function getList() {
        axios.get("/client").then(res => console.log(res.data))
    }


    useEffect(() => {
        getList()
    }, )


    return (

        <div className={"wrapper"}>
            This is audio page
            <Link to={".."}>to main view version green</Link>
            <p>{s}</p>
        </div>
    )
}

export default AudioListView;