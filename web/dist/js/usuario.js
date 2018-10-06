function frm_usuario()
{
   // alert("Url  ="+document.location);
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("usuarios?accion=agregar",{},function(){ });
}
function usuarios()
{
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("usuarios?accion=listar",{},function(){ });
}
function cambio_clave()
{
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("usuarios?accion=cambio_clave",{},function(){ });
}

function deleteusuario(data)
        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("usuarios?accion=eliminar&id=" + data,{},function(){ });
    usuarios();    
    }
        
}

function validaDatos(sel_cedula,empresa,rol,nusuario,ncontrasenia,observaciones,accion){
        if(sel_cedula.length > 1 ){
            
                if(nusuario.length > 1 ){
                    if(ncontrasenia.length > 1 ){
                        if(observaciones.length > 0 ){
                            return true;
                        }else{ alert("Debe ingresar una observacion");}    
                    }else{ alert("Debe ingresar contraseña");}    
                }else{ alert("Debe ingresar Usuario");}
           
        }else{ alert("Debe ingresar Cedula de empleado");}        
   return false; 
}

function ConnsultaDatosID(str)        
{  

  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("usuarios?accion=buscaID&id=" + str,{},function(){ });
  }
    
}

$('#btncrearusuario').click(function(e){
   e.preventDefault();
   var sel_cedula = $("#sel_cedula").val();
   
   var empresa = $("#empresa").val();
   var rol = $("#rol").val();
   var nusuario = $("#nusuario").val();
   var ncontrasenia  = $("#ncontrasenia").val();
   var observaciones = $("#observaciones").val();
   var accion = $("#accion").val();
   
    if(validaDatos(sel_cedula,empresa,rol,nusuario,ncontrasenia,observaciones,accion)){
      
          var parametros = {
                "accion" : accion,
                "sel_cedula" : sel_cedula,
                
                "empresa" : empresa,
                "rol" : rol,
                "nusuario" : nusuario,
                "ncontrasenia" : ncontrasenia,
                "observaciones" : observaciones };
        $.ajax({
                data:  parametros,
                url:   'usuarios',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                          frm_usuario();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
    }
});

$('#btnactusuario').click(function(e){
   e.preventDefault();
   
   var sel_cedula = $("#sel_cedula").val();
   
   var empresa = $("#empresa").val();
   var rol = $("#rol").val();
   var nusuario = $("#nusuario").val();
   var ncontrasenia  = $("#ncontrasenia").val();
   var observaciones = $("#observaciones").val();
   var accion = $("#accion").val();
   var idusuario= $("#idusuario").val();
   
             var parametros = {
                "idusuario":idusuario,
                 "accion" : accion,
                "sel_cedula" : sel_cedula,
                
                "empresa" : empresa,
                "rol" : rol,
                "nusuario" : nusuario,
                "ncontrasenia" : ncontrasenia,
                "observaciones" : observaciones
                 };
        $.ajax({
                data:  parametros,
                url:   'usuarios',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           usuarios();//vuelvo a llamar a la pantalla
                      }                        
                }
        });  
});
function ValidaSoloNumeros() {
    if ((event.keyCode < 48) || (event.keyCode > 57))
        event.returnValue = false;
}
//Validadacion que los campos sean texto
function txNombres() {
    if ((event.keyCode != 32) && (event.keyCode < 65) || (event.keyCode > 90) && (event.keyCode < 97) || (event.keyCode > 122))
        event.returnValue = false;
}


function validacambio(usuario,newclave,confirmaclave){
    if(usuario !== "" ){
        if(newclave.length > 1){
            if(confirmaclave.length > 1){
                return true;
            }else{alert("Debe ingresar una contraseña");}
        }else{alert("Debe ingresar una contraseña");}
    }else{alert("Debe escoger un usuario");}
    return false;
}

$('#btn-cambio_clave').click(function(e){
   e.preventDefault();
   
   var usuario = $("#usuario").val();
   var newclave = $("#newclave").val();
   var confirmaclave = $("#confirmaclave").val();
   var accion = "cambio";
   
  if(validacambio(usuario,newclave,confirmaclave)) {
                if(newclave === confirmaclave){
                        var parametros = {
                         "usuario":usuario,
                         "newclave" : newclave,
                         "accion":accion
                          };
                         $.ajax({
                         data:  parametros,
                         url:   'usuarios',
                         type:  'GET',
                         beforeSend: function () {                      
                         } ,
                        success:  function (response) {
                               if(response){
                                    alert(response);
                                    cambio_clave();//vuelvo a llamar a la pantalla
                               }                        
                         }
                        });  
                }else{alert("Error Contraseñas no coinciden");}
     }     
});