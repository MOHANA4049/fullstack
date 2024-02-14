import { Suspense, lazy } from "react"
import {RouterProvider, createBrowserRouter} from "react-router-dom"
import Home from "./pages/Home"
import Spinner from "./components/spinner"
import Signup from './pages/Signup.jsx'
// import JobList from "./pages/Joblist.jsx"
// import JobList from 'C:/Users/mohan/jobapp/demo/src/pages/Joblist.jsx'
import Application from "./pages/Form.jsx"
import AdminDashboard from "./pages/admin.jsx"
import Usersapplication from "./pages/Adminmodules/Usersapplication.jsx"
// import Logs from "./pages/log.jsx"
import User from "./pages/Usermodules/User.jsx"
const Lazyabout=lazy(()=>import("./pages/About.jsx"))
const Lazylogin=lazy(()=>import("./pages/Login.jsx"))
const Lazycontact=lazy(()=>import("./pages/Contact.jsx"))
// const Lazyuser=lazy(()=>import("./pages/Usermodules/User.jsx"))
const App=()=>{
  const router = createBrowserRouter([
    {
      path: `/home`,
      element:<Suspense fallback={<Spinner/>}><Home/></Suspense>
    },
    {
      path: `/about`,
      element:<Suspense fallback={<Spinner/>}><Lazyabout/></Suspense>
    },
    {
      path: `/contact`,
      element:<Suspense fallback={<Spinner/>}><Lazycontact/></Suspense>
    },
    // {
    //   path: `/joblist`,
    //   element:<Suspense fallback={<Spinner/>}><JobList/></Suspense>
    // },
    {
      path: `/login`,
      element:<Suspense fallback={<Spinner/>}><Lazylogin/></Suspense>
    },
    {
      path: `/signup`,
      element:<Suspense fallback={<Spinner/>}><Signup/></Suspense>
    },
    {
      path: `/form`,
      element:<Suspense fallback={<Spinner/>}><Application/></Suspense>
    },
    {
      path:`/user`,
      element:<Suspense fallback={<Spinner/>}><User/></Suspense>},
      {
        path:`/admin`,
        element:<Suspense fallback={<Spinner/>}><AdminDashboard/></Suspense>},
        {
          path:`/admin/application`,
          element:<Suspense fallback={<Spinner/>}><Usersapplication/></Suspense>},
  ]);

    return (
    <RouterProvider router={router}/>
  )
}

export default App;