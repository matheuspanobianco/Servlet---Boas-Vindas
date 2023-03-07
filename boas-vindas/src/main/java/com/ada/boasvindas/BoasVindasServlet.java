package com.ada.boasvindas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;

@WebServlet(name = "BoasVindasServlet", value = "/boas-vindas")
public class BoasVindasServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nome = request.getParameter("nome");
        String mensagem;
        int horario = LocalTime.now().getHour();
        if(horario > 6 && horario < 12){
            mensagem = String.format("Bom dia, %s!", nome);
        } else if (horario >= 12 && horario <18) {
            mensagem = String.format("Boa tarde, %s!", nome);
        }else {
            mensagem = String.format("Boa noite, %s!", nome);
        }
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher rd = request.getRequestDispatcher("/mensagem.jsp");
        rd.forward(request, response);

    }
}
