<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkServletEntrada" />

<!DOCTYPE html>
<html>
<head>
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>


<body class="grey lighten-3">

<c:import url="parcialLogout.jsp"/>


    <h1 class="main-title center">Bem-vindo ao Sistema De Cadastro De Robôs</h1>

    <div class="row center" >
        <div class="col s12 m4 l4 waves-effect waves-light">
          
          
           <a href="javascript:novo.submit()">
             
                <div class="card-panel hoverable z-depth-1 center grey lighten-4" >
                    <i class="large material-icons">input</i>
                    <div class="truncate">Cadastrar Robo</div>
                </div>
   				<form name='novo' action="${linkServletEntrada}" method="post" >
					<input type="hidden" name="action" value="NovoRoboForm">
				</form>
           
            </a>
        </div>
        
        
        <div class="col s12 m4 l4 waves-effect waves-light">    
           <a href="javascript:geo.submit()">          
                <div class="card-panel hoverable z-depth-1 center grey lighten-4" >
                    <i class="large material-icons">my_location</i>
                    <div class="truncate">Pesquisar por Geolocalizacao</div>
                </div>
   				<form name='geo' action="${linkServletEntrada}" method="post" >
					<input type="hidden" name="action" value="Geolocal">
				</form>      
            </a>
        </div>
        
        	
        
        
          <div class="col s12 m4 l4 waves-effect waves-light">
   			 <a href="javascript:lista.submit()">
	       		 <div class="card-panel hoverable z-depth-1 center grey lighten-4">
		            <i class="large material-icons">list</i>
		            <div class="truncate">Lista dos Robos</div>
	       		 </div>
	        
	        		<form name='lista' action="${linkServletEntrada}" method="post" >
						<input type="hidden" name="action" value="ListaRobos">
					</form>
    		</a>
		</div>
				
    </div>
  
  



<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
</body>
</html>