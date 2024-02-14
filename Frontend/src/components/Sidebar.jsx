
import { BsGrid1X2Fill,BsGraphUp, BsCalendar,BsPersonFill,BsCardChecklist, BsListCheck} from 'react-icons/bs';
import 'C:/Users/mohan/jobapp/demo/src/assets/css/admin/admin.css';

function Sidebar( openSidebarToggle, OpenSidebar ) {
  return (
    <aside id="sidebar" className={openSidebarToggle ? "sidebar-responsive" : ""}>
      <div className='sidebar-title'>
        <div className='sidebar-brand'>
          JOBWIZ..
        </div>
        <span className='icon close_icon' onClick={OpenSidebar}>X</span>
      </div>

      <ul className='sidebar-list'>
        <li className='sidebar-list-item'>
          <a href="">
            <BsGrid1X2Fill className='icon' /> Dashboard
          </a>
        </li>
        <li className='sidebar-list-item'>
          <a href="">
            <BsPersonFill className='icon'/> Profile
          </a>
        </li>
        <li className='sidebar-list-item'>
          <a href="/admin/application">
          <BsCardChecklist className='icon'/> Application
          </a>
        </li>
        <li className='sidebar-list-item'>
          <a href="">
          <BsCalendar className='icon'/>Calendar
          </a>
        </li>
        <li className='sidebar-list-item'>
          <a href="">
            <BsListCheck className='icon' /> FAQ
          </a>
        </li>
        <li className='sidebar-list-item'>
          <a href="">
          <BsGraphUp className='icon'/> Statistics
          </a>
        </li>
      </ul>
    </aside>
  )
}

export default Sidebar;
