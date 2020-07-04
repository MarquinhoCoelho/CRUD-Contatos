package br.edu.usj.ads.lpii.helloword;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HelloWord {
@GetMapping(value="helloWord")
public String getHelloWord() {
    return "Hello Word";
}

}