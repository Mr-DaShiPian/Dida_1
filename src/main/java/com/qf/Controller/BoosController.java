package com.qf.Controller;

import com.qf.service.BoosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Boos")
public class BoosController {
    @Autowired
    private BoosService boosService;
}
