<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript">
			function send(){
				//Se genera la conexión con el socket y se envía la información del usuario que se quiera refrescar
				alert("${usuario}");
			}
			
			
			var wsUri = "ws://" + document.location.host + "/SpringSecurity/" + "whiteboardendpoint";
			var websocket = new WebSocket(wsUri);
			alert(wsUri);
			websocket.onmessage = function(evt){
				alert("Llegó un mensaje");
// 			    onMessage(evt);
			};

			function sendText(json){
			    console.log("sending text: " + json);
			    websocket.send(json);
			}

			function onMessage(evt){
			    console.log("recived: " + evt.data);
			    drawImageText(evt.data);
			}

			websocket.onerror = function(evt){
				alert("error: " + evt);
			};

			function onError(evt){
			    //writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
			    alert('<span style="color: red;">ERROR:</span> ' + evt.data);
			}

			
		</script> 
	</head>
	<body onload="send()"></body>
</html>

