import { Link } from "react-router-dom";
import '../styles/style.css';
import React from "react";
import {Heading, Main, Paragraph} from "grommet";

function main() {
  
    return (
        <div className={"wrapper"}>
            <Main pad="large">
                <Heading>Audio</Heading>
                <Paragraph>Something about something</Paragraph>
            </Main>
        </div>
    )
}

export default main;