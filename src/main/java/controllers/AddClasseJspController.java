/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers;

import services.ClassService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;

@SuppressWarnings("serial")
@WebServlet("/AddClasse")
public class AddClasseJspController extends HttpServlet {
    private ClassService classService = new ClassService();
    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            classService.addClass(req);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/administrationPanneau.jsp");
            dispatcher.forward(req, resp);
            //if classname exist in the database we report repeat error, otherwise we add into the DB
//        if(classeName == null){
//
//        }else{
//            System.out.println(classeName);
//        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Search all the info of the class through
            //put the get info into the Request
            //req.setAttribute("helloService", helloService);
            // turn to the add_classe page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/add_classe.jsp");
            dispatcher.forward(req, resp);

    }

}
