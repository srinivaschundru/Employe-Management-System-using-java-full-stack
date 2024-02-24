import React from 'react'
import { useState,useEffect } from 'react'
import { deleteEmployee, listEmployee } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {
   const [employees,setEmployee]=useState([]);

   const navigator=useNavigate();

   useEffect(() => {
    getAllEmployees();
   }, [])

   function getAllEmployees(){
    listEmployee()
    .then((Response)=>
             setEmployee(Response.data)
        )
        .catch((error)=>
            console.error(error)
        )
   }
   
    const addNewEmployee=()=>{
        navigator('/add-employee')
    }
    function updateEmployee(id) {
      navigator(`/edit-employee/${id}`)
    }
    function removeEmployee(id) {
      deleteEmployee(id).then((Response)=>{
        getAllEmployees()
      }).catch(error=>{
        console.log(error);
      })
    }
    
  return (
    <div className='container'>
    <h2 className='text-center'>List of Employees</h2>
    <button className="btn btn-primary mb-2" onClick={addNewEmployee}>Add Employee</button>
    <table className="table table-striped table-bordered">
        <thead>
            <tr>
            <th>ID</th>
            <th>FirstName</th>
            <th>LastName</th> 
            <th>Email</th> 
            <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        {employees.map((obj) => (
                
                <tr>
                <th>{obj.id}</th>
                <td>{obj.firstName}</td>
                <td>{obj.lastName}</td>
                <td>{obj.email}</td>
                <td><button className='btn btn-success' onClick={ () => updateEmployee(obj.id) }>update</button>
                      
                <button style={{marginLeft:'10px'}} className='btn btn-danger' onClick={ () => removeEmployee(obj.id) }>delete</button></td>
                </tr>
               
        ))}
         </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent