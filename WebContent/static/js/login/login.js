/*Controlador angular js*/
angular.module("LoginCtrl",[]).controller("LoginCtrl.loginctrl",function(
		$scope,$http){
	
	
	$scope.showFormLogin = false;
	
	
	$scope.clickBtnIS = function(action){
		if(action === true){
			$scope.showFormLogin = true;
		}
		else{
			$scope.showFormLogin = false;
			$( "#formLogin" ).validate().resetForm();
		}
	};
});

/*jQuery*/
$(function(){
	
    $('#carousel-login').carousel({
    	interval: 5000
	})
    
    /*Validación del formulario de inicio*/
    $("#formLogin").validate({
    	errorElement: "div",
    	errorClass: 'div-validate-error',
        rules: {
            username: {
                required: true,
                minlength: 3
            },
            password: {
                required: true,
                minlength: 3
            }
        },
        messages: {
        	username: {
                required: "Campo requerido",
                phoneUS: "Ingrese un usuario correcto"
            },
            password: {
                required: "Campo requerido",
                minlength: "Ingrese una contraseña correcta"
            }
        },
        errorPlacement: function(error, element) {
        	$(error).css("top", $(element).position().top + 35);
        	error.insertAfter(element);
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
    
});