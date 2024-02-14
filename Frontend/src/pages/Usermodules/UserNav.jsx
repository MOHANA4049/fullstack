// eslint-disable-next-line no-unused-vars
import React from 'react'
import 'C:/Users/mohan/demo/src/assets/css/user/usernav.css'

export default function UserNav () {
  return (
    <div className='navbar flex justify-between items center p-[2rem]'>
        <div className='logoDiv'>
            <h1 className='logo text-[30px] text-blueColor '><strong>Jobwiz...</strong></h1>
        </div>
        <div className='menu flex gap-8'>
            <li id='userli' className='menulist text-[#6f6f6f] hover:text-blueColor'>Jobs</li>
            <li id='userli' className='menulist text-[#6f6f6f] hover:text-blueColor'>Companies</li>
            <li id='userli' className='menulist text-[#6f6f6f] hover:text-blueColor'>About</li>
            <li id='userli' className='menulist text-[#6f6f6f] hover:text-blueColor'>Contact</li>
        </div></div>)
}