import { Link } from "react-router-dom";

function AudioListView() {
  
    return (
        <div className={"wrapper"}>
            This is audio page
            <Link to={".."}>to main view</Link>
        </div>
    )
}

export default AudioListView;