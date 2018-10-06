/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function frm_agencia()
{
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("agencia?accion=agregar",{},function(){ });
}
function agencia()
{       jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("agencia?accion=listar",{},function(){ });
}

function deleteagencia(data)
        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("agencia?accion=eliminar&id=" + data,{},function(){ });
        }
        agencia();
}

function validaDatos(empresa,nombre,opcion,direccion,telefono,telefono2,celular,mail,accion){
         
             if(opcion.length > 1  ){
                 if(nombre.length > 1 ){
                      if(direccion.length > 1 ){
                          if(mail.length > 1 ){
                            if(celular.length > 1 || telefono2.length > 1 || telefono.length > 1 ){
                                         
                                             return true;
                                           
                                     }else{ alert("Debe Ingresar al menos 1 Télefono");}  
                                      }else{ alert("Debe Ingresar un correo");} 
                       }else{ alert("Debe ingresar una Direccion");}    
                    }else{ alert("Debe ingresar un Nombre");}
             }else{ alert("Debe elegir tipo de Agencia");}
           
   return false; 
}

function ConnsultaDatosID(str)        
{  

  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("agencia?accion=buscaID&id=" + str,{},function(){ });
  }
    
}


$('#btncrearagencia').click(function(e){
   e.preventDefault();
   
   var empresa = $("#empresa").val();
   var nombre  = $("#nombre").val();
   var opcion = $("#opcion").val();
   var direccion = $("#direccion").val();
   var telefono = $("#telefono").val();
   var telefono2  = $("#telefono2").val();
   var celular = $("#celular").val();
   var mail  = $("#mail").val();
   var accion =$("#accion").val();
   
   if(validaDatos(empresa,nombre,opcion,direccion,telefono,telefono2,celular,mail,accion)){
      
          var parametros = {
                "accion":accion,
                "empresa" : empresa,
                "nombre" : nombre,
                "opcion" : opcion,
                "direccion" : direccion,
                "telefono" : telefono,
                "telefono2" : telefono2,
                "celular" : celular,
                "mail" : mail
                
                 };
        $.ajax({
                data:  parametros,
                url:   'agencia',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           frm_agencia();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
       
       
        
   }
    
});

$('#btnactagencia').click(function(e){
   e.preventDefault();
   
   var empresa = $("#empresa").val();
   var nombre  = $("#nombre").val();
   var opcion = $("#opcion").val();
   var direccion = $("#direccion").val();
   var telefono = $("#telefono").val();
   var telefono2  = $("#telefono2").val();
   var celular = $("#celular").val();
   var mail  = $("#mail").val();
   var accion =$("#accion").val();
   var idagencia= $("#idagencia").val();
   

             var parametros = {
                "idagencia":idagencia,
                "accion":accion,
                "empresa" : empresa,
                "nombre" : nombre,
                "opcion" : opcion,
                "direccion" : direccion,
                "telefono" : telefono,
                "telefono2" : telefono2,
                "celular" : celular,
                "mail" : mail };
        $.ajax({
                data:  parametros,
                url:   'agencia',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           
                           agencia();//vuelvo a llamar a la pantalla
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


