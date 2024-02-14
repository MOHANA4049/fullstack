import 'C:/Users/mohan/jobapp/demo/src/assets/css/admin/admin.css'
import Header from 'C:/Users/mohan/jobapp/demo/src/components/Header.jsx'
import Sidebar from 'C:/Users/mohan/jobapp/demo/src/components/Sidebar.jsx'
import AdminHome from '../components/adminhome'
import { useState } from 'react'

function AdminDashboard() {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false)

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle)
  }
  return (
    <div className='grid-container'>
      <Header OpenSidebar={OpenSidebar}/>
      <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar}/>
      <AdminHome/>
    </div>
  )
}

export default AdminDashboard;