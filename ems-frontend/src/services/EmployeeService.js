import axios from "axios";


const base_url='http://localhost:9877/api/employees/'

export const listEmployee=() => axios.get(base_url+'getAllEmployees');
export const createEmployee=(employee) => axios.post(base_url+'save',employee);
export const getEmployee=(employeeId) => axios.get(base_url+'get'+'/'+employeeId);
export const updateEmployee=(employeeId,employee) => axios.put(base_url+'update'+'/'+employeeId,employee);
export const deleteEmployee=(employeeId) => axios.delete(base_url+'delete'+'/'+employeeId);

