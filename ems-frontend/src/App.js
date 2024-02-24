import './App.css';
import EmployeeComponent from './components/EmployeeComponent';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import { Route,Routes } from 'react-router-dom';

function App() {
  return (
   <>
      <HeaderComponent/>

      <Routes>
        <Route path='/' element={ <ListEmployeeComponent/>}></Route>
        <Route path='/employees' element={ <ListEmployeeComponent/>}></Route>
        <Route path='/add-employee' element={ <EmployeeComponent/> }></Route>
        <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
      </Routes>
      <br></br>
      <br></br>
      <FooterComponent/>
   </>
  );
}

export default App;
