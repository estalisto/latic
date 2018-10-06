function frm_empleados()
{
   // alert("Url  ="+document.location);
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("empleados?accion=agregar",{},function(){ });
}

function empleados()
{       jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("empleados?accion=listar",{},function(){ });
}

function deletempleado(data)
        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("empleados?accion=eliminar&id=" + data,{},function(){ });
        }
        empleados();
}

function validaDatos(empresa,t_identificacion,identificacion,nombres,apellidos, lugar_nac, fecha_nac,email,telefono,
                        celular,dir_domicilio,est_civil, genero, profesion,cargo,jefe_directo,observacion,accion){
         
             if(t_identificacion.length > 1  ){
                 if(identificacion.length > 1 ){
                      if(nombres.length > 1 ){
                            if(apellidos.length > 0 ){
                                if(lugar_nac.length > 1 ){
                                     //if(fecha_nac.length > 1 ){
                                        if(email.length > 1 ){
                                            if(celular.length > 1 || telefono.length > 1){
                                                 if(dir_domicilio.length > 1 ){
                                                    if(profesion.length > 1 ){
                                                            return true;
                                                    }else{ alert("Debe ingresar Profesion");}              
                                                }else{ alert("Debe Ingresar la Direccion");}  
                                              }else{ alert("Ingrese al menos un numero de telefono");} 
                                           }else{ alert("Debe Ingresar Email");}
                                        //}else{ alert("Debe ingresar Fecha Nacimiento");}
                                    }else{ alert("Debe ingresar Lugar Nacimiento");}
                                }else{ alert("Debe ingresar Apellidos");}    
                            }else{ alert("Debe ingresar Nombres");}
                        }else{ alert("Debe ingresar Identificacion");}
                    }else{ alert("Debe seleccionar Tipo Identificacion");}
               
   return false; 
}

function ConnsultaDatosID(str)        
{  

  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("empleados?accion=buscaID&id=" + str,{},function(){ });
  }
    
}

$('#btncrearempleados').click(function(e){
   e.preventDefault();
   var empresa = $("#empresa").val();
   var t_identificacion = $("#t_identificacion").val();
   var identificacion = $("#identificacion").val();
   var nombres = $("#nombres").val();
   var apellidos  = $("#apellidos").val();
   var lugar_nac  = $("#lugar_nac").val();
   var fecha_nac = $("#fecha_nac").val();
   var email = $("#email").val();
   var telefono = $("#telefono").val();
   var celular=$("#celular").val();
   var est_civil  = $("#est_civil").val();
   var genero  = $("#genero").val();
   var profesion  = $("#profesion").val();
   var cargo = $("#cargo").val();
   var jefe_directo = $("#jefe_directo").val();
   var dir_domicilio = $("#dir_domicilio").val();
   var observacion = $("#observacion").val();
    var accion = $("#accion").val();
   
   //alert(t_identificacion);
   if(validaDatos(empresa,t_identificacion,identificacion,nombres,apellidos, lugar_nac, fecha_nac,email,telefono,
                        celular,dir_domicilio,est_civil, genero, profesion,cargo,jefe_directo,observacion,accion)){
      
          var parametros = {
                "accion" : accion,
                "empresa" : empresa,
                "t_identificacion" : t_identificacion,
                "identificacion" : identificacion,
                "nombres" : nombres,
                "apellidos" : apellidos,
                "lugar_nac" : lugar_nac,
                "fecha_nac" : fecha_nac,
                "email" : email,
                "telefono" : telefono,
                "celular" : celular,
                "est_civil" : est_civil,
                "genero":genero,
                "profesion" : profesion,
                "cargo" : cargo,
                "jefe_directo" : jefe_directo,
                "dir_domicilio":dir_domicilio,
                "observacion" : observacion };
        $.ajax({
                data:  parametros,
                url:   'empleados',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           frm_empleados();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
       
       
        
   }
    
});

$('#btnactempleados').click(function(e){
   e.preventDefault();
   
   var empresa = $("#empresa").val();
   var t_identificacion = $("#t_identificacion").val();
   var identificacion = $("#identificacion").val();
   var nombres = $("#nombres").val();
   var apellidos  = $("#apellidos").val();
   var lugar_nac  = $("#lugar_nac").val();
   var fecha_nac = $("#fecha_nac").val();
   var email = $("#email").val();
   var telefono = $("#telefono").val();
   var celular=$("#celular").val();
   var est_civil  = $("#est_civil").val();
   var genero  = $("#genero").val();
   var profesion  = $("#profesion").val();
   var cargo = $("#cargo").val();
   var jefe_directo = $("#jefe_directo").val();
   var dir_domicilio = $("#dir_domicilio").val();
   var observacion = $("#observacion").val();
    var accion = $("#accion").val();
   var idempleado= $("#idempleado").val();
   

             var parametros = {
                "idempleado":idempleado,
                "accion" : accion,
                "empresa" : empresa,
                "t_identificacion" : t_identificacion,
                "identificacion" : identificacion,
                "nombres" : nombres,
                "apellidos" : apellidos,
                "lugar_nac" : lugar_nac,
                "fecha_nac" : fecha_nac,
                "email" : email,
                "telefono" : telefono,
                "celular" : celular,
                "est_civil" : est_civil,
                "genero":genero,
                "profesion" : profesion,
                "cargo" : cargo,
                "jefe_directo" : jefe_directo,
                "dir_domicilio":dir_domicilio,
                "observacion" : observacion  };
        $.ajax({
                data:  parametros,
                url:   'empleados',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           
                           empleados();//vuelvo a llamar a la pantalla
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
