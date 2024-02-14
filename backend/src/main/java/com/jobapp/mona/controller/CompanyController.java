package com.jobapp.mona.controller;
import static com.jobapp.mona.utils.MyConstant.Companylist;
import static com.jobapp.mona.utils.MyConstant.Getcompany;
import static com.jobapp.mona.utils.MyConstant.postcompany;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.mona.service.CompanyService;
import com.jobapp.mona.dto.request.CompanyRequest;
import com.jobapp.mona.dto.response.Basicresponse;
import com.jobapp.mona.dto.response.CompanyResponse;
import com.jobapp.mona.dto.response.RegisterResponse;

import lombok.RequiredArgsConstructor;

@RequestMapping(Companylist)
@RestController
@RequiredArgsConstructor
public class CompanyController {
  private final  CompanyService companyService;
     @GetMapping(Getcompany)
       public ResponseEntity<Basicresponse<CompanyResponse>> create() {
        Basicresponse<CompanyResponse> response=new Basicresponse<>();


           try {
               response=companyService.getAllCompanies();
               return new ResponseEntity<>(response,OK);
           } catch (Exception e) {
               response.setMessage("Something went wrong!");
               return new ResponseEntity<>(response, EXPECTATION_FAILED);
           }
       }

    @PostMapping(postcompany)
    public ResponseEntity<RegisterResponse>register(@RequestBody CompanyRequest request)
    {
        RegisterResponse response=new RegisterResponse();
        try{
            response=companyService.register(request);
            return new ResponseEntity<>(response,ACCEPTED);
        }catch (Exception e)
        {
            System.out.println(e);
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
        
}
}
