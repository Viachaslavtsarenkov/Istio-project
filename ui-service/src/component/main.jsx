import { Link } from "react-router-dom";
import '../styles/style.css';

function main() {
  
    return (
        <div className={"wrapper main"}>
            This is main page <br/>
            <Link to={"audio"}>to list view</Link>
        </div>
    )
}

export default main;