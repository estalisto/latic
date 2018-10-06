function frm_empresa()
{
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("empresa?accion=agregar",{},function(){ });
}
function empresa()
{       jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("empresa?accion=listar",{},function(){ });
}

function deletempresa(data)
        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("empresa?accion=eliminar&id=" + data,{},function(){ });
        }
        empresa();
}

function validaDatos(celular,telefono2,telefono,mail,direccion,ciudad,provincia,pais,nombre,identificacion,t_identificacion,accion){
         if(t_identificacion.length > 1 ){
             if(identificacion.length > 1  ){
                 if(nombre.length > 1 ){
                      if(pais.length > 1 ){
                            if(provincia.length > 0 ){
                                if(ciudad.length > 1 ){
                                     if(direccion.length > 1 && direccion.length < 100 ){
                                         if(celular.length > 1 || telefono2.length > 1 || telefono.length > 1 ){
                                             return true;
                                           }else{ alert("Debe Ingresar al menos 1 Télefono");}  
                                     }else{ alert("Ingrese el campo Dirección");}  
                                 }else{ alert("Debe seleccionar una Ciudad");}
                           }else{ alert("Debe seleccionar una Provincia");}
                       }else{ alert("Debe seleccionar una País");}    
                    }else{ alert("Debe ingresar Nombre");}
             }else{ alert("Debe ingresar3 Identificación");}
         }else{ alert("Debe seleccionar una Tipo Identificación");}        
   return false; 
}

function ConnsultaDatosID(str)        
{  

  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("empresa?accion=buscaID&id=" + str,{},function(){ });
  }
    
}

$('#btncrearempresa').click(function(e){
   e.preventDefault();
   var celular = $("#celular").val();
   var telefono2  = $("#telefono2").val();
   var telefono = $("#telefono").val();
   var mail = $("#mail").val();
   var direccion = $("#direccion").val();
   var ciudad  = $("#ciudad").val();
   var provincia = $("#provincia").val();
   var pais  = $("#pais").val();
   var nombre = $("#nombre").val();
   var identificacion = $("#identificacion").val();
   var t_identificacion = $("#t_identificacion").val();
   var accion = $("#accion").val();
   var sucursal='1';
   //alert(t_identificacion);
   if(validaDatos(celular,telefono2,telefono,mail,direccion,ciudad,provincia,pais,nombre,identificacion,t_identificacion,accion)){
      
          var parametros = {
                "accion" : accion,
                "t_identificacion" : t_identificacion,
                "identificacion" : identificacion,
                "nombre" : nombre,
                "pais" : pais,
                "provincia" : provincia,
                "ciudad" : ciudad,
                "direccion" : direccion,
                "mail" : mail,
                "telefono" : telefono,
                "telefono2" : telefono2,
                "celular":celular,
                "sucursal" : sucursal };
        $.ajax({
                data:  parametros,
                url:   'empresa',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           frm_empresa();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
       
       
        
   }
    
});

$('#btnactempresa').click(function(e){
   e.preventDefault();
   
   var celular = $("#celular").val();
   var telefono2  = $("#telefono2").val();
   var telefono = $("#telefono").val();
   var mail = $("#mail").val();
   var direccion = $("#direccion").val();
   var ciudad  = $("#ciudad").val();
   var provincia = $("#provincia").val();
   var pais  = $("#pais").val();
   var nombre = $("#nombre").val();
   var identificacion = $("#identificacion").val();
   var t_identificacion = $("#t_identificacion").val();
   var accion = $("#accion").val();
   var sucursal='1';
   var idempresa= $("#idempresa").val();
   //alert(t_identificacion);
             var parametros = {
                "idempresa":idempresa,
                "accion" : accion,
                "t_identificacion" : t_identificacion,
                "identificacion" : identificacion,
                "nombre" : nombre,
                "pais" : pais,
                "provincia" : provincia,
                "ciudad" : ciudad,
                "direccion" : direccion,
                "mail" : mail,
                "telefono" : telefono,
                "telefono2" : telefono2,
                "celular":celular,
                "sucursal" : sucursal 
                
                 };
        $.ajax({
                data:  parametros,
                url:   'empresa',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           empresa();//vuelvo a llamar a la pantalla
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



