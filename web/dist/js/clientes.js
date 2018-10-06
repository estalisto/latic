function frm_clientes()
{
   // alert("Url  ="+document.location);
        jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("clientes?accion=agregar",{},function(){ });
}

function clientes()
{       jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("clientes?accion=listar",{},function(){ });
}

function deletecliente(data)
        
{      if(confirm("Realmente desea eliminar los datos")){
    jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
        jQuery("#page-wrapper").load("clientes?accion=eliminar&id=" + data,{},function(){ });
        }
        clientes();
}

function validaDatos(empresa,Tipo_Identificacion,identificacion,razon,direccion, pais, Provincia,Ciudad,contacto,
                        email,fono1,ext, celular,accion){
         
             if(Tipo_Identificacion.length > 1  ){
                 if(identificacion.length > 1 ){
                      if(razon.length > 1 ){
                            if(direccion.length > 0 ){
                                if(pais.length > 1 ){
                                     if(Provincia.length > 1 ){
                                        if(Ciudad.length > 1 ){
                                            if(contacto.length > 1 ){
                                                if(email.length > 1 ){
                                                    if(fono1.length > 1 || celular.length > 1){
                                                            if(ext.length > 1 ){
                                                                
                                                                 return true;
                                                                
                                                            }else{ alert("Debe Ingresar la extension");}  
                                                        }else{ alert("Ingrese al menos un numero de telefono");} 
                                                    }else{ alert("Ingrese un email valido");} 
                                                }else{ alert("Ingrese un contacto");} 
                                            }else{ alert("Debe seleccionar una ciudad");}
                                        }else{ alert("Debe seleccionar una provincia");}
                                    }else{ alert("Debe seleccionar un pais");}
                                }else{ alert("Debe ingresar una direccion");}    
                            }else{ alert("Debe ingresar la razon");}
                        }else{ alert("Debe ingresar Identificacion");}
                    }else{ alert("Debe seleccionar Tipo Identificacion");}
               
   return false; 
}

function ConnsultaDatosID(str)        
{  

  if(confirm("Realmente desea actualizar los datos")){
     jQuery("#page-wrapper").html("<br/><br/><center><img alt='cargando' src='dist/img/hourglass.gif' /><center>"); 
      jQuery("#page-wrapper").load("clientes?accion=buscaID&id=" + str,{},function(){ });
     
    }
    
}

$('#btncrearclientes').click(function(e){
   e.preventDefault();
   var empresa = $("#empresa").val();
   var Tipo_Identificacion = $("#Tipo_Identificacion").val();
   var identificacion = $("#identificacion").val();
   var razon = $("#razon").val();
   var direccion  = $("#direccion").val();
   var pais  = $("#pais").val();
   var Provincia = $("#Provincia").val();
   var Ciudad = $("#Ciudad").val();
   var contacto = $("#contacto").val();
   var email=$("#email").val();
   var fono1  = $("#fono1").val();
   var ext  = $("#ext").val();
   var celular  = $("#celular").val();
   
    var accion = $("#accion").val();
   
   //alert(t_identificacion);
   if(validaDatos(empresa,Tipo_Identificacion,identificacion,razon,direccion, pais, Provincia,Ciudad,contacto,
                        email,fono1,ext, celular,accion)){
      
          var parametros = {
                "accion" : accion,
                "empresa" : empresa,
                "Tipo_Identificacion" : Tipo_Identificacion,
                "identificacion" : identificacion,
                "razon" : razon,
                "direccion" : direccion,
                "pais" : pais,
                "Provincia" : Provincia,
                "Ciudad" : Ciudad,
                "contacto" : contacto,
                "email" : email,
                "fono1" : fono1,
                "ext":ext,
                "celular" : celular };
        $.ajax({
                data:  parametros,
                url:   'clientes',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                            frm_clientes();//vuelvo a llamar a la pantalla
                      }                        
                }
        });
       
       
        
   }
    
});

$('#btnactclientes').click(function(e){
   e.preventDefault();
   
   var empresa = $("#empresa").val();
   var Tipo_Identificacion = $("#Tipo_Identificacion").val();
   var identificacion = $("#identificacion").val();
   var razon = $("#razon").val();
   var direccion  = $("#direccion").val();
   var pais  = $("#pais").val();
   var Provincia = $("#Provincia").val();
   var Ciudad = $("#Ciudad").val();
   var contacto = $("#contacto").val();
   var email=$("#email").val();
   var fono1  = $("#fono1").val();
   var ext  = $("#ext").val();
   var celular  = $("#celular").val();
   
    var accion = $("#accion").val();
   var idcliente= $("#idcliente").val();
   

             var parametros = {
                "idcliente":idcliente,
                "accion" : accion,
                "empresa" : empresa,
                "Tipo_Identificacion" : Tipo_Identificacion,
                "identificacion" : identificacion,
                "razon" : razon,
                "direccion" : direccion,
                "pais" : pais,
                "Provincia" : Provincia,
                "Ciudad" : Ciudad,
                "contacto" : contacto,
                "email" : email,
                "fono1" : fono1,
                "ext":ext,
                "celular" : celular  };
        $.ajax({
                data:  parametros,
                url:   'clientes',
                type:  'GET',
                beforeSend: function () {                      
                } ,
               success:  function (response) {
                      if(response){
                           alert(response);
                           
                           clientes();//vuelvo a llamar a la pantalla
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
