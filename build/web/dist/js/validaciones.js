/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function AJAX()
{
    var xRequest = null;
    if (window.XMLHttpRequest) {
        xRequest = new XMLHttpRequest();
    } else if (typeof ActiveXObject !== "undefined") {
        xRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xRequest;
}

//document.getElementById("guardar").disabled = true;
$('#cedula_valida').on('click', function () {
//   alert("Hola"); 
    var cedula = $('#sel_cedula').val();
    //var empresa =$('#empresa').val();
    var ajax = AJAX();
    ajax.open("POST", "usuarios?", true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState === 4) {
            if (ajax.status === 200)
            {

                var valor = ajax.responseText;
                    
                    
                    
                  if($.trim(valor) !== ""){
                      $('#not_found').css("display", "block");
                      $('#found').css("display", "none");
                     document.getElementById("sel_cedula").disabled = true;
                    // document.getElementById("empresa").disabled = false;
                     document.getElementById("rol").disabled = false;
                     document.getElementById("nusuario").disabled = false;  
                     document.getElementById("ncontrasenia").disabled = false;
                     document.getElementById("observaciones").disabled = false;
                     document.getElementById("btncrearusuario").disabled = false;
                    //
                   // function myFunction() {
                            var x = document.getElementById("empresa");
                            //var option = document.createElement("option");
                            //option.text = valor;
                            //x.add(option, x[0]);
                            //x.appendChild(option);
                            x.value = parseInt(valor);
                        //}
                    //llenar select 
                    
                     
                  }else{
                     $('#not_found').css("display", "none"); 
                     $('#found').css("display", "block"); 
                     document.getElementById("sel_cedula").disabled = false;
                      document.getElementById("empresa").disabled = true;
                      document.getElementById("rol").disabled = true;
                      document.getElementById("nusuario").disabled = true;  
                      document.getElementById("ncontrasenia").disabled = true;
                     document.getElementById("observaciones").disabled = true;
                      document.getElementById("btncrearusuario").disabled = true;
                  }

            }
        }
    };
    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    ajax.send('accion=validar&identificacion=' + cedula);
    
});

$('#nombre_valida').on('click', function () {
 
    var nombre = $('#nombre').val();
    var ajax = AJAX();
    ajax.open("POST", "sectores?", true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState === 4) {
            if (ajax.status === 200)
            {

                var valor = ajax.responseText;
                    //alert(valor);
                  if($.trim(valor) === "true"){
                      $('#not_found').css("display", "block");
                      $('#found').css("display", "none");
                      document.getElementById("descrip").disabled = true;
                     document.getElementById("guardar").disabled = true;
                      
                     
                  }else{
                     $('#not_found').css("display", "none"); 
                     $('#found').css("display", "block"); 
                     document.getElementById("descrip").disabled = false;
                    document.getElementById("guardar").disabled = false;
                  }

            }
        }
    };
    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    ajax.send('accion=validar&nombre=' + nombre);
    
});

$('#parametro_valida').on('click', function () {
 
    var parametro = $('#nombre').val();
    var ajax = AJAX();
    ajax.open("POST", "parametros?", true);
    ajax.onreadystatechange = function () {
        if (ajax.readyState === 4) {
            if (ajax.status === 200)
            {

                var valor = ajax.responseText;
                    //alert(valor);
                  if($.trim(valor) === "true"){
                      $('#not_found').css("display", "block");
                      $('#found').css("display", "none");
                      document.getElementById("valor").disabled = true;
                     document.getElementById("guardar").disabled = true;
                      
                     
                  }else{
                     $('#not_found').css("display", "none"); 
                     $('#found').css("display", "block"); 
                     document.getElementById("valor").disabled = false;
                    document.getElementById("guardar").disabled = false;
                  }

            }
        }
    };
    ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    ajax.send('accion=validar&parametro=' + parametro);
    
});
$('#nusuario').on('change','input', function () {
    var usuario = ('#nusuario').val();
    alert(usuario);
});

//Validacion de correos 
function validarEmail(valor) {
    if (/^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i.test(valor)){
     alert("La dirección de email " + valor + " es correcta!.");
    } else {
     alert("La dirección de email es incorrecta!.");
    }
};
    
// Validacion que campos sean numericos
function ValidaSoloNumeros() {
    if ((event.keyCode < 48) || (event.keyCode > 57))
        event.returnValue = false;
}
//Validadacion que los campos sean texto
function txNombres() {
    if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))
        event.returnValue = false;
}

