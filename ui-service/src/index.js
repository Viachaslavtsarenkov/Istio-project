import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Main from './component/main';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import AudioListView from './component/AudioListView';
import registerServiceWorker from './RegisterServiceWorker';
import {Button, Header, Menu} from "grommet";
//todo

const router = createBrowserRouter([
  {
    path: "/",
    element: <Main/>
  },
  {
    path: "/audio",
    element: <AudioListView />
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
registerServiceWorker()
