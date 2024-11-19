package unisangil.parcialfinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import unisangil.parcialfinal.models.Transaction;
import unisangil.parcialfinal.services.TransactionsServiceImpl;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    TransactionsServiceImpl transactionsService;

    @GetMapping(path = "")
    public String home(Model model){

        var transactions = transactionsService.getAllIncomes();
        model.addAttribute("transaction", new Transaction());
        return "index";
    }

    @PostMapping("/register")
    public String registrarTransaccion(@ModelAttribute Transaction transaccion, Model model) {
        transaccion.setDate(LocalDateTime.now());
        transactionsService.saveTransaction(transaccion);
        return "redirect:/";
    }

}
