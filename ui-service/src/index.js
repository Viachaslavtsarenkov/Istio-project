import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import Main from './component/main';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import AudioListView from './component/AudioListView';
import Header from './component/header';

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
    <Header/>
    <RouterProvider router={router} />
  </React.StrictMode>
);
registerServiceWorker()
