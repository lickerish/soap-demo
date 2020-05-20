package pl.lickerish.soapdemo.employee;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {

    private EmployeeService employeeService;

    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PayloadRoot(namespace = "http://www.lickerish.com/soap", localPart = "getEmployee")
    @ResponsePayload
    public GetResponse getEmployee(@RequestPayload GetEmployee getEmployee) {
        Employee employeeById = employeeService.getEmployeeById(getEmployee.getId());
        GetResponse getResponse = new GetResponse();
        getResponse.setEmployee(employeeById);
        return getResponse;
    }
}
